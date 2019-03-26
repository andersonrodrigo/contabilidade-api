package br.com.memory.contabilidade.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.memory.contabilidade.dto.EventoLancamentoDTO;
import br.com.memory.contabilidade.model.EventoLancamento;

public class EventoLancamentoRepositoryImpl implements EventoLancamentoRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<EventoLancamentoDTO> pesquisarEvento(Long codigoGrupoEvento, Long codigoSubGrupoEvento, Long codigoEvento) {
		List<EventoLancamento> listalanc;
		List<EventoLancamentoDTO> listaEvento = new ArrayList<>();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		String hql = "select "
				+ "		lanc "
				+ "from "
				+ "		EventoLancamento lanc "
				+ "where "
				+ "		lanc.idEventoLancamento.evento.idEvento.eventoSubGrupo.idEventoSubGrupo.eventoGrupo.codigoGrupoevento = :codigoGrupoEvento and "
				+ "		lanc.idEventoLancamento.evento.idEvento.eventoSubGrupo.idEventoSubGrupo.codigoSubgrupoevento = :codigoSubGrupoEvento and "
				+ "		lanc.idEventoLancamento.evento.idEvento.codigoEvento = :codigoEvento ";
		
		parametros.put("codigoGrupoEvento",  codigoGrupoEvento);
		parametros.put("codigoSubGrupoEvento",  codigoSubGrupoEvento);
		parametros.put("codigoEvento",  codigoEvento);

		TypedQuery<EventoLancamento> query = entityManager.createQuery(hql, EventoLancamento.class);
		parametros.keySet().forEach(p -> query.setParameter(p, parametros.get(p)));
		
		listalanc = query.getResultList();
		
		listalanc.stream().forEach(evento -> {
			listaEvento.add(EventoLancamentoDTO.builder().
					codigoCtcontabcred(evento.getContaContabilCredito().getCodigoCtcontab()).
					codigoCtcontabdeb(evento.getContaContabilDebito().getCodigoCtcontab()).
					historicoEvento(evento.getIdEventoLancamento().getEvento().getHistoricoPadrao().getDescricaoHistorico()).
					codigoGrupoEvento(codigoGrupoEvento).
					codigoSubGrupoEvento(codigoSubGrupoEvento).
					codigoEvento(codigoEvento).build());
		});
		
		return listaEvento;
	}
}
