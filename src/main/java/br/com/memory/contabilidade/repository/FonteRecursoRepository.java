package br.com.memory.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.memory.contabilidade.model.FonteRecurso;
import br.com.memory.contabilidade.model.Id.FonteRecursoId;

public interface FonteRecursoRepository extends JpaRepository<FonteRecurso, FonteRecursoId> {
	@Query("SELECT "
		+  "	F "
		+  "FROM "
		+ "		FonteRecurso as F "
		+ "		INNER JOIN FETCH F.idFonteRecurso as IDF "
		+ "WHERE "
		+ "		F.idFonteRecurso.anoFiscal.numeroAnofiscal = ?1 AND "
		+ "		F.codigoFonterecursodestinacao = ?2 ")
	public FonteRecurso retornaFonteRecurso(Long numeroAnoFiscal, String codigoFonteRecurso);
}
