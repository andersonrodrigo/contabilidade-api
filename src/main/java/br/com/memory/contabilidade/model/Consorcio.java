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
@Table(name = "PCA_CONSORCIOS")
@Entity
public class Consorcio {
	@Id
	@Column(name = "ID_CONSORCIO")
	private Long idConsorcio;

	@Column(name = "NRO_CONSORCIO")
	private Long numeroConsorcio;

	@Column(name = "NRO_CONTRATO")
	private Long numeroContrato;

	@Column(name = "DAT_ASSINATURA")
	private Timestamp dataAssinatura;

	@Column(name = "NRO_LEI")
	private Long numeroLei;

	@Column(name = "DAT_LEI")
	private Timestamp dataLei;

	@Column(name = "DES_PUBLICACAO")
	private String descricaoPublicacao;

	@Column(name = "DAT_PUBLICACAO")
	private Timestamp dataPublicacao;

	@Column(name = "DES_FINALIDADE")
	private String descricaoFinalidade;

	@Column(name = "DAT_ENCERRAMENTO")
	private Timestamp dataEncerramento;

	@Column(name = "DAT_ULTIMACONTAS")
	private Timestamp dataUltimacontas;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_INCLUSAO")
	private Timestamp dataInclusao;

	@Column(name = "VLR_ANUAL")
	private BigDecimal valorAnual;

	@Column(name = "DAT_INICIOVIGENCIA")
	private Timestamp dataIniciovigencia;

	@Column(name = "DAT_FIMVIGENCIA")
	private Timestamp dataFimvigencia;

	@Column(name = "DAT_INCLUSAO_LAI")
	private Timestamp dataInclusaolai;

	@OneToMany(mappedBy = "consorcio", fetch=FetchType.LAZY)
	private List<Empenho> listaEmpenho;

	/*
	@OneToMany(mappedBy = "PCA_CONSORCIOS", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> listaBalanceteChaveDetalhe;

	@OneToMany(mappedBy = "PCA_CONSORCIOS", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> listaBalanceteChaveDetalheFAKE;
	*/
	
	@OneToMany(mappedBy = "consorcio", fetch=FetchType.LAZY)
	private List<MovimentoConsorcio> listaMovimentoConsorcio;

	@OneToMany(mappedBy = "consorcio", fetch=FetchType.LAZY)
	private List<ControleConsorcio> listaControleConsorcio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE")
	private Entidade entidade; // @RELACIONAMENTO:ENTIDADE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_AREASCONSORCIOPUBLICO", referencedColumnName = "ID_AREASCONSORCIOPUBLICO")
	private AreaConsorcio areaConsorcio; // @RELACIONAMENTO:PCA_AREASCONSORCIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ENCERRAMENTOCONSORCIO", referencedColumnName = "ID_ENCERRAMENTOCONSORCIO")
	private EncerramentoConsorcio encerramentoConsorcio; // @RELACIONAMENTO:PCA_ENCERRAMENTOCONSORCIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SITUACAOCONSORCIO", referencedColumnName = "ID_SITUACAOCONSORCIO")
	private SituacaoConsorcio situacaoConsorcio; // @RELACIONAMENTO:PCA_SITUACAOCONSORCIOS

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TPCONTRATOCONSORCIO", referencedColumnName = "ID_TPCONTRATOCONSORCIO")
	private TipoContratoConsorcio tipoContratoConsorcio; // @RELACIONAMENTO:PCA_TPCONTRATOCONSORCIOS

}

