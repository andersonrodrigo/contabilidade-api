package br.com.memory.contabilidade.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.memory.contabilidade.dto.EventoLancamentoDTO;
import br.com.memory.contabilidade.model.Contabilizacao4320;
import br.com.memory.contabilidade.model.PlanoContasMemory;

public class Contabilizacao4320RepositoryImpl implements Contabilizacao4320RepositoryCustom {

	@Autowired
	Contabilizacao4320Repository contabilizacao4320Repository;
	
	@Autowired
	EventoLancamentoRepository eventoRepository;

	public Boolean criaLancamentoContabilSemEvento(EventoLancamentoDTO evento, Contabilizacao4320 contabilizacao)
	{
		Long transacaoContabil = (long) 0;
		Long numeroLancamentoContabil = contabilizacao4320Repository.retornaProximoLancamentoContabil();
		
		for(Integer j=1; j < 3; j++)
		{
			transacaoContabil++;	
			
			if(evento.getHistoricoEvento().trim().length() > 0)
				contabilizacao.setDescricaoHistorico(evento.getHistoricoEvento());
			
			if(j == 1)
			{
				if(evento.getCodigoCtcontabcred().trim().length() == 0)
					continue;
				
				//contabilizacao.setIdtDebcred(-1 * (evento.getValorLancamento().compareTo(0) < 0  ? -1 : 1));
				contabilizacao.setIdtDebcred(-1);
				contabilizacao.setPlanoContasMemory(PlanoContasMemory.builder().
															codigoCtcontab(evento.getCodigoCtcontabcred()).build());
			}
			else
			{
				if(evento.getCodigoCtcontabdeb().trim().length() == 0)
					continue;
				
				//contabilizacao.setIdtDebcred((long) 1 * (evento.getValorLancamento() < valorZero ? -1 : 1));
				contabilizacao.setIdtDebcred(1);
				contabilizacao.setPlanoContasMemory(PlanoContasMemory.builder().
															codigoCtcontab(evento.getCodigoCtcontabdeb()).build());
			}
			
			contabilizacao.setSequencialCtcontablanc(contabilizacao4320Repository.retornaProximoIdContabilizacao() + 1);
			contabilizacao.setNumeroTranscontabil(transacaoContabil);
			contabilizacao.setNumeroLanccontab(numeroLancamentoContabil);
			contabilizacao.setDataLastrec((new Timestamp(System.currentTimeMillis())));
		
			contabilizacao4320Repository.save(contabilizacao);
		}
		
		return true;
	}

	
	public Boolean criaLancamentoContabil(Long codigoGrupoEvento, Long codigoSubGrupoEvento, Long codigoEvento,
										  Contabilizacao4320 contabilizacao) {

		List<EventoLancamentoDTO> listaEvento = eventoRepository.pesquisarEvento(codigoGrupoEvento, 
																				 codigoSubGrupoEvento, 
																				 codigoEvento);
		
		
		for (EventoLancamentoDTO conta : listaEvento) 
		{
			criaLancamentoContabilSemEvento(conta, contabilizacao);
		}
		
		return true;
	}
}
