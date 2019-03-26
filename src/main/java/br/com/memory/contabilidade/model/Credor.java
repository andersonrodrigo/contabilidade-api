package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.CredorId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "FORNECEDOR")
@Entity
public class Credor {
	@EmbeddedId
	private CredorId idCredor;

	@Column(name = "NRO_CONTA")
	private String numeroConta;

	@Column(name = "NRO_DIGITOCONTA")
	private String numeroDigitoconta;

	@Column(name = "DES_CONTATO")
	private String descricaoContato;

	@Column(name = "NRO_FONE1")
	private String numeroFone1;

	@Column(name = "NRO_FONE2")
	private String numeroFone2;

	@Column(name = "NRO_FAX")
	private String numeroFax;

	@Column(name = "DES_EMAIL")
	private String descricaoEmail;

	@Column(name = "DES_OBJETIVO")
	private String descricaoObjetivo;

	@Column(name = "DAT_CERTIDAO")
	private Timestamp dataCertidao;

	@Column(name = "DES_VALIDADE")
	private String descricaoValidade;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "DES_CERTIFICADO")
	private String descricaoCertificado;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "NRO_REGISTRO")
	private String numeroRegistro;

	@Column(name = "DAT_REGISTRO")
	private Timestamp dataRegistro;

	@Column(name = "IDT_ORGAOREGISTRO")
	private String idtOrgaoregistro;

	@Column(name = "ID_NIVELCONSOLIDACAO")
	private Long idNivelconsolidacao;

	@Column(name = "FGL_ESTRANGEIRO")
	private String flagEstrangeiro;

	@OneToMany(mappedBy = "credor", fetch=FetchType.LAZY)
	private List<Empenho> empenhos;

	/*
	@OneToMany(mappedBy = "EXORC", fetch=FetchType.LAZY)
	private List<EXORC> EXORCs;

	@OneToMany(mappedBy = "EXORCFICHA", fetch=FetchType.LAZY)
	private List<EXORCFICHA> EXORCFICHAs;

	@OneToMany(mappedBy = "FOLFORNECEDORCONVENIO", fetch=FetchType.LAZY)
	private List<FOLFORNECEDORCONVENIO> FOLFORNECEDORCONVENIOs;

	@OneToMany(mappedBy = "FORNECEDORCERTIDAO", fetch=FetchType.LAZY)
	private List<FORNECEDORCERTIDAO> FORNECEDORCERTIDAOs;

	@OneToMany(mappedBy = "FORNECEDORDESCONTO", fetch=FetchType.LAZY)
	private List<FORNECEDORDESCONTO> FORNECEDORDESCONTOs;

	@OneToMany(mappedBy = "FORNECEDORIMPEDIMENTO", fetch=FetchType.LAZY)
	private List<FORNECEDORIMPEDIMENTO> FORNECEDORIMPEDIMENTOs;

	@OneToMany(mappedBy = "FORNECEDORRECOLHIMENTO", fetch=FetchType.LAZY)
	private List<FORNECEDORRECOLHIMENTO> FORNECEDORRECOLHIMENTOs;

	@OneToMany(mappedBy = "FORNECEDORSUBGRUPOPRODUTO", fetch=FetchType.LAZY)
	private List<FORNECEDORSUBGRUPOPRODUTO> FORNECEDORSUBGRUPOPRODUTOs;

	@OneToMany(mappedBy = "FORNECEDORTEXTO", fetch=FetchType.LAZY)
	private List<FORNECEDORTEXTO> FORNECEDORTEXTOs;

	@OneToMany(mappedBy = "fornecedor", fetch=FetchType.LAZY)
	private List<TFrtPecaServicoItemDTO> tFrtPecaServicoItemDTOs;

	@OneToMany(mappedBy = "MOVIMENTOESTOQUE", fetch=FetchType.LAZY)
	private List<MOVIMENTOESTOQUE> MOVIMENTOESTOQUEs;

	@OneToMany(mappedBy = "PATRIMONIO", fetch=FetchType.LAZY)
	private List<PATRIMONIO> PATRIMONIOs;

	@OneToMany(mappedBy = "fornecedor", fetch=FetchType.LAZY)
	private List<ProcessoFornecedor> processoFornecedors;

	@OneToMany(mappedBy = "RECEBIMENTOPRODUTO", fetch=FetchType.LAZY)
	private List<RECEBIMENTOPRODUTO> RECEBIMENTOPRODUTOs;

	@OneToMany(mappedBy = "TABELACONTABILFOLHA", fetch=FetchType.LAZY)
	private List<TABELACONTABILFOLHA> TABELACONTABILFOLHAs;
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_BANCO", referencedColumnName = "COD_BANCO", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_AGENCIA", referencedColumnName = "COD_AGENCIA", insertable=false, updatable=false)
	})
	private Agencia agencia; // @RELACIONAMENTO:AGENCIA

	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_GRUPOENTIDADE", referencedColumnName = "COD_GRUPOENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_VERBA", referencedColumnName = "COD_VERBA", insertable=false, updatable=false)
	})
	private Verba verba; // @RELACIONAMENTO:VERBA
	*/

}

