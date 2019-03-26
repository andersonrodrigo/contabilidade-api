package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "DESPESAORCAMENTO")
@Entity
public class OrcamentoDespesa {
	@Id
	@Column(name = "SEQ_DESPESAORCAMENTO")
	private Long sequencialDespesaorcamento;

	@Column(name = "FGL_ORCAMENTO")
	private String flagOrcamento;

	@Column(name = "COD_FICHA")
	private Long codigoFicha;

	@Column(name = "DES_HISTORICO")
	private String descricaoHistorico;

	@Column(name = "VLR_FIXADO")
	private BigDecimal valorFixado;

	@Column(name = "FGL_VINCULADO")
	private String flagVinculado;

	@Column(name = "FGL_APROVACAO")
	private String flagAprovacao;

	@Column(name = "IDT_QUADRO")
	private String idtQuadro;

	@Column(name = "FGL_RETENCAO")
	private String flagRetencao;

	@Column(name = "FGL_PESSOAL")
	private String flagPessoal;

	@Column(name = "FGL_FUNDEF")
	private String flagFundef;

	@Column(name = "FGL_MAGISTERIO")
	private String flagMagisterio;

	@Column(name = "FGL_RECURSOPROPRIO")
	private String flagRecursoproprio;

	@Column(name = "FGL_NAOEXIGEPROCESSO")
	private String flagNaoexigeprocesso;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "COD_DESPESAEDUCACAO")
	private Long codigoDespesaeducacao;

	@Column(name = "IDT_TIPODESPESA")
	private String idtTipodespesa;

	@Column(name = "FGL_ENSINOAPLICFINANCEIRA")
	private String flagEnsinoaplicfinanceira;

	@Column(name = "FGL_SAUDEACESSOUNIVERSAL")
	private String flagSaudeacessouniversal;

	@Column(name = "FLG_DESPCUSTEADAFUNDEB")
	private String flagDespcusteadafundeb;

	@Column(name = "IDT_MODALIDADEENSINOINFANTIL")
	private String idtModalidadeensinoinfantil;

	@Column(name = "FLG_RATEIOAUTOMATICOSIOPE")
	private String flagRateioautomaticosiope;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL")
	private AnoFiscal anofiscal; // @RELACIONAMENTO:ANOFISCAL

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_DESPESA", referencedColumnName = "COD_DESPESA", insertable=false, updatable=false)
	})
	private NaturezaDespesa naturezaDespesa; // @RELACIONAMENTO:DESPESACLASSIFICACAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_FONTERECURSO", referencedColumnName = "COD_FONTERECURSO", insertable=false, updatable=false)
	})
	private FonteRecurso fonteRecurso; // @RELACIONAMENTO:FONTERECURSO
	
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_FUNCAO", referencedColumnName = "COD_FUNCAO", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_SUBFUNCAO", referencedColumnName = "COD_SUBFUNCAO", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROJETOATIVIDADE", referencedColumnName = "COD_PROJETOATIVIDADE", insertable=false, updatable=false)
	})
	private FuncionalProgramatica funcionalProgramatica; // @RELACIONAMENTO:FUNCIONALPROGRAMATICA
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name =  "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_FUNCAO", referencedColumnName = "COD_FUNCAO", insertable=false, updatable=false)
	})
	private Funcao funcao; // @RELACIONAMENTO:FUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_SUBFUNCAO", referencedColumnName = "COD_SUBFUNCAO", insertable=false, updatable=false)
	})
	private SubFuncao subFuncao; // @RELACIONAMENTO:SUBFUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable=false, updatable=false)
	})
	private Programa programa; // @RELACIONAMENTO:PROGRAMA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROJETOATIVIDADE", referencedColumnName = "COD_PROJETOATIVIDADE", insertable=false, updatable=false)
	})
	private ProjetoAtividade projetoAtividade; // @RELACIONAMENTO:PROJETOATIVIDADE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_OCORRENCIA", referencedColumnName = "COD_OCORRENCIA")
	private OcorrenciaOrcamento ocorrenciaOrcamento; // @RELACIONAMENTO:OCORRENCIAORCAMENTO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_UNIDORC", referencedColumnName = "COD_UNIDORC", insertable=false, updatable=false)
	})
	private UnidadeOrcamentaria unidadeOrcamentaria; // @RELACIONAMENTO:UNIDADEORCAMENTO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_VERSAO", referencedColumnName = "NRO_VERSAO", insertable=false, updatable=false)
	})
	private VersaoOrcamento versaoOrcamento; // @RELACIONAMENTO:VERSAOORCAMENTO

	@OneToMany(mappedBy = "orcamentoDespesa", fetch=FetchType.LAZY)
	private List<Contabilizacao4320> contabilizacao4320s;

	/*
	@OneToMany(mappedBy = "COTAUNIDADE", fetch=FetchType.LAZY)
	private List<COTAUNIDADE> COTAUNIDADEs;
	*/

	/*
	@OneToMany(mappedBy = "DESPESAORCAMENTO", fetch=FetchType.LAZY)
	private List<ContabilizacaoSIOPE> contabilizacaoSIOPEs;

	@OneToMany(mappedBy = "DECRETOITEM", fetch=FetchType.LAZY)
	private List<DECRETOITEM> DECRETOITEMs;

	@OneToMany(mappedBy = "DESPESABANCOVINCULO", fetch=FetchType.LAZY)
	private List<DESPESABANCOVINCULO> DESPESABANCOVINCULOs;

	@OneToMany(mappedBy = "EQUIVALENCIAFICHA", fetch=FetchType.LAZY)
	private List<EQUIVALENCIAFICHA> EQUIVALENCIAFICHAs;

	@OneToMany(mappedBy = "ITEMQTDADITIVA", fetch=FetchType.LAZY)
	private List<ITEMQTDADITIVA> ITEMQTDADITIVAs;

	@OneToMany(mappedBy = "NAF", fetch=FetchType.LAZY)
	private List<NAF> NAFs;

	@OneToMany(mappedBy = "PCA_ADIANTAMENTOFICHAS", fetch=FetchType.LAZY)
	private List<PCA_ADIANTAMENTOFICHAS> PCA_ADIANTAMENTOFICHASs;

	@OneToMany(mappedBy = "orcamentoDespesa", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "orcamentoDespesa", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> balanceteChaveDetalheFAKEs;

	@OneToMany(mappedBy = "PROCESSOITEMQTD", fetch=FetchType.LAZY)
	private List<PROCESSOITEMQTD> PROCESSOITEMQTDs;

	@OneToMany(mappedBy = "VINCULODESPESARECEITA", fetch=FetchType.LAZY)
	private List<VINCULODESPESARECEITA> VINCULODESPESARECEITAs;

	*/
}

