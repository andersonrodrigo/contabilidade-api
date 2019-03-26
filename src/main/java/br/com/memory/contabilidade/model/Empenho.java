package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.EmpenhoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EMPENHO")
@Entity
public class Empenho {
	@EmbeddedId
	private EmpenhoId idEmpenho;

	@Column(name = "IDT_TIPOEMPENHO")
	private String idtTipoempenho;

	@Column(name = "DAT_EMPENHO")
	private Timestamp dataEmpenho;

	@Column(name = "NRO_LICITACAO")
	private String numeroLicitacao;

	@Column(name = "DES_MOTIVOLICITACAO")
	private String descricaoMotivolicitacao;

	@Builder.Default
	@Column(name = "FGL_PESSOAL") 
	private String flagPessoal = "0";

	@Builder.Default
	@Column(name = "IDT_HISTORICO")
	private String idtHistorico = "T";

	@Builder.Default
	@Column(name = "IDT_TIPODESPESA")
	private String idtTipodespesa = "00";

	@Builder.Default
	@Column(name = "FGL_EXCDESPTOTAL")
	private String flagExcdesptotal = "0";

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Builder.Default
	@Column(name = "FGL_INCIDEDIRF")
	private String flagIncidedirf = "0";

	@Column(name = "COD_SERVICO")
	private Long codigoServico;

	@Builder.Default
	@Column(name = "FGL_CONTRATO")
	private String flagContrato = "0";

	@Column(name = "NRO_CONTRATO")
	private String numeroContrato;

	@Column(name = "DAT_ASSINATURA")
	private Timestamp dataAssinatura;

	@Column(name = "NRO_SEQUENCIALADITIVO")
	private String numeroSequencialaditivo;

	@Builder.Default
	@Column(name = "FGL_LICITACAO")
	private String flagLicitacao = "0";

	@Column(name = "NRO_PROCESSO_SICOM")
	private String numeroProcessosicom;

	@Column(name = "NRO_EXERCICIO_SICOM")
	private Long numeroExerciciosicom;

	@Column(name = "IDT_OBRA_SERV_MANAD")
	private String idtObraservmanad;

	@Column(name = "NRO_OBRA_INSS")
	private String numeroObrainss;

	@Builder.Default
	@Column(name = "FGL_PPP")
	private String flagPpp = "0";

	@Column(name = "NRO_EMPENHO_CONCORRENTE")
	private String numeroEmpenhoconcorrente;

	@Builder.Default
	@Column(name = "FGL_INTEGRACAOFOLHA")
	private String flagIntegracaofolha = "0";

	@Builder.Default
	@Column(name = "FLG_DESPESAPUBLICIDADE")
	private String flagDespesapublicidade = "0";

	@Builder.Default
	@Column(name = "FLG_DESPESAPAGTOANTECIPADO")
	private String flagDespesapagtoantecipado= "0";

	@Column(name = "IDT_TIPODESPESARPPS")
	private Long idtTipodespesarpps;

	@Column(name = "CODUNIDADESUB")
	private String codunidadesub;

	@Column(name = "CODUNIDADESUBORIG")
	private String codunidadesuborig;

	@Builder.Default
	@Column(name = "FLG_DESPESAIMPUGNADA")
	private String flagDespesaimpugnada = "0";

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY, cascade={CascadeType.ALL,CascadeType.REMOVE})
	private List<Contabilizacao4320> contabilizacao4320s;

	@OneToMany(mappedBy = "idEmpenhoItem.empenho", fetch=FetchType.LAZY, cascade={CascadeType.ALL,CascadeType.REMOVE})
	private List<EmpenhoItem> empenhoItems;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC")
	private Credor credor; // @RELACIONAMENTO:FORNECEDOR

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PRECATORIO", referencedColumnName = "ID_PRECATORIO")
	private Precatorio precatorio; // @RELACIONAMENTO:PCA_PRECATORIO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONSORCIO", referencedColumnName = "ID_CONSORCIO")
	private Consorcio consorcio; // @RELACIONAMENTO:PCA_CONSORCIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA", referencedColumnName = "ID_CONTA")
	private PlanoContasPCASP contaVPD; // @RELACIONAMENTO:PCA_PLANOCONTAS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CBO", referencedColumnName = "COD_CBO")
	private CBO cbo; // @RELACIONAMENTO:CBO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_MODALIDADELICITACAO", referencedColumnName = "COD_MODALIDADELICITACAO", insertable=true, updatable=false), 
		@JoinColumn(name = "COD_GRUPOENTIDADE", referencedColumnName = "COD_GRUPOENTIDADE", insertable=true, updatable=false)
	})
	private ModalidadeLicitacao modalidadeLicitacao; // @RELACIONAMENTO:MODALIDADELICITACAO

	/*
	@OneToMany(mappedBy = "EMPENHO", fetch=FetchType.LAZY)
	private List<ContabilizacaoSIOPE> contabilizacaoSIOPEs;

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY)
	private List<DetalhamentoConsorcio> detalhamentoConsorcios;

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY)
	private List<EmpenhoAdicional> empenhoAdicionals;

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY)
	private List<AbastecimentoMaterial> abastecimentoMaterials;

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "empenho", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> balanceteChaveDetalheFAKEs;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONVENIO", referencedColumnName = "ID_CONVENIO")
	private Convenio convenio; // @RELACIONAMENTO:CT_CONVENIO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_DESPESAFIXA", referencedColumnName = "COD_DESPESAFIXA")
	private TipoDespesa tipoDespesa; // @RELACIONAMENTO:DESPESAFIXA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_DIVIUNDADA", referencedColumnName = "NRO_DIVIUNDADA")
	private DividaFundada dividaFundada; // @RELACIONAMENTO:DIVIDAFUNDADA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_DESPESAEDUCACAO", referencedColumnName = "COD_DESPESAEDUCACAO")
	private TipoEducacaoSaude tipoEducacaoSaude; // @RELACIONAMENTO:EDUCACAOSAUDE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_MODALIDADELICITACAO", referencedColumnName = "COD_MODALIDADELICITACAO", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_GRUPOENTIDADE", referencedColumnName = "COD_GRUPOENTIDADE", insertable=false, updatable=false)
	})
	private ModalidadeLicitacao modalidadeLicitacao; // @RELACIONAMENTO:MODALIDADELICITACAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ADIANTAMENTO", referencedColumnName = "ID_ADIANTAMENTO")
	private Adiantamento adiantamento; // @RELACIONAMENTO:PCA_ADIANTAMENTO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PPP", referencedColumnName = "ID_PPP")
	private ParceriaPublicoPrivada parceriaPublicoPrivada; // @RELACIONAMENTO:PCA_PPP

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_RPPSEMPRESTIMO", referencedColumnName = "ID_RPPSEMPRESTIMO")
	private EmprestimoRPPS emprestimoRPPS; // @RELACIONAMENTO:PCA_RPPSEMPRESTIMO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_GRUPOENTIDADE", referencedColumnName = "COD_GRUPOENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_SERIEPROCESSO", referencedColumnName = "NRO_SERIEPROCESSO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_PROCESSO", referencedColumnName = "NRO_PROCESSO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC", insertable=false, updatable=false)
	})
	private ProcessoFornecedor processoFornececedor; // @RELACIONAMENTO:PROCESSOFORNECEDOR
	*/
}

