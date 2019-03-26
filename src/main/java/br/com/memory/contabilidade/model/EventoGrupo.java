package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "EVENTOGRUPO")
@Entity
public class EventoGrupo {
	@Id
	@Column(name = "COD_GRUPOEVENTO")
	private Long codigoGrupoevento;

	@Column(name = "DES_GRUPOEVENTO")
	private String descricaoGrupoevento;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "idEventoSubGrupo.eventoGrupo", fetch=FetchType.LAZY)
	private List<EventoSubGrupo> listaEventoSubGrupo;
}
