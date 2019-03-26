package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.EventoLancamentoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "EVENTOLANCAMENTO")
@Entity
public class EventoLancamento {
	@EmbeddedId
	private EventoLancamentoId idEventoLancamento;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CTCONTABDEB", referencedColumnName = "COD_CTCONTAB")
	private PlanoContasMemory contaContabilDebito; // @RELACIONAMENTO:CTCONTAB

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CTCONTABCRED", referencedColumnName = "COD_CTCONTAB")
	private PlanoContasMemory contaContabilCredito; // @RELACIONAMENTO:CTCONTAB
}

