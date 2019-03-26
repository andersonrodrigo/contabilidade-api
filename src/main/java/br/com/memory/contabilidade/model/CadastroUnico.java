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
@Table(name = "CUC")
@Entity
public class CadastroUnico {
	@Id
	@Column(name = "NRO_CUC")
	private Long numeroCadastroUnico;

	@Column(name = "DES_NOME")
	private String descricaoNome;

	@Column(name = "NRO_COMPLEMENTOCGC")
	private String numeroComplementoCgc;

	@Column(name = "DES_EMAIL")
	private String descricaoEmail;

	@Column(name = "NRO_FONE1")
	private String numeroFone1;

	@Column(name = "NRO_FONE2")
	private String numeroFone2;

	@Column(name = "NRO_FAX")
	private String numeroFax;

	@Column(name = "DAT_CADASTRO")
	private Timestamp dataCadastro;

	@Column(name = "DAT_BAIXA")
	private Timestamp dataBaixa;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "FGL_COMPRAS")
	private String flagCompras;

	@Column(name = "NRO_INSCESTADUAL")
	private String numeroInscEstadual;

	@Column(name = "DES_SENHACUC")
	private String descricaoSenhaCadastroUnico;

	@Column(name = "DES_SENHAESPECIAL")
	private String descricaoSenhaEspecial;

	@Column(name = "FGL_ISSRETIDO")
	private Long flagIssRetido;

	@Column(name = "DAT_INCLUSAO")
	private Timestamp dataInclusao;

	@Column(name = "NRO_ANS")
	private String numeroAns;

	@Column(name = "FGL_TXEXPEISSRETIDO")
	private Long flagTxExpedicaoIssRetido;

	@Column(name = "IDT_NIVELCONSOLIDACAO")
	private Long idtNivelConsolidacao;

	@Column(name = "FGL_ESTRANGEIRO")
	private String flagEstrangeiro;

	@Column(name = "DAT_INCLUSAO_LAI")
	private Timestamp dataInclusaoLai;

	@Column(name = "DES_NOMESOCIAL")
	private String descricaoNomeSocial;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CGC", referencedColumnName = "NRO_CGC")
	private PessoaJuridica pessoaJuridica; // @RELACIONAMENTO:PESSOAJURIDICA

	@OneToMany(mappedBy = "cadastroUnico", fetch=FetchType.LAZY)
	private List<EnderecoCadastroUnico> enderecoCadastroUnicos;

	/*
	@OneToMany(mappedBy = "cuc", fetch=FetchType.LAZY)
	private List<TAlvaraEventualDTO> tAlvaraEventualDTOs;

	@OneToMany(mappedBy = "BC", fetch=FetchType.LAZY)
	private List<BC> BCs;

	@OneToMany(mappedBy = "cuc", fetch=FetchType.LAZY)
	private List<TBcDadosDTO> tBcDadosDTOs;

	@OneToMany(mappedBy = "BCEENTREGACARNE", fetch=FetchType.LAZY)
	private List<BCEENTREGACARNE> BCEENTREGACARNEs;

	@OneToMany(mappedBy = "BCI", fetch=FetchType.LAZY)
	private List<BCI> BCIs;

	@OneToMany(mappedBy = "BCICUC", fetch=FetchType.LAZY)
	private List<BCICUC> BCICUCs;

	@OneToMany(mappedBy = "BCIENTREGACARNE", fetch=FetchType.LAZY)
	private List<BCIENTREGACARNE> BCIENTREGACARNEs;

	@OneToMany(mappedBy = "CUC", fetch=FetchType.LAZY)
	private List<TWSIP_CadastroDependenteDTO> tWSIP_CadastroDependenteDTOs;

	@OneToMany(mappedBy = "CUC", fetch=FetchType.LAZY)
	private List<TWSIP_CadastroPessoalDadoDTO> tWSIP_CadastroPessoalDadoDTOs;

	@OneToMany(mappedBy = "CEMEXUMACAO", fetch=FetchType.LAZY)
	private List<CEMEXUMACAO> CEMEXUMACAOs;

	@OneToMany(mappedBy = "CEMFUNCIONARIOCEMITERIO", fetch=FetchType.LAZY)
	private List<CEMFUNCIONARIOCEMITERIO> CEMFUNCIONARIOCEMITERIOs;

	@OneToMany(mappedBy = "CEMMEDICOLEGISTA", fetch=FetchType.LAZY)
	private List<CEMMEDICOLEGISTA> CEMMEDICOLEGISTAs;

	@OneToMany(mappedBy = "CONTADOR", fetch=FetchType.LAZY)
	private List<CONTADOR> CONTADORs;

	@OneToMany(mappedBy = "CT_TOMADACONTASESPECIAIS", fetch=FetchType.LAZY)
	private List<CT_TOMADACONTASESPECIAIS> CT_TOMADACONTASESPECIAISs;

	@OneToMany(mappedBy = "DIVIDAATIVA", fetch=FetchType.LAZY)
	private List<DIVIDAATIVA> DIVIDAATIVAs;

	OneToMany(mappedBy = "FISCAIS", fetch=FetchType.LAZY)
	private List<FISCAIS> FISCAISs;

	@OneToMany(mappedBy = "FL_VINCULOBENEFICIARIOPENSAO", fetch=FetchType.LAZY)
	private List<FL_VINCULOBENEFICIARIOPENSAO> FL_VINCULOBENEFICIARIOPENSAOs;

	@OneToMany(mappedBy = "cuc", fetch=FetchType.LAZY)
	private List<TFuncionarioEsocial> tFuncionarioEsocials;

	@OneToMany(mappedBy = "cuc", fetch=FetchType.LAZY)
	private List<TFuncionarioEstagio> tFuncionarioEstagios;

	@OneToMany(mappedBy = "cadastroUnico", fetch=FetchType.LAZY)
	private List<Credor> credors;

	@OneToMany(mappedBy = "FRT_ABASTECIMENTO", fetch=FetchType.LAZY)
	private List<FRT_ABASTECIMENTO> FRT_ABASTECIMENTOs;

	@OneToMany(mappedBy = "FRT_EQUIPAMENTOS", fetch=FetchType.LAZY)
	private List<FRT_EQUIPAMENTOS> FRT_EQUIPAMENTOSs;

	@OneToMany(mappedBy = "FRT_OPERADORES", fetch=FetchType.LAZY)
	private List<FRT_OPERADORES> FRT_OPERADORESs;

	@OneToMany(mappedBy = "FRT_RESPONSAVEIS", fetch=FetchType.LAZY)
	private List<FRT_RESPONSAVEIS> FRT_RESPONSAVEISs;

	@OneToMany(mappedBy = "FRT_SERVICOEXTERNO", fetch=FetchType.LAZY)
	private List<FRT_SERVICOEXTERNO> FRT_SERVICOEXTERNOs;

	@OneToMany(mappedBy = "FRT_UTILIZACAO", fetch=FetchType.LAZY)
	private List<FRT_UTILIZACAO> FRT_UTILIZACAOs;

	@OneToMany(mappedBy = "GRAFICA", fetch=FetchType.LAZY)
	private List<GRAFICA> GRAFICAs;

	@OneToMany(mappedBy = "CUC", fetch=FetchType.LAZY)
	private List<TItbiDTO> tItbiDTOs;

	@OneToMany(mappedBy = "CentroUnico", fetch=FetchType.LAZY)
	private List<LancamentoImpostoTaxa> lancamentoImpostoTaxas;

	@OneToMany(mappedBy = "NFAVULSA", fetch=FetchType.LAZY)
	private List<NFAVULSA> NFAVULSAs;

	@OneToMany(mappedBy = "NNOTIFICACAO", fetch=FetchType.LAZY)
	private List<NNOTIFICACAO> NNOTIFICACAOs;

	@OneToMany(mappedBy = "ORGAOSICOMRESPONSAVEL", fetch=FetchType.LAZY)
	private List<ORGAOSICOMRESPONSAVEL> ORGAOSICOMRESPONSAVELs;

	@OneToMany(mappedBy = "cadastroUnico", fetch=FetchType.LAZY)
	private List<Adiantamento> adiantamentos;

	@OneToMany(mappedBy = "PCA_CREDITOSRECEBER", fetch=FetchType.LAZY)
	private List<PCA_CREDITOSRECEBER> PCA_CREDITOSRECEBERs;

	@OneToMany(mappedBy = "PCA_PRECATORIOBENEFICIARIO", fetch=FetchType.LAZY)
	private List<PCA_PRECATORIOBENEFICIARIO> PCA_PRECATORIOBENEFICIARIOs;

	@OneToMany(mappedBy = "cadastroUnico", fetch=FetchType.LAZY)
	private List<PessoaFisica> pessoaFisicas;

	@OneToMany(mappedBy = "PJSOCIO", fetch=FetchType.LAZY)
	private List<PJSOCIO> PJSOCIOs;

	@OneToMany(mappedBy = "PRT_PROCESSO", fetch=FetchType.LAZY)
	private List<PRT_PROCESSO> PRT_PROCESSOs;

	@OneToMany(mappedBy = "CUC", fetch=FetchType.LAZY)
	private List<TUsuarioDTO> tUsuarioDTOs;
	*/
}

