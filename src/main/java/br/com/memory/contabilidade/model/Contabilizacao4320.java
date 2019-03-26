package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CTCONTABLANC")
@Entity
public class Contabilizacao4320 {
	@Id
	@Column(name = "SEQ_CTCONTABLANC")
	private Long sequencialCtcontablanc;

	@Column(name = "IDT_DEBCRED")
	private Integer idtDebcred;

	@Column(name = "DAT_LANCAMENTO")
	private Timestamp dataLancamento;

	@Column(name = "VLR_LANCAMENTO")
	//private BigDecimal valorLancamento;
	private Double valorLancamento;

	@Column(name = "IDT_TIPOLANCTO")
	private String idtTipolancto;

	@Column(name = "NRO_LANCCONTAB")
	private Long numeroLanccontab;

	@Column(name = "NRO_TRANSCONTABIL")
	private Long numeroTranscontabil;

	@Column(name = "DES_HISTORICO")
	private String descricaoHistorico;

	@Column(name = "IDT_ORIGEMLANC")
	private String idtOrigemlanc;

	@Column(name = "NRO_LANCACERTO")
	private Long numeroLancacerto;

	@Column(name = "DAT_CONCILIACAO")
	private Timestamp dataConciliacao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "IDT_CONSOLIDACAO")
	private String idtConsolidacao;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "COD_CTCONTAB_RP")
	private String codigoCtcontabrp;

	@Column(name = "NRO_AGRPATRIMONIO")
	private Long numeroAgrpatrimonio;

	@Column(name = "ANO_EXERCICIO")
	private Long anoExercicio;

	@Column(name = "NRO_REMANEJAMENTO")
	private Long numeroRemanejamento;

	@Column(name = "NRO_ITEM_REMANEJA")
	private Long numeroItemremaneja;

	@Column(name = "COD_GRUPOEVENTO")
	private Long codigoGrupoevento;

	@Column(name = "COD_SUBGRUPOEVENTO")
	private Long codigoSubgrupoevento;

	@Column(name = "COD_EVENTO")
	private Long codigoEvento;

	@Column(name = "SEQ_AMPLIACAO")
	private Long sequencialAmpliacao;

	@Column(name = "COD_VINCULORECURSO")
	private String codigoVinculorecurso;

	@Column(name = "COD_UNIDORC")
	private String codigoUnidorc;

	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL")
	private AnoFiscal anoFiscal; // @RELACIONAMENTO:ANOFISCAL
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_FONTERECURSO_CTB", referencedColumnName = "COD_FONTERECURSO", insertable=false, updatable=false)
	})
	//@JoinColumn(name = "COD_FONTERECURSO_CTB", referencedColumnName = "COD_FONTERECURSO", insertable=true, updatable=true)
	private FonteRecurso fonteRecursoCTB; // @RELACIONAMENTO:FONTERECURSO

	@Column(name = "FGL_ASSOCIACAO_RP")
	private String flagAssociacaorp;

	@Column(name = "SEQ_ANULACAOLIQUIDACAO")
	private Long sequencialAnulacaoliquidacao;

	@Column(name = "ID_PAGAMENTODEVOLUCAO")
	private Long idPagamentodevolucao;

	@Column(name = "NRO_VERSAO")
	private String numeroVersao;

	@Column(name = "IDT_MOTIVORESERVA")
	private String idtMotivoreserva;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CTCONTAB", referencedColumnName = "COD_CTCONTAB")
	private PlanoContasMemory planoContasMemory; // @RELACIONAMENTO:CTCONTAB

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=true, updatable=true), 
		@JoinColumn(name = "NRO_SERIEEMPENHO", referencedColumnName = "NRO_SERIEEMPENHO", insertable=true, updatable=true), 
		@JoinColumn(name = "NRO_EMPENHO", referencedColumnName = "NRO_EMPENHO", insertable=true, updatable=true)
	})
	private Empenho empenho; // @RELACIONAMENTO:EMPENHO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SEQ_DESPESAORCAMENTO", referencedColumnName = "SEQ_DESPESAORCAMENTO")
	private OrcamentoDespesa orcamentoDespesa; // @RELACIONAMENTO:DESPESAORCAMENTO

	@Column(name = "COD_DESPESA")
	String codigoDespesa; 

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=true, updatable=true), 
		@JoinColumn(name = "COD_FONTERECURSO", referencedColumnName = "COD_FONTERECURSO", insertable=true, updatable=true)
	})
	private FonteRecurso fonteRecurso; // @RELACIONAMENTO:FONTERECURSO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_DESPESA", referencedColumnName = "COD_DESPESA", insertable=false, updatable=false)
	})
	private NaturezaDespesa naturezaDespesa; // @RELACIONAMENTO:DESPESACLASSIFICACAO

	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_SERIEEMPENHO", referencedColumnName = "NRO_SERIEEMPENHO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_EMPENHO", referencedColumnName = "NRO_EMPENHO", insertable=false, updatable=false), 
		@JoinColumn(name = "IDT_TIPOEMPENHO", referencedColumnName = "IDT_TIPOEMPENHO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_EMPENHOADCIONAL", referencedColumnName = "NRO_EMPENHOADCIONAL", insertable=false, updatable=false)
	})
	private EmpenhoAdicional empenhoAdicional; // @RELACIONAMENTO:EMPENHOADCIONAL

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CTCORRENTE", referencedColumnName = "COD_CTCORRENTE")
	private ContaCorrente contaCorrente; // @RELACIONAMENTO:CTCORRENTE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANODECRETO", referencedColumnName = "NRO_ANODECRETO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_DECRETO", referencedColumnName = "NRO_DECRETO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_ITEM", referencedColumnName = "NRO_ITEM", insertable=false, updatable=false)
	})
	private ItemDecreto itemDecreto; // @RELACIONAMENTO:DECRETOITEM

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_DIVIUNDADA", referencedColumnName = "NRO_DIVIUNDADA")
	private DividaFundada dividaFundada; // @RELACIONAMENTO:DIVIDAFUNDADA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE")
	private Entidade entidade; // @RELACIONAMENTO:ENTIDADE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_SERIEEXORC", referencedColumnName = "NRO_SERIEEXORC", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_EXORC", referencedColumnName = "NRO_EXORC", insertable=false, updatable=false)
	})
	private EmpenhoExtraOrcamentarioo empenhoExtraOrcamentario; // @RELACIONAMENTO:EXORC

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_FICHAEXORC", referencedColumnName = "NRO_FICHAEXORC")
	private FichaExtraOrcamentaria fichaExtraOrcamentaria; // @RELACIONAMENTO:EXORCFICHA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SEQ_LIQUIDACAO", referencedColumnName = "SEQ_LIQUIDACAO")
	private Liquidacao liquidacao; // @RELACIONAMENTO:LIQUIDACAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_SERIEPAGAMENTO", referencedColumnName = "NRO_SERIEPAGAMENTO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_PAGAMENTO", referencedColumnName = "NRO_PAGAMENTO", insertable=false, updatable=false)
	})
	private Pagamento pagamento; // @RELACIONAMENTO:PAGAMENTO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PATRIMONIAL", referencedColumnName = "COD_PATRIMONIAL", insertable=false, updatable=false)
	})
	private Patrimonio patrimonio; // @RELACIONAMENTO:PATRIMONIO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SEQ_RECEITAORCAMENTO", referencedColumnName = "SEQ_RECEITAORCAMENTO")
	private OrcamentoReceita orcamentoReceita; // @RELACIONAMENTO:RECEITAORCAMENTO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_SERIERESERVA", referencedColumnName = "NRO_SERIERESERVA", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_RESERVA", referencedColumnName = "NRO_RESERVA", insertable=false, updatable=false)
	})
	private ReservaDotacao reservaDotacao; // @RELACIONAMENTO:RESERVADOTACAO
	*/
}

