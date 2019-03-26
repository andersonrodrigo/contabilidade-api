package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.memory.contabilidade.model.PlanoContasPCASP;

public interface PlanoContasPCASPRepository extends JpaRepository<PlanoContasPCASP, Long> {
	@Query("SELECT C FROM PlanoContasPCASP AS C WHERE C.codigoConta = ?1 AND versaoPCASP.idVersao = ?2")
	public PlanoContasPCASP retornaIDPlanoContas(String codigoContaPCASP, Long idVersaoPCASP);
}
