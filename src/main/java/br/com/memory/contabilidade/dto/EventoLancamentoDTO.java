package br.com.memory.contabilidade.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventoLancamentoDTO {
	private Long codigoGrupoEvento;
	private Long codigoSubGrupoEvento;
	private Long codigoEvento;
	private String codigoCtcontabdeb;
	private String codigoCtcontabcred;
	private String historicoEvento;
	BigDecimal valorLancamento;
	Timestamp dataLancamento;
}

