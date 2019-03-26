package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.Currency;
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
@Table(name = "ANOFISCAL")
@Entity
public class AnoFiscal {
	@Id
	@Column(name = "NRO_ANOFISCAL")
	private Long numeroAnofiscal;

	@Column(name = "DES_MASCCONTAB")
	private String descricaoMasccontab;

	@Column(name = "DES_UNIDORC")
	private String descricaoUnidorc;

	@Column(name = "DES_MASCRECEITA")
	private String descricaoMascreceita;

	@Column(name = "NRO_CONTROLERESERVA")
	private Long numeroControlereserva;

	@Column(name = "DES_MASCDESPESA")
	private String descricaoMascdespesa;

	@Column(name = "CTR_SEQEXORCOLANC")
	private Long ctr_seqexorcolanc;

	@Column(name = "SEQ_DESPESAORCENSINOFUND")
	private Long sequencialDespesaorcensinofund;

	@Column(name = "IDT_HISTORICO")
	private String idtHistorico;

	@Column(name = "FGL_LICITACAO")
	private String flagLicitacao;

	@Column(name = "FGL_FONTERECURSO")
	private String flagFonterecurso;

	@Column(name = "FGL_DESPESAFIXA")
	private String flagDespesafixa;

	@Column(name = "FGL_DESDOBRAMENTO")
	private String flagDesdobramento;

	@Column(name = "FGL_COTA")
	private String flagCota;

	@Column(name = "FGL_S")
	private String flagS;

	@Column(name = "FGL_VINCULA")
	private String flagVincula;

	@Column(name = "NRO_LANCCONTAB")
	private Long numeroLanccontab;

	@Column(name = "COD_RELEMPENHO")
	private Long codigoRelempenho;

	@Column(name = "COD_RELLIQUIDACAO")
	private Long codigoRelliquidacao;

	@Column(name = "COD_RELORDEMPAGTO")
	private Long codigoRelordempagto;

	@Column(name = "COD_RELANULACAO")
	private Long codigoRelanulacao;

	@Column(name = "COD_CCIMOBILIZADO")
	private String codigoCcimobilizado;

	@Column(name = "COD_CCBANCO")
	private String codigoCcbanco;

	@Column(name = "COD_CCDIVIDAFUNDADA")
	private String codigoCcdividafundada;

	@Column(name = "FGL_EVENTODIVIDAFUNDADA")
	private String flagEventodividafundada;

	@Column(name = "FGL_EVENTOPATRIMONIO")
	private String flagEventopatrimonio;

	@Column(name = "FGL_MUDOUORCAMENTO")
	private String flagMudouorcamento;

	@Column(name = "FGL_EVENTOSINTETICO")
	private String flagEventosintetico;

	@Column(name = "COD_FICHARECEITACLASSIFICAR")
	private Long codigoFichareceitaclassificar;

	@Column(name = "COD_CTCAIXA")
	private String codigoCtcaixa;

	@Column(name = "FGL_MARCAEMPENHO")
	private String flagMarcaempenho;

	@Column(name = "IDT_IMPRESSORA")
	private String idtImpressora;

	@Column(name = "COD_RECPAGERRO")
	private Long codigoRecpagerro;

	@Column(name = "FGL_CONVERSAO")
	private String flagConversao;

	@Column(name = "NRO_INTERVALOPPA")
	private Long numeroIntervaloppa;

	@Column(name = "ANO_DEFAULTPPA")
	private Long anoDefaultppa;

	@Column(name = "COD_RECEITA_IR")
	private String codigoReceitair;

	@Column(name = "FGL_IMPDATALIQUIDACAO")
	private String flagImpdataliquidacao;

	@Column(name = "FGL_VINCULOLIQUIDACAO")
	private String flagVinculoliquidacao;

	@Column(name = "FGL_VINCULARECEITA")
	private String flagVinculareceita;

	@Column(name = "FGL_PPAACAOFONTE")
	private String flagPpaacaofonte;

	@Column(name = "FGL_IMP_VLR_LIQUIDACAO")
	private String flagImpvlrliquidacao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FGL_OPAUTOMATICA")
	private String flagOpautomatica;

	@Column(name = "FGL_MOVEDATADIA")
	private String flagMovedatadia;

	@Column(name = "COD_CCTRANSFERENCIAFIN")
	private String codigoCctransferenciafin;

	@Column(name = "FGL_TRIBUTACAO")
	private String flagTributacao;

	@Column(name = "DES_MASCARAVINCULO")
	private String descricaoMascaravinculo;

	@Column(name = "IDT_IMPRESSORACHEQUE")
	private String idtImpressoracheque;

	@Column(name = "IDT_PORTA")
	private String idtPorta;

	@Column(name = "FGL_IMPRIMEDATA_NE")
	private String flagImprimedatane;

	@Column(name = "FGL_IMPRIME_NF")
	private String flagImprimenf;

	@Column(name = "COD_FICHA_IRRF_EXTRA")
	private Long codigoFichairrfextra;

