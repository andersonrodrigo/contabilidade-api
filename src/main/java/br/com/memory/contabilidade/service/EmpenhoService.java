package br.com.memory.contabilidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memory.contabilidade.dto.EmpenhoDTO;
import br.com.memory.contabilidade.model.Empenho;
import br.com.memory.contabilidade.model.Entidade;
import br.com.memory.contabilidade.model.Id.EmpenhoId;
import br.com.memory.contabilidade.repository.EmpenhoRepository;

@Service
public class EmpenhoService {
	@Autowired
	EmpenhoRepository empenhoRepository;
	
	public EmpenhoDTO salvarEmpenho(EmpenhoDTO empenhoDTO) {
		empenhoRepository.salvarEmpenho(empenhoDTO);
		return empenhoDTO;
	}

	public EmpenhoDTO pesquisaEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) throws Exception {
		EmpenhoId empenhoId = EmpenhoId.builder().
								entidade(Entidade.builder().codigoEntidade(codigoEntidade).build()).
								numeroSerieempenho(serieEmpenho).
								numeroEmpenho(numeroEmpenho).build();
		
		Optional<Empenho> optionalEmpenho = empenhoRepository.findById(empenhoId);
		
		Empenho emp = optionalEmpenho.orElseThrow(() -> new Exception());
		
		EmpenhoDTO empenhoDTO = EmpenhoDTO.builder().NumeroEmpenho(emp.getIdEmpenho().getNumeroEmpenho()).
													idtTipoempenho(emp.getIdtTipoempenho()).
													nomeCredor(emp.getCredor().getIdCredor().getCadastroUnico().getDescricaoNome()).build();
		return empenhoDTO;
	}

	public EmpenhoDTO pesquisaEmpenhoContabilizacao(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) throws Exception {
		return empenhoRepository.pesquisarLancamentoEmpenho(codigoEntidade, serieEmpenho, numeroEmpenho);
	}

	public List<EmpenhoDTO> pesquisaListaEmpenho(Long codigoEntidade, Long serieEmpenho) throws Exception {
		return empenhoRepository.pesquisarListaEmpenho(codigoEntidade, serieEmpenho);
	}

	public void excluirEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) throws Exception {
		empenhoRepository.excluirEmpenho(codigoEntidade, serieEmpenho, numeroEmpenho);
	}
}
