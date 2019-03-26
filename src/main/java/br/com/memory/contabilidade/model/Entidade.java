package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ENTIDADE")
@Entity
public class Entidade {
	@Id
	@Column(name = "COD_ENTIDADE")
	private Long codigoEntidade;

	@Column(name = "DES_TIPOENTIDADE")
	private String descricaoTipoEntidade;

	@Column(name = "NRO_CGC")
	private String numeroCgc;

	@Column(name = "NRO_INSCESTADUAL")
	private String numeroInscEstadual;

	@Column(name = "DES_ENTIDADE")
	private String descricaoEntidade;

	@Column(name = "DES_LOGRADOURO")
	private String descricaoLogradouro;

	@Column(name = "NRO_ENDERECO")
	private String numeroEndereco;

	@Column(name = "DES_COMPLEMENTO")
	private String descricaoComplemento;

	@Column(name = "DES_BAIRRO")
	private String descricaoBairro;

	@Column(name = "NRO_CEP")
	private String numeroCep;

	@Column(name = "NRO_TELEFONE")
	private String numeroTelefone;

	@Column(name = "NRO_FAX")
	private String numeroFax;

	@Column(name = "DES_EMAIL")
	private String descricaoEmail;

	@Column(name = "IDT_CONTRATO")
	private String idtContrato;

	@Column(name = "NRO_SENHA")
	private String numeroSenha;

	@Column(name = "DAT_LIMSENHA")
	private Timestamp dataLimsenha;

	@Column(name = "DFL_ANOFISCAL")
	private String dflAnoFiscal;

	@Column(name = "FIG_ENTIDADE")
	private String figEntidade;

	@Column(name = "COD_TIPO")
	private Long codigoTipo;

	@Column(name = "NRO_IDENTIFICACAO")
	private String numeroIdentificacao;

	@Column(name = "COD_AUXILIAR")
	private String codigoAuxiliar;

	@Column(name = "FGL_CPFOBRIGATORIO")
	private String flagCpfObrigatorio;

	@Column(name = "DES_MUNICIPIO_CRIPT")
	private String descricaoMunicipioCript;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FGL_PREVIDENCIA")
	private String flagPrevidencia;

	@Column(name = "FLG_OPTANTESEMESTRALIDADE")
	private String flagOptanteSemestralidade;

	@Column(name = "FGL_CONSORCIOPUBLICO")
	private String flagConsorcioPublico;

	@Column(name = "DAT_CLIENTEDESDE")
	private Timestamp dataClienteDesde;

	@Column(name = "FGL_CLIENTE")
	private String flagCliente;

	@Column(name = "DES_ENTIDADECONSORCIO")
	private String descricaoEntidadeConsorcio;

	@Column(name = "COD_ENTIDADEPRINCIPAL")
	private Long codigoEntidadePrincipal;

	@Column(name = "DAT_ENCERRAMENTO")
	private Timestamp dataEncerramento;

	@Column(name = "DAT_IMPLPCASP")
	private Timestamp dataImplPcasp;

	@Column(name = "IDT_TIPOCONSOLIDACAO")
	private String idtTipoConsolidacao;

	@Column(name = "FLG_FUNDO")
	private String flagFundo;

	@Column(name = "COD_NATUREZAJURIDICA")
	private Long codigoNaturezaJuridica;

	@Column(name = "ID_NATUREZAJURIDICAESOCIAL")
	private Long idNaturezaJuridicaESocial;

	@Column(name = "FLG_POSSUIRPPS")
	private String flagPossuiRpps;

	@Column(name = "FLG_REGISTROELETRONICO")
	private String flagRegistroEletronico;

	@Column(name = "IDT_SISTEMASCONTRATADOS")
	private String idtSistemasContratados;

	@Column(name = "COD_ORGAO_MSC")
	private Long codigoOrgaoMsc;

	@Column(name = "FLG_ENTIDADEGESTORAESOCIAL")
	private String flagEntidadeGestoraESocial;

	@Column(name = "FLG_ENTIDADEGESTORARPPS")
	private String flagEntidadeGestoraRpps;

	@Column(name = "IDT_ESFERAADMINISTRATIVA")
	private String idtEsferaAdministrativa;

	@Column(name = "IDT_PODERINSTITUICAOORGAO")
	private String idtPoderInstituicaoOrgao;

