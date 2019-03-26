package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.memory.contabilidade.model.Agencia;
import br.com.memory.contabilidade.model.Id.AgenciaId;

public interface AgenciaRepository extends JpaRepository<Agencia, AgenciaId>{

}
