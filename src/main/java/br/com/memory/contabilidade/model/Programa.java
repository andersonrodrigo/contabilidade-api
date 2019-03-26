package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.ProgramaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROGRAMA")
@Entity
public class Programa {
	@EmbeddedId
	private ProgramaId idPrograma;

	@Column(name = "DES_PROGRAMA")
	private String descricaoPrograma;

	@Column(name = "DES_INTEGRA")
	private String descricaoIntegra;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "FGL_PPA")
	private String flagPpa;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "idFuncionalProgramatica.programa", fetch=FetchType.LAZY)
	private List<FuncionalProgramatica> funcionalProgramaticas;

}

