package br.com.memory.contabilidade.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.memory.contabilidade.dto.AgenciaDTO;
import br.com.memory.contabilidade.dto.BancoDTO;
import br.com.memory.contabilidade.dto.EmpenhoDTO;
import br.com.memory.contabilidade.service.AgenciaService;
import br.com.memory.contabilidade.service.BancoService;
import br.com.memory.contabilidade.service.EmpenhoService;

@RestController
public class ContabilidadeController {

	@Autowired
	private BancoService bancoService;

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private EmpenhoService empenhoService;

	@PostMapping(value = "/salvarempenho")
	    public ResponseEntity<EmpenhoDTO> salvar(@RequestBody EmpenhoDTO empenho) {
	        EmpenhoDTO empenhoDTO = empenhoService.salvarEmpenho(empenho);
	        return new ResponseEntity<>(empenhoDTO, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/excluirempenho")
    public ResponseEntity<HttpStatus> excluir(@RequestParam(name = "codigoEntidade", required = true) Long codigoEntidade, 
								  @RequestParam(name = "serieEmpenho", required = true) Long serieEmpenho,
								  @RequestParam(name = "numeroEmpenho", required = true) Long numeroEmpenho) throws Exception {
        empenhoService.excluirEmpenho(codigoEntidade, serieEmpenho, numeroEmpenho);
        return new ResponseEntity<>(HttpStatus.OK);
}

	@RequestMapping(value = "/teste", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String helloWorld()
	{
		return "{\"hello\" : \"world\"}";
	}

	@RequestMapping(value = "/bancocodigo", method=RequestMethod.GET)
	public BancoDTO buscaBanco(@RequestParam(name = "banco", required = true) Long codigoBanco) throws Exception 
	{		
		BancoDTO banco = null;
		banco = bancoService.pesquisarBanco(codigoBanco);
		return banco;
	}

	@RequestMapping(value = "/bancolistagencia", method=RequestMethod.GET)
	public List<AgenciaDTO> buscalistaAgencia(@RequestParam(name = "banco", required = true) Long codigoBanco) throws Exception 
	{		
		List <AgenciaDTO> listaAgencia = bancoService.pesquisarListaAgencia(codigoBanco);
		return listaAgencia ;
	}

	@RequestMapping(value = "/bancodescricao", method=RequestMethod.GET)
	public ResponseEntity<BancoDTO> buscarBancoDescricao(@RequestParam(name = "descricaobanco", required = true) String descricaoBanco) throws Exception {
		BancoDTO banco = null;
		banco = bancoService.pesquisarBancoDescricao(descricaoBanco);

        return new ResponseEntity<BancoDTO>(banco, HttpStatus.OK);
    }

	@RequestMapping(value = "/agencia", method=RequestMethod.GET)
	public ResponseEntity<AgenciaDTO> buscarAgencia(@RequestParam(name = "codigoBanco", required = true) Long codigoBanco, 
													@RequestParam(name = "codigoAgencia", required = true) Long codigoAgencia) throws Exception {

		AgenciaDTO agencia = null;
		agencia = agenciaService.pesquisarAgencia(codigoBanco, codigoAgencia);

        return new ResponseEntity<AgenciaDTO>(agencia, HttpStatus.OK);
    }

	@RequestMapping(value = "/empenho", method=RequestMethod.GET)
	public ResponseEntity<EmpenhoDTO> buscarEmpenho(@RequestParam(name = "codigoEntidade", required = true) Long codigoEntidade, 
													@RequestParam(name = "serieEmpenho", required = true) Long serieEmpenho,
													@RequestParam(name = "numeroEmpenho", required = true) Long numeroEmpenho) throws Exception {

		EmpenhoDTO empenhoDTO = null;
		empenhoDTO = empenhoService.pesquisaEmpenho(codigoEntidade, serieEmpenho, numeroEmpenho);

        return new ResponseEntity<EmpenhoDTO>(empenhoDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/empenhocontabilizacao", method=RequestMethod.GET)
	public ResponseEntity<EmpenhoDTO> buscarEmpenhoContabilizacao(@RequestParam(name = "codigoEntidade", required = true) Long codigoEntidade, 
													@RequestParam(name = "serieEmpenho", required = true) Long serieEmpenho,
													@RequestParam(name = "numeroEmpenho", required = true) Long numeroEmpenho) throws Exception {

		EmpenhoDTO empenhoDTO = null;
		empenhoDTO = empenhoService.pesquisaEmpenhoContabilizacao(codigoEntidade, serieEmpenho, numeroEmpenho);

        return new ResponseEntity<EmpenhoDTO>(empenhoDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/listarempenho", method=RequestMethod.GET)
	public List<EmpenhoDTO> buscarListaEmpenho(@RequestParam(name = "codigoEntidade", required = true) Long codigoEntidade, 
														 @RequestParam(name = "serieEmpenho", required = true) Long serieEmpenho) throws Exception {

		List<EmpenhoDTO> empenho = null;
		empenho = empenhoService.pesquisaListaEmpenho(codigoEntidade, serieEmpenho);

        return empenho;
    }

	@RequestMapping(value = "/listarbancos", method=RequestMethod.GET)
	public ResponseEntity<List<BancoDTO>> listarBancos() throws Exception
	{
		return new ResponseEntity<List<BancoDTO>>(bancoService.listarBancos(), HttpStatus.OK);
	}


	@PostMapping(value = "/salvarbanco")
	public ResponseEntity<BancoDTO> salvarBanco(@RequestBody BancoDTO banco) throws Exception{
		BancoDTO bancoDTO = bancoService.salvarBanco(banco);
		return new ResponseEntity<>(bancoDTO, HttpStatus.CREATED);
	}

}


