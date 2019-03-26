package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.EmpenhoItemId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EMPENHOITEM")
@Entity
public class EmpenhoItem {
	@EmbeddedId
	private EmpenhoItemId idEmpenhoItem;

	@Column(name = "DES_ITEM")
	private byte[] descricaoItem;

	@Builder.Default
	@Column(name = "QTD_ITEM")
	private BigDecimal quantidadeItem = new BigDecimal(0.00);

	@Builder.Default
	@Column(name = "VLR_ITEM")
	private BigDecimal valorItem = new BigDecimal(0.00);

	@Column(name = "DES_UNIDADE")
	private String descricaoUnidade;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;
}
