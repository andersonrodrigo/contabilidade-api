package br.com.memory.contabilidade.repository;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.memory.contabilidade.dto.EmpenhoDTO;
import br.com.memory.contabilidade.model.AnoFiscal;
import br.com.memory.contabilidade.model.CadastroUnico;
import br.com.memory.contabilidade.model.Contabilizacao4320;
import br.com.memory.contabilidade.model.Credor;
import br.com.memory.contabilidade.model.Empenho;
import br.com.memory.contabilidade.model.EmpenhoItem;
import br.com.memory.contabilidade.model.Entidade;
import br.com.memory.contabilidade.model.FonteRecurso;
import br.com.memory.contabilidade.model.GrupoEntidadeCompras;
import br.com.memory.contabilidade.model.ModalidadeLicitacao;
import br.com.memory.contabilidade.model.NaturezaDespesa;
import br.com.memory.contabilidade.model.OrcamentoDespesa;
import br.com.memory.contabilidade.model.PlanoContasPCASP;
import br.com.memory.contabilidade.model.Id.CredorId;
import br.com.memory.contabilidade.model.Id.EmpenhoId;
import br.com.memory.contabilidade.model.Id.EmpenhoItemId;
import br.com.memory.contabilidade.model.Id.ModalidadeLicitacaoId;
import br.com.memory.contabilidade.model.Id.NaturezaDespesaId;

