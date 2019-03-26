package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.memory.contabilidade.model.FonteRecurso;
import br.com.memory.contabilidade.model.OrcamentoDespesa;

public interface OrcamentoDespesaRepository extends JpaRepository<OrcamentoDespesa, Long> {
	@Query("SELECT "
			+  "	ORC "
			+  "FROM "
			+ "		OrcamentoDespesa as ORC "
			+ "		INNER JOIN FETCH ORC.fonteRecurso as F "
			+ "		INNER JOIN FETCH F.idFonteRecurso as IDF "
			+ "		INNER JOIN FETCH ORC.unidadeOrcamentaria as UOR "
			+ "WHERE "
			+ "		ORC.anofiscal.numeroAnofiscal = ?1 AND "
			+ "		ORC.codigoFicha = ?2 AND "
			+ "		F.codigoFonterecursodestinacao = ?3 AND "
			+ "		UOR.entidade.codigoEntidade = ?4 ")
		public OrcamentoDespesa retornaOrcamentoDespesaPorficha(Long numeroAnoFiscal, 
															Long codigoFicha, 
															String codigoFonteRecurso,
															Long codigoEntidade);
}
