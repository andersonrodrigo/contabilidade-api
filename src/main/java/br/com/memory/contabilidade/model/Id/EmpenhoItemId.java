package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.Empenho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpenhoItemId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_SERIEEMPENHO", referencedColumnName = "NRO_SERIEEMPENHO", insertable=false, updatable=false), 
		@JoinColumn(name = "NRO_EMPENHO", referencedColumnName = "NRO_EMPENHO", insertable=false, updatable=false)
	})
	private Empenho empenho; // @RELACIONAMENTO:EMPENHO

	@Column(name = "NRO_ITEM")
	private Long numeroItem;

}

