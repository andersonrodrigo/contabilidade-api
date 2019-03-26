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
@Table(name = "PCA_PRECATORIOBENEFICIARIO")
@Entity
public class BeneficiarioPrecatorio {
	@Id
	@Column(name = "ID_PRECATORIOBENEFICIARIO")
	private Long idPrecatoriobeneficiario;

	@Column(name = "VLR_SENTENCA")
	private BigDecimal valorSentenca;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC")
	private CadastroUnico cadastroUnico; // @RELACIONAMENTO:CUC

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PRECATORIO", referencedColumnName = "ID_PRECATORIO")
	private Precatorio precatorio; // @RELACIONAMENTO:PCA_PRECATORIO

}
