package br.com.memory.contabilidade.repository;

import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.memory.contabilidade.dto.EmpenhoDTO;

public interface EmpenhoRepositoryCustom {
	public EmpenhoDTO pesquisarLancamentoEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho) throws UnsupportedEncodingException;
	public List <EmpenhoDTO> pesquisarListaEmpenho(Long codigoEntidade, Long serieEmpenho);
	public void salvarEmpenho(EmpenhoDTO empenhoDTO);	
	public void excluirEmpenho(Long codigoEntidade, Long serieEmpenho, Long numeroEmpenho);
}
