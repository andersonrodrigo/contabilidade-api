package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.memory.contabilidade.model.AnoFiscal;

public interface AnoFiscalRepository extends JpaRepository<AnoFiscal, Long> {

}
