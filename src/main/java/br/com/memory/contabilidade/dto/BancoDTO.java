package br.com.memory.contabilidade.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BancoDTO {
	private Long codigoBanco;
	private String descricaoBanco;
	private Timestamp dataLastrec;
	private String codigoUsuario;
	private String descricaoSigla;
}