	@Column(name = "COD_FICHA_IRRF_ORCAMENTARIO")
	private Long codigoFichairrforcamentario;

	@Column(name = "COD_FICHA_ISSQN_EXTRA")
	private Long codigoFichaissqnextra;

	@Column(name = "COD_FICHA_ISSQN_ORCAMENTARIO")
	private Long codigoFichaissqnorcamentario;

	@Column(name = "COD_FICHA_IRPJ_EXTRA")
	private Long codigoFichairpjextra;

	@Column(name = "COD_FICHA_IRPJ_ORCAMENTARIO")
	private Long codigoFichairpjorcamentario;

	@Column(name = "COD_FICHA_SESTSENAT")
	private Long codigoFichasestsenat;

	@Column(name = "NRO_COPIA_EMPENHO")
	private Long numeroCopiaempenho;

	@Column(name = "FGL_LIQUIDACAORP")
	private String flagLiquidacaorp;

	@Column(name = "COD_FICHA_INSS_PF")
	private Long codigoFichainsspf;

	@Column(name = "COD_FICHA_INSS_PJ")
	private Long codigoFichainsspj;

	@Column(name = "FGL_COMPRASNOVO")
	private String flagComprasnovo;

	@Column(name = "COD_HISTORICO")
	private Long codigoHistorico;

	@Column(name = "DES_MASCCENTROCUSTO")
	private String descricaoMasccentrocusto;

	@Column(name = "DAT_INTEGRACAO")
	private Timestamp dataIntegracao;

	@Column(name = "FGL_RECEITAAUTOMATICA")
	private String flagReceitaautomatica;

	@Column(name = "FGL_EMPENHOMESMAFICHA")
	private String flagEmpenhomesmaficha;

	@Column(name = "FGL_INTEGRA_SUBNAF")
	private String flagIntegrasubnaf;

	@Column(name = "FGL_PERMITEDESINTEGRACAO")
	private String flagPermitedesintegracao;

	@Column(name = "FGL_IMPRIMEUSUARIO")
	private String flagImprimeusuario;

	@Column(name = "FGL_VINCULOPAGAMENTO")
	private String flagVinculopagamento;

	@Column(name = "FGL_RESPOPAUTO")
	private String flagRespopauto;

	@Column(name = "FGL_NAOEXIBEENTIDADE")
	private String flagNaoexibeentidade;

	@Column(name = "DES_MASCARAFONTERECURSO")
	private String descricaoMascarafonterecurso;

	@Column(name = "FGL_TIPORECURSO")
	private String flagTiporecurso;

	@Column(name = "FLG_VERIFICACPF")
	private String flagVerificacpf;

	@Column(name = "DAT_ENVIOPORTALTRANSPARENCIA")
	private Timestamp dataEnvioportaltransparencia;

	@Column(name = "FGL_NBCASPNOEXERCICIO")
	private String flagNbcaspnoexercicio;

	@Column(name = "FGL_CONTROLACONVENIO")
	private String flagControlaconvenio;

	@Column(name = "FGL_CONTROLADIVIDAFUNDADA")
	private String flagControladividafundada;

	@Column(name = "FGL_CONTROLACREDITO")
	private String flagControlacredito;

	@Column(name = "ID_CONTAESTOQUE")
	private Long idContaestoque;

	@Column(name = "FGL_ALMOXARIFADO")
	private String flagAlmoxarifado;

	@Column(name = "DAT_INTEGRACAOALMOXARIFADO")
	private Timestamp dataIntegracaoalmoxarifado;

	@Column(name = "FGL_EXIGIRTIPORECURSO")
	private String flagExigirtiporecurso;

	@Column(name = "FGL_FONTENATRANSFERENCIA")
	private String flagFontenatransferencia;

	@Column(name = "IDT_FONTEPAGAMENTO")
	private String idtFontepagamento;

	@Column(name = "FGL_CONSITESUBFONTE")
	private String flagConsitesubfonte;

	@Column(name = "FGL_PERMITEFONTEANTERIOR")
	private String flagPermitefonteanterior;

	@Column(name = "FGL_PERMITESALDOPORFONTE")
	private String flagPermitesaldoporfonte;

	@Column(name = "FGL_CONCILIARCONTA")
	private String flagConciliarconta;

	@Column(name = "FGL_CONSISTESALDOCONTA")
	private String flagConsistesaldoconta;

	@Column(name = "FGL_SICOM_CONCORRENTE")
	private String flagSicomconcorrente;

	@Column(name = "DES_MASCARAEVENTO")
	private String descricaoMascaraevento;

	@Column(name = "FLG_EVENTOTRIBUTACAO")
	private String flagEventotributacao;

	@Column(name = "FLG_EVENTOFOLHAPAGAMENTO")
	private String flagEventofolhapagamento;

	@Column(name = "FLG_CONTROLACUSTOS")
	private String flagControlacustos;

	@Column(name = "FLG_PERMITEEXCLUSAO")
	private String flagPermiteexclusao;

	@Column(name = "FLG_PROGLIBERADEPAGAMENTO")
	private String flagProgliberadepagamento;