public class EmpenhoRepositoryImpl implements EmpenhoRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	EmpenhoRepository empenhoRepository;

	@Autowired
	Contabilizacao4320Repository contabilizacaoRepository;

	@Autowired
	FonteRecursoRepository fonteRecursoRepository;

	@Autowired
	OrcamentoDespesaRepository orcamentoDespesaRepository;

	@Autowired
	EmpenhoItemRepository empenhoItemRepository;

	@Autowired
	PlanoContasPCASPRepository pcaspRepository;

	@Autowired
	AnoFiscalRepository anofiscalRepository;

	public void salvarEmpenho(EmpenhoDTO empenhoDTO) {
		Empenho empenho;
		
		AnoFiscal anoFiscal = anofiscalRepository.findById(empenhoDTO.getSerieEmpenho()).orElse(new AnoFiscal());
		PlanoContasPCASP vpd = pcaspRepository.retornaIDPlanoContas(empenhoDTO.getCodigoVPD(), 
			      		       										 anoFiscal.getVersaoPCASP().getIdVersao());

		/* Empenho */
		empenho = 
			Empenho.builder().
				idEmpenho(EmpenhoId.builder().
							entidade(Entidade.builder().
										codigoEntidade(empenhoDTO.getCodigoEntidade()).
								     build()).
						numeroEmpenho(empenhoDTO.getNumeroEmpenho()).
						numeroSerieempenho(empenhoDTO.getSerieEmpenho()).
				build()).
				credor(Credor.builder().
						  		idCredor(CredorId.builder().
						  				cadastroUnico(CadastroUnico.builder().numeroCadastroUnico(
						  						empenhoDTO.getCodigoCredor()).
						  				build()).
						  		build()).
				build()).
				dataEmpenho(empenhoDTO.getDataEmpenho()).
				dataLastrec(new Timestamp(System.currentTimeMillis())).
				codigoUsuario(empenhoDTO.getCodigoUsuario()).
				modalidadeLicitacao(ModalidadeLicitacao.builder().
						idModalidadeLicitacao(ModalidadeLicitacaoId.builder().
								grupoEntidadeCompras(GrupoEntidadeCompras.builder().
														codigoGrupoentidade(empenhoDTO.getCodigoGrupoEntidadeCompras()).
													 build()).
								codigoModalidadelicitacao(empenhoDTO.getCodigoModalidadeLicitacao()).
						build()).
				build()).
				idtTipoempenho(empenhoDTO.getIdtTipoempenho()).
				flagPessoal(empenhoDTO.getFlagPessoal()).
				flagExcdesptotal(empenhoDTO.getFlagExcdesptotal()).
				//idtHistorico(empenhoDTO.getIdtHistorico()).
				contaVPD(vpd).
		build();
		
		empenhoRepository.save(empenho);
		
		/* Histórico do Empenho */
		EmpenhoItem empenhoItem = 
								EmpenhoItem.builder().
										idEmpenhoItem(EmpenhoItemId.builder().
															empenho(empenho).
															numeroItem((long) 0).
													  build()).
										descricaoItem(empenhoDTO.getHistoricoEmpenho().getBytes(StandardCharsets.UTF_8)).
										codigoUsuario(empenhoDTO.getCodigoUsuario()).
										dataLastrec(new Timestamp(System.currentTimeMillis())).
								 build();
			
		
		empenhoItemRepository.save(empenhoItem);
		
		FonteRecurso fonteRecursoExecucao = fonteRecursoRepository.retornaFonteRecurso(
															empenhoDTO.getSerieEmpenho(), 
															empenhoDTO.getFonteRecursoExecucao());

		OrcamentoDespesa orcamentoDespesa = orcamentoDespesaRepository.retornaOrcamentoDespesaPorficha(
															empenhoDTO.getSerieEmpenho(), 
															empenhoDTO.getFichaOrcamento(), 
															empenhoDTO.getFonteRecursoExecucao(), 
															empenhoDTO.getCodigoEntidade());

		/* Lançamento Contábil */
		Contabilizacao4320 contabilizacao = 
				Contabilizacao4320.builder().
					empenho(empenho).
					dataLancamento(empenhoDTO.getDataEmpenho()).
					valorLancamento(empenhoDTO.getValorEmpenho()).
					naturezaDespesa(
							NaturezaDespesa.builder().
								idNaturezaDespesa(NaturezaDespesaId.builder().
										anoFiscal(anoFiscal).
										codigoDespesa(empenhoDTO.getNaturezaDespesaExecucacao()).
								build()).
							build()).
					fonteRecurso(fonteRecursoExecucao).
					orcamentoDespesa(orcamentoDespesa).
					codigoDespesa(empenhoDTO.getNaturezaDespesaExecucacao()).
				build();
		
		contabilizacaoRepository.criaLancamentoContabil((long) 4, (long) 1, (long) 1, contabilizacao);
	}

	public void excluirEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) {
		EmpenhoId empenhoId = EmpenhoId.builder().
									entidade(Entidade.builder().
													codigoEntidade(codigoEntidade).
											  build()).
									numeroEmpenho(numeroEmpenho).
									numeroSerieempenho(serieEmpenho).
								build();
									
		empenhoRepository.deleteById(empenhoId);
	}
	
	public EmpenhoDTO pesquisarLancamentoEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) throws UnsupportedEncodingException {

		Contabilizacao4320 contab;
		
		Map<String, Object> parametros = new HashMap<String, Object>();

		String hql = "select "
					+ "		contab "
					+ "from "
					+ "		Contabilizacao4320 contab "
					+ "where "
					+ "		planoContasMemory.codigoCtcontab = :codigoCtContab and "
					+ "		empenho.idEmpenho.entidade.codigoEntidade = :codigoEntidade and "
					+ "		empenho.idEmpenho.numeroSerieempenho = :numeroSerieempenho and "
					+ "		empenho.idEmpenho.numeroEmpenho = :numeroEmpenho ";

		parametros.put("codigoCtContab", "4.2.2.01.01.00");
		parametros.put("codigoEntidade", codigoEntidade);
		parametros.put("numeroSerieempenho", serieEmpenho);
		parametros.put("numeroEmpenho", numeroEmpenho);

		TypedQuery<Contabilizacao4320> query = entityManager.createQuery(hql, Contabilizacao4320.class);
		query.setMaxResults(1);
		parametros.keySet().forEach(p -> query.setParameter(p, parametros.get(p)));
		
		contab = (Contabilizacao4320) query.getSingleResult();
		
		EmpenhoDTO empenhoDTO = 
				EmpenhoDTO.builder().
							 dataEmpenho(contab.getDataLancamento()).
						 	 valorEmpenho(contab.getValorLancamento()).
						 	 codigoEntidade(contab.getEmpenho().getIdEmpenho().getEntidade().getCodigoEntidade()).
						 	 NumeroEmpenho(contab.getEmpenho().getIdEmpenho().getNumeroEmpenho()).
						 	 serieEmpenho(contab.getEmpenho().getIdEmpenho().getNumeroSerieempenho()).
						 	 codigoCredor(contab.getEmpenho().getCredor().getIdCredor().getCadastroUnico().getNumeroCadastroUnico()).
						 	 nomeCredor(contab.getEmpenho().getCredor().getIdCredor().getCadastroUnico().getDescricaoNome()).
						 	 codigoGrupoEntidadeCompras(contab.getEmpenho().getModalidadeLicitacao().getIdModalidadeLicitacao().getGrupoEntidadeCompras().getCodigoGrupoentidade()).
						 	 codigoModalidadeLicitacao(contab.getEmpenho().getModalidadeLicitacao().getIdModalidadeLicitacao().getCodigoModalidadelicitacao()).
						 	 idtTipoempenho(contab.getEmpenho().getIdtTipoempenho()).
						 	 flagPessoal(contab.getEmpenho().getFlagPessoal()).
						 	 idtTipodespesa(contab.getEmpenho().getIdtTipodespesa()).
						 	 flagDespesaimpugnada(contab.getEmpenho().getFlagDespesaimpugnada()).
							 fichaOrcamento(contab.getOrcamentoDespesa().getCodigoFicha()).
							 unidadeOrcamentaria(contab.getOrcamentoDespesa().getUnidadeOrcamentaria().getIdUnidadeOrcamentaria().getCodigoUnidadeOrcamentaria()).
							 descricaoUnidadeOrcamentaria(contab.getOrcamentoDespesa().getUnidadeOrcamentaria().getDescricaoUnidadeorc()).
							 funcionalProgramatica(
								contab.getOrcamentoDespesa().getUnidadeOrcamentaria().
									   getIdUnidadeOrcamentaria().getCodigoUnidadeOrcamentaria() + "." +
								contab.getOrcamentoDespesa().getFuncao().getIdFuncao().getCodigoFuncao() + "." +
								contab.getOrcamentoDespesa().getSubFuncao().getIdSubFuncao().getCodigoSubfuncao() + "." +
								contab.getOrcamentoDespesa().getPrograma().getIdPrograma().getCodigoPrograma() + "." +
								contab.getOrcamentoDespesa().getProjetoAtividade().getIdProjetoAtividade().getCodigoProjetoatividade()).
							 naturezaDespesa(contab.getOrcamentoDespesa().getNaturezaDespesa().getIdNaturezaDespesa().getCodigoDespesa()).
							 descricaoNaturezaDespesa(contab.getOrcamentoDespesa().getNaturezaDespesa().getDescricaoDespesa()).
							 naturezaDespesaExecucacao(contab.getNaturezaDespesa().getIdNaturezaDespesa().getCodigoDespesa()).
							 codigoVPD(contab.getEmpenho().getContaVPD().getCodigoConta()).
							 descricaoNaturezaDespesaExecucao(contab.getNaturezaDespesa().getDescricaoDespesa()).
							 fonteRecurso(contab.getOrcamentoDespesa().getFonteRecurso().getCodigoFonterecursodestinacao()).
							 descricacaoRecurso(contab.getOrcamentoDespesa().getFonteRecurso().getDescricaoFonterecurso()).
							 fonteRecursoExecucao(contab.getFonteRecurso().getCodigoFonterecursodestinacao()).
							 historicoEmpenho(new String(contab.getEmpenho().getEmpenhoItems().get(0).getDescricaoItem(), "UTF8")).
							 descricacaoRecursoExecucao(contab.getFonteRecurso().getDescricaoFonterecurso()).build();
		
		return empenhoDTO;						 			   
	}

	public List <EmpenhoDTO> pesquisarListaEmpenho(Long codigoEntidade, Long serieEmpenho) {
		List <Contabilizacao4320> listaEmpenho;
		List<EmpenhoDTO> listaEmpenhoDTO = new ArrayList<>();

		Map<String, Object> parametros = new HashMap<String, Object>();

		String hql = "select "
					+ "		contab "
					+ "from "
					+ "		Contabilizacao4320 contab "
					+ "where "
					+ "		planoContasMemory.codigoCtcontab = :codigoCtContab and "
					+ "		empenho.idEmpenho.entidade.codigoEntidade = :codigoEntidade and "
					+ "		empenho.idEmpenho.numeroSerieempenho = :numeroSerieempenho ";

		parametros.put("codigoCtContab", "4.2.2.01.01.00");
		parametros.put("codigoEntidade", codigoEntidade);
		parametros.put("numeroSerieempenho", serieEmpenho);

		TypedQuery<Contabilizacao4320> query = entityManager.createQuery(hql, Contabilizacao4320.class);
		parametros.keySet().forEach(p -> query.setParameter(p, parametros.get(p)));
		
		listaEmpenho = query.getResultList();
		
		listaEmpenho.stream().forEach(empenho -> {
			listaEmpenhoDTO.add(EmpenhoDTO.builder().
					 dataEmpenho(empenho.getDataLancamento()).
				 	 valorEmpenho(empenho.getValorLancamento()).
				 	 codigoEntidade(empenho.getEmpenho().getIdEmpenho().getEntidade().getCodigoEntidade()).
				 	 NumeroEmpenho(empenho.getEmpenho().getIdEmpenho().getNumeroEmpenho()).
				 	 serieEmpenho(empenho.getEmpenho().getIdEmpenho().getNumeroSerieempenho()).
					 nomeCredor(empenho.getEmpenho().getCredor().getIdCredor().getCadastroUnico().getDescricaoNome()).
					 fichaOrcamento(empenho.getOrcamentoDespesa().getCodigoFicha()).
					 funcionalProgramatica(
						   empenho.getOrcamentoDespesa().getUnidadeOrcamentaria().
						   getIdUnidadeOrcamentaria().getCodigoUnidadeOrcamentaria() + "." +
						   empenho.getOrcamentoDespesa().getFuncao().getIdFuncao().getCodigoFuncao() + "." +
						   empenho.getOrcamentoDespesa().getSubFuncao().getIdSubFuncao().getCodigoSubfuncao() + "." +
						   empenho.getOrcamentoDespesa().getPrograma().getIdPrograma().getCodigoPrograma() + "." +
						   empenho.getOrcamentoDespesa().getProjetoAtividade().getIdProjetoAtividade().
					       getCodigoProjetoatividade()).
					 naturezaDespesa(empenho.getOrcamentoDespesa().getNaturezaDespesa().getIdNaturezaDespesa().getCodigoDespesa()).
					 descricaoNaturezaDespesa(empenho.getOrcamentoDespesa().getNaturezaDespesa().getDescricaoDespesa()).
					 naturezaDespesaExecucacao(empenho.getNaturezaDespesa().getIdNaturezaDespesa().getCodigoDespesa()).
					 descricaoNaturezaDespesaExecucao(empenho.getNaturezaDespesa().getDescricaoDespesa()).
					 fonteRecurso(empenho.getOrcamentoDespesa().getFonteRecurso().getCodigoFonterecursodestinacao()).
					 descricacaoRecurso(empenho.getOrcamentoDespesa().getFonteRecurso().getDescricaoFonterecurso()).
					 fonteRecursoExecucao(empenho.getFonteRecurso().getCodigoFonterecursodestinacao()).
					 descricacaoRecursoExecucao(empenho.getFonteRecurso().getDescricaoFonterecurso()).
					 build());
		});
		
		return listaEmpenhoDTO;
	}
}
