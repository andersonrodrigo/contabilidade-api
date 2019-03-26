package br.com.memory.contabilidade.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgenciaDTO {
	private Long codigoAgencia;
	private String numeroDigitoAgencia;
	private String descricaoAgencia;
	private String descricaoEndereco;
	private String descricaoBairro;
	private String descricaoCidade;
	private String descricaoUF;
	private String numeroCEP;
	private String numeroTelefone;
	private String descricaoEmail;
	private Timestamp dataLastrec;
	private String codigoUsuario;
	private BancoDTO banco; // @RELACIONAMENTO:BANCO
}
