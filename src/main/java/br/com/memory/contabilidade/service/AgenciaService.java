package br.com.memory.contabilidade.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memory.contabilidade.dto.AgenciaDTO;
import br.com.memory.contabilidade.dto.BancoDTO;
import br.com.memory.contabilidade.model.Agencia;
import br.com.memory.contabilidade.model.Banco;
import br.com.memory.contabilidade.model.Id.AgenciaId;
import br.com.memory.contabilidade.repository.AgenciaRepository;
import br.com.memory.contabilidade.repository.BancoRepository;

@Service
public class AgenciaService {
	@Autowired
	private AgenciaRepository agenciarepository;
	
	@Autowired
	private BancoRepository bancorepository;

	public AgenciaDTO pesquisarAgencia(Long codigoBanco, Long codigoAgencia) throws Exception {

		Optional<Banco> optionalbanco = bancorepository.findById(codigoBanco);

		AgenciaId agenciaId = AgenciaId.builder().banco(optionalbanco.get()).
												  codigoAgencia(codigoAgencia).build(); 

		Optional<Agencia> optionalagencia = agenciarepository.findById(agenciaId);
		
		Agencia a = optionalagencia.orElseThrow(() -> new Exception());
		
		AgenciaDTO agencia = AgenciaDTO.builder().
									codigoAgencia(a.getIdAgencia().getCodigoAgencia()).
									descricaoAgencia(a.getDescricaoAgencia()).
									descricaoEndereco(a.getDescricaoEndereco()).
									banco(BancoDTO.builder().
											descricaoBanco(a.getIdAgencia().getBanco().getDescricaoBanco()).build()).
									build();
		/*
		agencia.setBanco(a.getId().getCodigoAgencia());
		agencia.setBanco(a.getId().getCodigoAgencia());
		banco.setDescricaoBanco(b.getDescricaoBanco());
		banco.setDescricaoSigla(b.getDescricaoSigla());
		*/

		return agencia;
	}
	
	
}
