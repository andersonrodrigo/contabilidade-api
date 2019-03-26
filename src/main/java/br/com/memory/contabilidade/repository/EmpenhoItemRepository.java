package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.memory.contabilidade.model.EmpenhoItem;
import br.com.memory.contabilidade.model.Id.EmpenhoId;

public interface EmpenhoItemRepository extends JpaRepository<EmpenhoItem, EmpenhoId> {

}
