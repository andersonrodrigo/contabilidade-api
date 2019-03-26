package br.com.memory.contabilidade.repository;

import java.util.List;

import br.com.memory.contabilidade.dto.EventoLancamentoDTO;

public interface EventoLancamentoRepositoryCustom {
	public List<EventoLancamentoDTO> pesquisarEvento(Long codigoGrupoEvento, Long codigoSubGrupoEvento, Long codigoEvento);
}
