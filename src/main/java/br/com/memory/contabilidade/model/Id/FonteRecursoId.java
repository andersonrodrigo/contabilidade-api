package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.AnoFiscal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FonteRecursoId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL")
	private AnoFiscal anoFiscal; // @RELACIONAMENTO:ANOFISCAL

	@Column(name = "COD_FONTERECURSO")
	private Long codigoFonterecurso;

}
