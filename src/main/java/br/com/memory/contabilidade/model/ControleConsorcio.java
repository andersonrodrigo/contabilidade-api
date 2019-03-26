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
@Table(name = "PCA_CONTROLECONSORCIO")
@Entity
public class ControleConsorcio {
	@Id
	@Column(name = "ID_CONTROLECONSORCIO")
	private Long idControleconsorcio;

	@Column(name = "NRO_ANOFISCAL")
	private Long numeroAnofiscal;

	@Column(name = "NRO_MESREFERENCIA")
	private Long numeroMesreferencia;

	@Column(name = "DAT_PRESTACAOCONTA")
	private Timestamp dataPrestacaoconta;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "VLR_SALDOANTERIOR")
	private BigDecimal valorSaldoanterior;

	@Column(name = "DAT_APROVACAO")
	private Timestamp dataAprovacao;

	/*
	@OneToMany(mappedBy = "PCA_CONTROLECONSORCIO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> listaBalanceteChaveDetalhe;

	@OneToMany(mappedBy = "PCA_CONTROLECONSORCIO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> listaBalanceteChaveDetalheFAKE;
	*/

	@OneToMany(mappedBy = "controleConsorcio", fetch=FetchType.LAZY)
	private List<ControleValoresConsorcio> listaControleValoresConsorcio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONSORCIO", referencedColumnName = "ID_CONSORCIO")
	private Consorcio consorcio; // @RELACIONAMENTO:PCA_CONSORCIOS

}

