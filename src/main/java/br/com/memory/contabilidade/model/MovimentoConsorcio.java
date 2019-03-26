
package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
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
@Table(name = "PCA_CONSORCIOMOVIMENTO")
@Entity
public class MovimentoConsorcio {
	@Id
	@Column(name = "ID_CONSORCIOMOVIMENTO")
	private Long idConsorciomovimento;

	@Column(name = "IDT_MOVIMENTO")
	private String idtMovimento;

	@Column(name = "NRO_CONTROLE")
	private Long numeroControle;

	@Column(name = "DAT_MOVIMENTO")
	private Timestamp dataMovimento;

	@Column(name = "VLR_MOVIMENTO")
	private BigDecimal valorMovimento;

	@Column(name = "IDT_DBCRD")
	private Long idtDbcrd;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONSORCIO", referencedColumnName = "ID_CONSORCIO")
	private Consorcio consorcio; // @RELACIONAMENTO:PCA_CONSORCIOS

	/*
	@OneToMany(mappedBy = "PCA_CONSORCIOMOVIMENTO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> listaBalanceteChaveDetalhe;

	@OneToMany(mappedBy = "PCA_CONSORCIOMOVIMENTO", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalheFAKE> listaBalanceteChaveDetalheFAKE;
	*/
}
