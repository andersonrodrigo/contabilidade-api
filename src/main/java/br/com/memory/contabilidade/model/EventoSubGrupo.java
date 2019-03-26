package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.EventoSubGrupoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EVENTOSUBGRUPO")
@Entity
public class EventoSubGrupo {
	@EmbeddedId
	private EventoSubGrupoId idEventoSubGrupo;

	@Column(name = "DES_SUBGRUPOEVENTO")
	private String descricaoSubgrupoevento;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FGL_MOVIMENTACAOCONTABIL")
	private String flagMovimentacaocontabil;

	@OneToMany(mappedBy = "idEvento.eventoSubGrupo", fetch=FetchType.LAZY)
	private List<Evento> listaEvento;

}

