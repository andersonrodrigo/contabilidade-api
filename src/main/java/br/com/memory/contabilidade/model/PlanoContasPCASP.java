package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PCA_PLANOCONTAS")
@Entity
public class PlanoContasPCASP {
	@Id
	@Column(name = "ID_CONTA")
	private Long idConta;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONTASUPERIOR", referencedColumnName = "ID_CONTA")
	private PlanoContasPCASP idContasuperior; // @RELACIONAMENTO:PCA_PLANOCONTAS

	@Column(name = "COD_CONTA")
	private String codigoConta;

	@Column(name = "COD_CONTASEMMASCARA")
	private String codigoContasemmascara;

	@Column(name = "DES_CONTA")
	private String descricaoConta;

	@Column(name = "FGL_ULTIMONIVEL")
	private String flagUltimonivel;

	@Column(name = "FGL_ENCERRASALDO")
	private String flagEncerrasaldo;

	@Column(name = "FGL_INVERSAOSALDO")
	private String flagInversaosaldo;

	@Column(name = "IDT_NATUREZACONTA")
	private Long idtNaturezaconta;

	@Column(name = "IDT_VINCULAATIVOPASSIVO")
	private Long idtVinculaativopassivo;

	@Column(name = "IDT_VINCULAVPDVPA")
	private Long idtVinculavpdvpa;

	@Column(name = "IDT_VINCULARECEITADESPESA")
	private Long idtVinculareceitadespesa;

	@Column(name = "FGL_VINCULAFICHA")
	private String flagVinculaficha;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "FGL_ATRIBUTOCONTABIL")
	private String flagAtributocontabil;

	@Column(name = "DAT_INICIOVIGENCIA")
	private Timestamp dataIniciovigencia;

	@Column(name = "DAT_TERMINOVIGENCIA")
	private Timestamp dataTerminovigencia;

	@Column(name = "FGL_FINANCEIRO")
	private String flagFinanceiro;

	@Column(name = "FGL_PERMANENTE")
	private String flagPermanente;

	@Column(name = "COD_AUXILIAR")
	private String codigoAuxiliar;

	@Column(name = "FLG_TIPOPCASP")
	private String flagTipopcasp;

	@Column(name = "FLG_ATIVA")
	private String flagAtiva;

	@Column(name = "DAT_ALTERACAO")
	private Timestamp dataAlteracao;

	@Column(name = "IDT_MOTIVO")
	private String idtMotivo;

	@Column(name = "COD_REGISTROTCE")
	private Long codigoRegistrotce;

	@Column(name = "FLG_RETIFICADORA")
	private String flagRetificadora;

	@Column(name = "IDT_CC")
	private String idtCc;

	@Column(name = "FLG_SINTETICA")
	private String flagSintetica;

	@Column(name = "NAT_CONTA_EST")
	private String nat_conta_est;

	@Column(name = "IDT_ATRIBUTO")
	private String idtAtributo;

	@Column(name = "FLG_SINAL")
	private Long flagSinal;

	@OneToMany(mappedBy = "idContasuperior", fetch=FetchType.LAZY)
	private List<PlanoContasPCASP> planoContasPCASPs;

	@OneToMany(mappedBy = "contaVPD", fetch=FetchType.LAZY)
	private List<Empenho> empenhos;

	/*
	@OneToMany(mappedBy = "CONTABILIZACAOTRIBUTACAOGUIA", fetch=FetchType.LAZY)
	private List<CONTABILIZACAOTRIBUTACAOGUIA> CONTABILIZACAOTRIBUTACAOGUIAs;

	@OneToMany(mappedBy = "CONTABILTRIBUTARECEITA", fetch=FetchType.LAZY)
	private List<CONTABILTRIBUTARECEITA> CONTABILTRIBUTARECEITAs;

	@OneToMany(mappedBy = "CT_TIPORETENCAO", fetch=FetchType.LAZY)
	private List<CT_TIPORETENCAO> CT_TIPORETENCAOs;

	@OneToMany(mappedBy = "PCARELVALORES", fetch=FetchType.LAZY)
	private List<PCARELVALORES> PCARELVALORESs;

	@OneToMany(mappedBy = "PCA_LANCAMENTOSPADROES", fetch=FetchType.LAZY)
	private List<PCA_LANCAMENTOSPADROES> PCA_LANCAMENTOSPADROESs;
	*/
	
	/*
	@OneToMany(mappedBy = "planoContasPCASP", fetch=FetchType.LAZY)
	private List<SubTipoAdiantamento> subTipoAdiantamentos;

	@OneToMany(mappedBy = "VW_CONTAEVENTOCONTAS", fetch=FetchType.LAZY)
	private List<VW_CONTAEVENTOCONTAS> VW_CONTAEVENTOCONTASs;
	*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_IDENTIFICADOR", referencedColumnName = "ID_IDENTIFICADOR")
	private Identificadores Identificadores; // @RELACIONAMENTO:PCA_IDENTIFICADORES

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_NIVELCONSOLIDACAO", referencedColumnName = "ID_NIVELCONSOLIDACAO")
	private NivelConsolidacao NivelConsolidacao; // @RELACIONAMENTO:PCA_NIVEISCONSOLIDACAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PRAZO", referencedColumnName = "ID_PRAZO")
	private PrazosPCASP prazosPCASP; // @RELACIONAMENTO:PCA_PRAZOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_VERSAO", referencedColumnName = "ID_VERSAO")
	private VersaoPCASP versaoPCASP; // @RELACIONAMENTO:PCA_VERSAO

}

