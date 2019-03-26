package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.EventoSubGrupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EventoId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COD_GRUPOEVENTO", referencedColumnName = "COD_GRUPOEVENTO", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_SUBGRUPOEVENTO", referencedColumnName = "COD_SUBGRUPOEVENTO", insertable=false, updatable=false)
	})
	private EventoSubGrupo eventoSubGrupo; // @RELACIONAMENTO:EVENTOSUBGRUPO

	@Column(name = "COD_EVENTO")
	private Long codigoEvento;

}

