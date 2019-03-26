package br.com.memory.contabilidade.repository;

import br.com.memory.contabilidade.model.Contabilizacao4320;

public interface Contabilizacao4320RepositoryCustom {
	public Boolean criaLancamentoContabil(Long codigoGrupoEvento, Long codigoSubGrupoEvento, Long codigoEvento,
										  Contabilizacao4320 contabilizacao);
}