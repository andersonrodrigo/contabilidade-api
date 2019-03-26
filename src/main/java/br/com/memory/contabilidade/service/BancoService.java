package br.com.memory.contabilidade.service;

import br.com.memory.contabilidade.dto.AgenciaDTO;
import br.com.memory.contabilidade.dto.BancoDTO;
import br.com.memory.contabilidade.model.Agencia;
import br.com.memory.contabilidade.model.Banco;
import br.com.memory.contabilidade.repository.BancoRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repository;

	public BancoDTO pesquisarBanco(Long codigoBanco) throws Exception {

		Optional<Banco> optional = repository.findById(codigoBanco);
		
		Banco b = optional.orElseThrow(() -> new Exception());
		
		BancoDTO banco = BancoDTO.builder().build();
		
		banco.setCodigoBanco(b.getCodigoBanco());
		banco.setDescricaoBanco(b.getDescricaoBanco());
		banco.setDescricaoSigla(b.getDescricaoSigla());

		return banco;
	}
	
	public BancoDTO pesquisarBancoDescricao(String descricao) throws Exception {

		Optional<Banco> optional = repository.findByDescricaoBanco(descricao);
		
		Banco b = optional.orElseThrow(() -> new Exception());
		
		BancoDTO banco = BancoDTO.builder().build();
		
		banco.setCodigoBanco(b.getCodigoBanco());
		banco.setDescricaoBanco(b.getDescricaoBanco());
		banco.setDescricaoSigla(b.getDescricaoSigla());

		return banco;
	}

	public List<AgenciaDTO> pesquisarListaAgencia(Long codigoBanco) throws Exception {
		
		Optional<Banco> optional = repository.findById(codigoBanco);
		
		Banco b = optional.orElseThrow(() -> new Exception());
		
		List<Agencia> listagencia = b.getAgencias();
		List<AgenciaDTO> listaDTO = new ArrayList<>();
		
		listagencia.stream().forEach(agencia -> {
			listaDTO.add(AgenciaDTO.builder().
						codigoAgencia(agencia.getIdAgencia().getCodigoAgencia()).
						descricaoAgencia(agencia.getDescricaoAgencia()).build());
		});
		
		return listaDTO;
	}

	public List<BancoDTO> listarBancos() throws Exception {
		List<Banco> listaBanco = repository.findAll();
		List<BancoDTO> listaDTO = new ArrayList<>();
		listaBanco.stream().forEach(banco -> {
			listaDTO.add(
			BancoDTO.builder().codigoBanco(banco.getCodigoBanco()).descricaoBanco(banco.getDescricaoBanco()).descricaoSigla(banco.getDescricaoSigla()).build());
		});

		return listaDTO;
	}


	public BancoDTO salvarBanco(BancoDTO banco) throws Exception {
		Banco obj = Banco.builder().codigoBanco(banco.getCodigoBanco()).dataLastrec(Timestamp.valueOf(LocalDateTime.now())).codigoUsuario("POC").descricaoBanco(banco.getDescricaoBanco())
						 .descricaoSigla(banco.getDescricaoSigla()).build();
		repository.save(obj);
		return banco;
	}



}