	@Column(name = "FLG_FOLHAATENDENBCASP")
	private String flagFolhaatendenbcasp;

	@Column(name = "FLG_PATRIMONIOATENDENBCASP")
	private String flagPatrimonioatendenbcasp;

	@Column(name = "FLG_TRIBUTACAOATENDENBCASP")
	private String flagTributacaoatendenbcasp;

	@Column(name = "FLG_ALMOXARIFADOATENDENBCASP")
	private String flagAlmoxarifadoatendenbcasp;

	@Column(name = "FLG_NIVELCATEGORIAPROGRTT")
	private String flagNivelcategoriaprogrtt;

	@Column(name = "DAT_CORTEAPROPRIACAOFOLHA")
	private Timestamp dataCorteapropriacaofolha;

	@Column(name = "DAT_CORTEAJUSTEPATRIMONIO")
	private Timestamp dataCorteajustepatrimonio;

	@Column(name = "DAT_CORTEAJUSTETRIBUTACAO")
	private Timestamp dataCorteajustetributacao;

	@Column(name = "DAT_INTEGRACAOTRIBUTACAO")
	private Timestamp dataIntegracaotributacao;

	@Column(name = "DAT_INTEGRACAOFOLHAPAGAMENTO")
	private Timestamp dataIntegracaofolhapagamento;

	@Column(name = "DAT_INTEGRACAOSISTEMAPATRIMONIO")
	private Timestamp dataIntegracaosistemapatrimonio;

	@Column(name = "FLG_TIPOALTERACOES")
	private String flagTipoalteracoes;

	@Column(name = "FLG_CARGAEMEXECUCAO")
	private String flagCargaemexecucao;

	@Column(name = "FLG_EXECUTOUCARGA")
	private String flagExecutoucarga;

	@Column(name = "DAT_IMPLANTACAONBCASP")
	private Timestamp dataImplantacaonbcasp;

	@Column(name = "FGL_IMPEDEAPROVACAOORCAMENTO")
	private String flagImpedeaprovacaoorcamento;

	@Column(name = "FLG_EXIGIENVIOREMESSASICOM")
	private String flagExigienvioremessasicom;

	@Column(name = "DAT_CORTEREMESSASICOM")
	private Timestamp dataCorteremessasicom;

	@Column(name = "FLG_RESPONSAVELORIGINAL")
	private String flagResponsaveloriginal;

	@Column(name = "FGL_PERMITEREMANEJASALDO")
	private String flagPermiteremanejasaldo;

	@Column(name = "FGL_FONTERECURSODECRETO")
	private String flagFonterecursodecreto;

	@Column(name = "FGL_NAOPERMITESUPLEMENTACAO")
	private String flagNaopermitesuplementacao;

	@Column(name = "FGL_CONTROLASUPERAVITFINANCEIRO")
	private String flagControlasuperavitfinanceiro;

	@Column(name = "CTRLPCASPBALANCETE")
	private Long ctrlpcaspbalancete;

	@Column(name = "FGL_CONSOLIDAENTIDADEREMANEJA")
	private String flagConsolidaentidaderemaneja;

	@Column(name = "DAT_RESTRICAORELATORIO_4320")
	private Timestamp dataRestricaorelatorio4320;

	@Column(name = "NRO_HABITANTES")
	private Long numeroHabitantes;

	@Column(name = "VLR_PERCENTUALLIMITE")
	private Currency valorPercentuallimite;

	@OneToMany(mappedBy = "idNaturezaDespesa.anoFiscal", fetch=FetchType.LAZY)
	private List<NaturezaDespesa> naturezaDespesas;

	@OneToMany(mappedBy = "anofiscal", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;

	@OneToMany(mappedBy = "idFuncao.anoFiscal", fetch=FetchType.LAZY)
	private List<Funcao> funcaos;

	@OneToMany(mappedBy = "idPrograma.anoFiscal", fetch=FetchType.LAZY)
	private List<Programa> programas;

	@OneToMany(mappedBy = "idProjetoAtividade.anoFiscal", fetch=FetchType.LAZY)
	private List<ProjetoAtividade> projetoAtividades;

	/*
	@OneToMany(mappedBy = "AnoFiscal", fetch=FetchType.LAZY)
	private List<NaturezaReceita> naturezaReceitas;
	*/

	@OneToMany(mappedBy = "idSubFuncao.anoFiscal", fetch=FetchType.LAZY)
	private List<SubFuncao> subFuncaos;

	@OneToMany(mappedBy = "idUnidadeOrcamentaria.anoFiscal", fetch=FetchType.LAZY)
	private List<UnidadeOrcamentaria> unidadeOrcamentarias;

	@OneToMany(mappedBy = "idVersaoOrcamento.anoFiscal", fetch=FetchType.LAZY)
	private List<VersaoOrcamento> versaoOrcamentos;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_VERSAO", referencedColumnName = "ID_VERSAO")
	private VersaoPCASP versaoPCASP; // @RELACIONAMENTO:PCA_VERSAO

}

