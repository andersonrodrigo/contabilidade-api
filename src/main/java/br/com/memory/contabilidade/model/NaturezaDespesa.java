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

import br.com.memory.contabilidade.model.Id.NaturezaDespesaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "DESPESACLASSIFICACAO")
@Entity
public class NaturezaDespesa {
	@EmbeddedId
	private NaturezaDespesaId idNaturezaDespesa;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_DESPESA", referencedColumnName = "COD_DESPESA", insertable=false, updatable=false)
	})
	private NaturezaDespesa naturezaDespesaSUP; // @RELACIONAMENTO:DESPESACLASSIFICACAO

	@Column(name = "COD_AUXILIAR")
	private String codigoAuxiliar;

	@Column(name = "COD_DESPESASEMMASCARA")
	private String codigoDespesasemmascara;

	@Column(name = "DES_DESPESA")
	private String descricaoDespesa;

	@Column(name = "FGL_PESSOAL")
	private String flagPessoal;

	@Column(name = "IDT_TIPODESPESA")
	private String idtTipodespesa;

	@Column(name = "FGL_EXCLUSAODESPESA")
	private String flagExclusaodespesa;

	@Column(name = "FGL_EXCLUIREDUCACAO")
	private String flagExcluireducacao;

	@Column(name = "FGL_EXCLUIRSAUDE")
	private String flagExcluirsaude;

	@Column(name = "FGL_SINTETICA")
	private String flagSintetica;

	@Column(name = "FGL_DEDUZPASEP")
	private String flagDeduzpasep;

	@Column(name = "FGL_NAOEXIGEPROCESSO")
	private String flagNaoexigeprocesso;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FGL_INCIDEDIRF")
	private String flagIncidedirf;

	@Column(name = "FGL_NATUREZASERVICO")
	private String flagNaturezaservico;

	@Column(name = "FGL_INTRAORCAMENTARIA")
	private String flagIntraorcamentaria;

	@Column(name = "FGL_SICOM")
	private String flagSicom;

	@Column(name = "FGL_PRODUTO")
	private String flagProduto;

	@Column(name = "COD_DESPESA_SICOM")
	private String codigoDespesasicom;

	@Column(name = "NRO_ANOFISCAL_SICOM")
	private Long numeroAnofiscalsicom;

	@Column(name = "FGL_DESPESAPRIMARIA")
	private String flagDespesaprimaria;

	@Column(name = "FGL_CONSORCIOPUBLICO")
	private String flagConsorciopublico;

	@Column(name = "FGL_DIVIDAFUNDADA")
	private String flagDividafundada;

	@Column(name = "FGL_JUROSDIVIDAFUNDADA")
	private String flagJurosdividafundada;

	@Column(name = "FGL_ENCARGOSPATRIMONIAL")
	private String flagEncargospatrimonial;

	@Column(name = "FGL_DESPESAEFETIVA")
	private String flagDespesaefetiva;

	@Column(name = "FGL_CODIGOSISTEMA")
	private String flagCodigosistema;

	@Column(name = "FGL_DETALHACODIGO")
	private String flagDetalhacodigo;

	@Column(name = "FGL_CODIGOPADRAO")
	private String flagCodigopadrao;

	@Column(name = "COD_GRUPOPATRIMONIO")
	private Long codigoGrupopatrimonio;

	@Column(name = "FGL_CORRECAOMONETARIA")
	private String flagCorrecaomonetaria;

	@Column(name = "FGL_CONCEMPFINANCIAMENTO")
	private String flagConcempfinanciamento;

	@Column(name = "FGL_CONTROLAPRECATORIO")
	private String flagControlaprecatorio;

	@Column(name = "FGL_MOVIMENTAFOLHA")
	private String flagMovimentafolha;

	@Column(name = "FGL_MOVIMENTAPATRIMONIO")
	private String flagMovimentapatrimonio;

	@Column(name = "FGL_MOVIMENTAALMOXARIFADO")
	private String flagMovimentaalmoxarifado;

	@Column(name = "FGL_MOVIMENTAPPP")
	private String flagMovimentappp;

	@Column(name = "COD_DESPESA_MSC")
	private String codigoDespesamsc;

	@OneToMany(mappedBy = "naturezaDespesa", fetch=FetchType.LAZY)
	private List<Contabilizacao4320> contabilizacao4320s;

	@OneToMany(mappedBy = "naturezaDespesaSUP", fetch=FetchType.LAZY)
	private List<NaturezaDespesa> naturezaDespesas;

	@OneToMany(mappedBy = "naturezaDespesa", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;

	/*
	@OneToMany(mappedBy = "naturezaDespesa", fetch=FetchType.LAZY)
	private List<NaturezaDespesaSIOPE> naturezaDespesaSIOPEs;

	@OneToMany(mappedBy = "LDOADEQUACAODESPESA", fetch=FetchType.LAZY)
	private List<LDOADEQUACAODESPESA> LDOADEQUACAODESPESAs;

	@OneToMany(mappedBy = "LDODESPESAS", fetch=FetchType.LAZY)
	private List<LDODESPESAS> LDODESPESASs;

	@OneToMany(mappedBy = "PCA_ADIANTAMENTOFICHAS", fetch=FetchType.LAZY)
	private List<PCA_ADIANTAMENTOFICHAS> PCA_ADIANTAMENTOFICHASs;

	@OneToMany(mappedBy = "naturezaDespesa", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "naturezaDespesa", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> balanceteChaveDetalheFAKEs;

	@OneToMany(mappedBy = "RELATORIOCONTABCONTA", fetch=FetchType.LAZY)
	private List<RELATORIOCONTABCONTA> RELATORIOCONTABCONTAs;
	*/
}

