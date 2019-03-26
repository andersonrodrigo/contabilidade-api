package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.FuncionalProgramaticaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "FUNCIONALPROGRAMATICA")
@Entity
public class FuncionalProgramatica {
	@EmbeddedId
	private FuncionalProgramaticaId idFuncionalProgramatica;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	//@OneToMany(mappedBy = "funcionalProgramatica", fetch=FetchType.LAZY)
	//private List<OrcamentoDespesa> orcamentoDespesas;
}