	@Column(name = "DES_ENTEFEDERATIVORESPONSAVEL")
	private String descricaoEnteFedResponsavel;

	@Column(name = "NRO_CNPJENTEFEDERATIVO")
	private String numeroCnpjEnteFederativo;

	@Column(name = "FLG_POSSUIPREVIDENCIACOMPL")
	private String flagPossuiPrevidenciaCompl;

	@Column(name = "FLG_POSSUIAUTONOMIAADMINIST")
	private String flagPossuiAutonomiaAdm;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO")
	private Municipio municipio; // @RELACIONAMENTO:MUNICIPIO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_AREASCONSORCIOPUBLICO", referencedColumnName = "ID_AREASCONSORCIOPUBLICO")
	private AreaConsorcio areaConsorcio; // @RELACIONAMENTO:PCA_AREASCONSORCIOSPUBLICOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ENCERRAMENTOCONSORCIO", referencedColumnName = "ID_ENCERRAMENTOCONSORCIO")
	private EncerramentoConsorcio encerramentoConsorcio; // @RELACIONAMENTO:PCA_ENCERRAMENTOCONSORCIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SITUACAOCONSORCIO", referencedColumnName = "ID_SITUACAOCONSORCIO")
	private SituacaoConsorcio situacaoConsorcio; // @RELACIONAMENTO:PCA_SITUACAOCONSORCIOS

	/*
	@OneToMany(mappedBy = "ASSINATURARELATORIO", fetch=FetchType.LAZY)
	private List<ASSINATURARELATORIO> ASSINATURARELATORIOs;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<Contabilizacao4320> contabilizacao4320s;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<ContaCorrente> contaCorrentes;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<Empenho> empenhos;

	@OneToMany(mappedBy = "ENTIDADEGRUPOENTIDADE", fetch=FetchType.LAZY)
	private List<ENTIDADEGRUPOENTIDADE> ENTIDADEGRUPOENTIDADEs;

	@OneToMany(mappedBy = "ENTIDADEGRUPOENTIDADEFOLHA", fetch=FetchType.LAZY)
	private List<ENTIDADEGRUPOENTIDADEFOLHA> ENTIDADEGRUPOENTIDADEFOLHAs;

	@OneToMany(mappedBy = "EXORC", fetch=FetchType.LAZY)
	private List<EXORC> EXORCs;

	@OneToMany(mappedBy = "FRT_ASSINATURAS", fetch=FetchType.LAZY)
	private List<FRT_ASSINATURAS> FRT_ASSINATURASs;

	@OneToMany(mappedBy = "HISTORICOLIBERACAO", fetch=FetchType.LAZY)
	private List<HISTORICOLIBERACAO> HISTORICOLIBERACAOs;

	@OneToMany(mappedBy = "PAGAMENTO", fetch=FetchType.LAZY)
	private List<PAGAMENTO> PAGAMENTOs;

	@OneToMany(mappedBy = "PARAMETROENTIDADE", fetch=FetchType.LAZY)
	private List<PARAMETROENTIDADE> PARAMETROENTIDADEs;

	@OneToMany(mappedBy = "PATFECHAMENTO", fetch=FetchType.LAZY)
	private List<PATFECHAMENTO> PATFECHAMENTOs;

	@OneToMany(mappedBy = "PATRIMONIO", fetch=FetchType.LAZY)
	private List<PATRIMONIO> PATRIMONIOs;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> balanceteChaveDetalheFAKEs;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<OrcamentoReceita> orcamentoReceitas;

	@OneToMany(mappedBy = "ENTIDADE", fetch=FetchType.LAZY)
	private List<TRelatorioAssinaturaDTO> tRelatorioAssinaturaDTOs;

	@OneToMany(mappedBy = "RPSUFICIENCIARESUMO", fetch=FetchType.LAZY)
	private List<RPSUFICIENCIARESUMO> RPSUFICIENCIARESUMOs;

	@OneToMany(mappedBy = "SISTEMACONTRATADO", fetch=FetchType.LAZY)
	private List<SISTEMACONTRATADO> SISTEMACONTRATADOs;

	@OneToMany(mappedBy = "entidade", fetch=FetchType.LAZY)
	private List<UnidadeOrcamentaria> unidadeOrcamentarias;
	*/
}

