package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.Entidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmpenhoId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE")
	private Entidade entidade; // @RELACIONAMENTO:ENTIDADE

	@Column(name = "NRO_SERIEEMPENHO")
	private Long numeroSerieempenho;

	@Column(name = "NRO_EMPENHO")
	private Long numeroEmpenho;

}
