package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CTCONTAB")
@Entity
public class PlanoContasMemory {
	@Id
	@Column(name = "COD_CTCONTAB")
	private String codigoCtcontab;

	@Column(name = "COD_CTCONTABAUX")
	private String codigoCtcontabaux;

	@Column(name = "COD_CTCONTABSEMMASCARA")
	private String codigoCtcontabsemmascara;

	@Column(name = "DES_CONTA")
	private String descricaoConta;

	@Column(name = "IDT_CREDDEB")
	private Long idtCreddeb;

	@Column(name = "FGL_CONTASINTETICA")
	private String flagContasintetica;

	@Column(name = "FLG_INVERSAO")
	private String flagInversao;

	@Column(name = "FGL_ENCERRASALDO")
	private String flagEncerrasaldo;

	@Column(name = "IDT_CAMPOIMPRESSAO")
	private String idtCampoimpressao;

	@Column(name = "IDT_CONTA")
	private String idtConta;

	@Column(name = "COD_CTCONTAB_RPPS")
	private String codigoCtcontabrpps;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "DES_CONTA_RPPS")
	private String descricaoContarpps;

	@Column(name = "DES_CTCONTAB_RPPS")
	private String descricaoCtcontabrpps;

	@Column(name = "FGL_PCASP")
	private String flagPcasp;

	/*
	@OneToMany(mappedBy = "CONTAMAEEXTRAORCAMENTARIA", fetch=FetchType.LAZY)
	private List<CONTAMAEEXTRAORCAMENTARIA> CONTAMAEEXTRAORCAMENTARIAs;

	@OneToMany(mappedBy = "PlanoContasMemorySUP", fetch=FetchType.LAZY)
	private List<PlanoContasMemory> planoContasMemorys;

	@OneToMany(mappedBy = "planoContasMemory", fetch=FetchType.LAZY)
	private List<Contabilizacao4320> contabilizacao4320s;

	@OneToMany(mappedBy = "planoContasMemory", fetch=FetchType.LAZY)
	private List<ContaCorrente> contaCorrentes;

	@OneToMany(mappedBy = "CTDEPRECIACAOCORRECAO", fetch=FetchType.LAZY)
	private List<CTDEPRECIACAOCORRECAO> CTDEPRECIACAOCORRECAOs;

	@OneToMany(mappedBy = "planoContasMemory", fetch=FetchType.LAZY)
	private List<DividaFundada> dividaFundadas;

	@OneToMany(mappedBy = "EVENTOLANCAMENTO", fetch=FetchType.LAZY)
	private List<EVENTOLANCAMENTO> EVENTOLANCAMENTOs;

	@OneToMany(mappedBy = "EXORCFICHA", fetch=FetchType.LAZY)
	private List<EXORCFICHA> EXORCFICHAs;

	@OneToMany(mappedBy = "LOCALARMAZENAMENTO", fetch=FetchType.LAZY)
	private List<LOCALARMAZENAMENTO> LOCALARMAZENAMENTOs;

	@OneToMany(mappedBy = "planoContasMemory", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "planoContasMemory", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> balanceteChaveDetalheFAKEs;

	@OneToMany(mappedBy = "PCA_TIPOCONTAEXORC", fetch=FetchType.LAZY)
	private List<PCA_TIPOCONTAEXORC> PCA_TIPOCONTAEXORCs;

	@OneToMany(mappedBy = "PCA_TPCAIXABANCOS", fetch=FetchType.LAZY)
	private List<PCA_TPCAIXABANCOS> PCA_TPCAIXABANCOSs;
	*/

}

