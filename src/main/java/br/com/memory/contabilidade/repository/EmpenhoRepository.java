package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.memory.contabilidade.model.Empenho;
import br.com.memory.contabilidade.model.Id.EmpenhoId;

public interface EmpenhoRepository extends JpaRepository<Empenho, EmpenhoId>, EmpenhoRepositoryCustom{
	
}
