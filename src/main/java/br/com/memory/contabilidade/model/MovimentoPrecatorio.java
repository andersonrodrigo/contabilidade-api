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
@Table(name = "PCA_PRECATORIOMOVIMENTO")
@Entity
public class MovimentoPrecatorio {
	@Id
	@Column(name = "ID_PRECATORIOMOVIMENTO")
	private Long idPrecatoriomovimento;

	@Column(name = "SEQ_RECEITAORCAMENTO")
	private Long sequencialReceitaorcamento;

	@Column(name = "COD_CONTROLE")
	private Long codigoControle;

	@Column(name = "IDT_MOVIMENTO")
	private String idtMovimento;

	@Column(name = "DAT_MOVIMENTO")
	private Timestamp dataMovimento;

	@Column(name = "VLR_MOVIMENTO")
	private BigDecimal valorMovimento;

	@Column(name = "IDT_DBCRD")
	private Long idtDbcrd;

	@Column(name = "DES_MOVIMENTO")
	private String descricaoMovimento;

	@Column(name = "NRO_ANOFISCAL")
	private Long numeroAnofiscal;

	@Column(name = "COD_RECEITA")
	private String codigoReceita;

	@Column(name = "COD_CONTACORRENTE")
	private String codigoContacorrente;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	/*
	@OneToMany(mappedBy = "PCA_PRECATORIOMOVIMENTO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> listaBalanceteChaveDetalhe;

	@OneToMany(mappedBy = "PCA_PRECATORIOMOVIMENTO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> listaBalanceteChaveDetalheFAKE;
	*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PRECATORIO", referencedColumnName = "ID_PRECATORIO")
	private Precatorio precatorio; // @RELACIONAMENTO:PCA_PRECATORIO

}

