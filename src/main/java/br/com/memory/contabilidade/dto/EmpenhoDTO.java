	package br.com.memory.contabilidade.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpenhoDTO {
	private Long codigoEntidade;
	private Long serieEmpenho;;
	private Long NumeroEmpenho;
	private String idtTipoempenho;
	private String numeroLicitacao;
	private String funcionalProgramatica;
	//private BigDecimal valorEmpenho;
	private Double valorEmpenho;
	private Timestamp dataEmpenho;
	private String unidadeOrcamentaria;
	private String descricaoUnidadeOrcamentaria;
	private String naturezaDespesa;
	private String descricaoNaturezaDespesa;
	private String naturezaDespesaExecucacao;
	private String descricaoNaturezaDespesaExecucao;
	private String fonteRecurso;
	private String descricacaoRecurso;
	private String fonteRecursoExecucao;
	private String descricacaoRecursoExecucao;
	private Long fichaOrcamento;
	private String codigoVPD;
	private Long codigoGrupoEntidadeCompras;
	private Long codigoModalidadeLicitacao;
	private String descricaoMotivolicitacao;
	private String flagPessoal;
	private String idtHistorico;
	private String idtTipodespesa;
	private String flagExcdesptotal;
	private Timestamp dataLastrec;
	private String codigoUsuario;
	private String flagIncidedirf;
	private Long codigoServico;
	private String flagContrato;
	private String numeroContrato;
	private Timestamp dataAssinatura;
	private String numeroSequencialaditivo;
	private String flagLicitacao;
	private String numeroProcessosicom;
	private Long numeroExerciciosicom;
	private String idtObraservmanad;
	private String numeroObrainss;
	private String flagPpp;
	private String numeroEmpenhoconcorrente;
	private String flagIntegracaofolha;
	private String flagDespesapublicidade;
	private String flagDespesapagtoantecipado;
	private Long idtTipodespesarpps;
	private String codunidadesub;
	private String codunidadesuborig;
	private String flagDespesaimpugnada;
	private Long codigoCredor;
	private String nomeCredor;
	private String historicoEmpenho;

	/*
	private CBODTO cboDTO; // @RELACIONAMENTO:

	private ConvenioDTO convenioDTO; // @RELACIONAMENTO:

	private TipoDespesaDTO tipoDespesaDTO; // @RELACIONAMENTO:

	private DividaFundadaDTO dividaFundadaDTO; // @RELACIONAMENTO:

	private TipoEducacaoSaudeDTO tipoEducacaoSaudeDTO; // @RELACIONAMENTO:

	private EntidadeDTO entidadeDTO; // @RELACIONAMENTO:

	private CredorDTO credorDTO; // @RELACIONAMENTO:

	private ModalidadeLicitacaoDTO modalidadeLicitacaoDTO; // @RELACIONAMENTO:

	private AdiantamentoDTO adiantamentoDTO; // @RELACIONAMENTO:

	private ConsorcioDTO consorcioDTO; // @RELACIONAMENTO:

	private PlanoContasPCASPDTO planoContasPCASPDTO; // @RELACIONAMENTO:

	private ParceriaPublicoPrivadaDTO parceriaPublicoPrivadaDTO; // @RELACIONAMENTO:

	private PrecatorioDTO precatorioDTO; // @RELACIONAMENTO:

	private EmprestimoRPPSDTO emprestimoRPPSDTO; // @RELACIONAMENTO:

	private ProcessoFornecedorDTO processoFornececedorDTO; // @RELACIONAMENTO:
	*/
}

