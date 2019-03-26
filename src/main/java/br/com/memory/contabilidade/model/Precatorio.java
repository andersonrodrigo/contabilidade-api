package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
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
@Table(name = "PCA_PRECATORIO")
@Entity
public class Precatorio {
	@Id
	@Column(name = "ID_PRECATORIO")
	private Long idPrecatorio;

	@Column(name = "COD_ENTIDADE")
	private Long codigoEntidade;

	@Column(name = "NRO_PRECATORIO")
	private Long numeroPrecatorio;

	@Column(name = "DAT_PRECATORIO")
	private Timestamp dataPrecatorio;

	@Column(name = "NRO_CUC")
	private Long numeroCuc;

	@Column(name = "VLR_PRECATORIO")
	private BigDecimal valorPrecatorio;

	@Column(name = "DES_FINALIDADE")
	private String descricaoFinalidade;

	@Column(name = "FGL_NAUTEZAALIMENTICIA")
	private String flagNautezaalimenticia;

	@Column(name = "ANO_EXERCINCLUSAO")
	private String anoExercinclusao;

	@Column(name = "DAT_JULGADO")
	private Timestamp dataJulgado;

	@Column(name = "DAT_QUITACAO")
	private Timestamp dataQuitacao;

	@Column(name = "DAT_EXTICAO")
	private Timestamp dataExticao;

	@Column(name = "NRO_PROVISAO")
	private Long numeroProvisao;

	@Column(name = "IDT_TIPOPRECATORIO")
	private String idtTipoprecatorio;

	@Column(name = "DAT_CANCELAMENTOPRECATORIO")
	private Timestamp dataCancelamentoprecatorio;

	@Column(name = "DES_MOTIVOCANCELAMENTO")
	private String descricaoMotivocancelamento;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_VENCIMENTO")
	private Timestamp dataVencimento;

	@Column(name = "DAT_REFERENCIA")
	private Timestamp dataReferencia;

	@OneToMany(mappedBy = "precatorio", fetch=FetchType.LAZY)
	private List<Empenho> listaEmpenho;

	/*
	@OneToMany(mappedBy = "PCA_PRECATORIO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> listaBalanceteChaveDetalhe;

	@OneToMany(mappedBy = "PCA_PRECATORIO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> listaBalanceteChaveDetalheFAKE;
	*/
	
	@OneToMany(mappedBy = "precatorio", fetch=FetchType.LAZY)
	private List<BeneficiarioPrecatorio> listaBeneficiarioPrecatorio;

	@OneToMany(mappedBy = "precatorio", fetch=FetchType.LAZY)
	private List<MovimentoPrecatorio> listaMovimentoPrecatorio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SITUACAOPRECATORIO", referencedColumnName = "ID_SITUACAOPRECATORIO")
	private SituacaoPrecatorio situacaPrecatorio; // @RELACIONAMENTO:PCA_SITUACAOPRECATORIO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TIPOPRECATORIO", referencedColumnName = "ID_TIPOPRECATORIO")
	private TipoPrecatorio tipoPrecatorio; // @RELACIONAMENTO:PCA_TIPOPRECATORIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TPSENTENCAJUDICIAL", referencedColumnName = "ID_TPSENTENCAJUDICIAL")
	private TipoSentencaJudicial tipoSentencaJudicial; // @RELACIONAMENTO:PCA_TPSENTENCASJUDICIAIS

}

