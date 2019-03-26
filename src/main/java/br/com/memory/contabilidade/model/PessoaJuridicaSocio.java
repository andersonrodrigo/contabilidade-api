package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.PessoaJuridicaSocioId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PJSOCIO")
@Entity
public class PessoaJuridicaSocio {
	@EmbeddedId
	private PessoaJuridicaSocioId idPessoaJuridicaSocio;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_INICIO")
	private Timestamp dataInicio;

	@Column(name = "DAT_FIM")
	private Timestamp dataFim;

	@Column(name = "IDT_TIPOPARTICIPACAO")
	private String idtTipoparticipacao;

}
