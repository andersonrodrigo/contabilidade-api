package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.memory.contabilidade.model.EventoLancamento;
import br.com.memory.contabilidade.model.Id.EventoLancamentoId;

public interface EventoLancamentoRepository extends JpaRepository<EventoLancamento, EventoLancamentoId>, EventoLancamentoRepositoryCustom {

}
