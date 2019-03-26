package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.EventoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EVENTO")
@Entity
public class Evento {
	@EmbeddedId
	private EventoId idEvento;

	@Column(name = "DES_EVENTO")
	private String descricaoEvento;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	/*
	@OneToMany(mappedBy = "evento", fetch=FetchType.LAZY)
	private List<DespesaEvento> listaDespesaEvento;
	*/

	@OneToMany(mappedBy = "idEventoLancamento.evento", fetch=FetchType.LAZY)
	private List<EventoLancamento> listaEventoLancamento;

	/*
	@OneToMany(mappedBy = "PATMOTIVOEVENTO", fetch=FetchType.LAZY)
	private List<PATMOTIVOEVENTO> listaPATMOTIVOEVENTO;

	@OneToMany(mappedBy = "RECEITAEVENTO", fetch=FetchType.LAZY)
	private List<RECEITAEVENTO> listaRECEITAEVENTO;
	*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_HISTORICO", referencedColumnName = "COD_HISTORICO")
	private HistoricoPadrao historicoPadrao; // @RELACIONAMENTO:HISTORICOPADRAO

}

