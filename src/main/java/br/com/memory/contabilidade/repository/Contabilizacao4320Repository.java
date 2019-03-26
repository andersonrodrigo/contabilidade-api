package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.memory.contabilidade.model.Contabilizacao4320;

public interface Contabilizacao4320Repository extends JpaRepository<Contabilizacao4320, Long>, Contabilizacao4320RepositoryCustom {
	@Query("select max(c.numeroLanccontab) from Contabilizacao4320 c")
	public Long retornaProximoLancamentoContabil();

	@Query("select max(c.sequencialCtcontablanc) from Contabilizacao4320 c")
	public Long retornaProximoIdContabilizacao();
}
