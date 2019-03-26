package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.EventoGrupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EventoSubGrupoId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_GRUPOEVENTO", referencedColumnName = "COD_GRUPOEVENTO")
	private EventoGrupo eventoGrupo; // @RELACIONAMENTO:EVENTOGRUPO

	@Column(name = "COD_SUBGRUPOEVENTO")
	private Long codigoSubgrupoevento;

}
