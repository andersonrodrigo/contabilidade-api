package br.com.memory.contabilidade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.memory.contabilidade.model.Banco;

public interface BancoRepository  extends JpaRepository<Banco, Long>  {
	
	public Optional<Banco> findByDescricaoBanco(String descricao);
}
