package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.ProjetoAtividadeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROJETOATIVIDADE")
@Entity
public class ProjetoAtividade {
	@EmbeddedId
	private ProjetoAtividadeId idProjetoAtividade;

	@Column(name = "DES_PROJETOATIVIDADE")
	private String descricaoProjetoatividade;

	@Column(name = "DES_INTEGRA")
	private String descricaoIntegra;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "DES_UNIDADE")
	private String descricaoUnidade;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "idFuncionalProgramatica.projetoAtividade", fetch=FetchType.LAZY)
	private List<FuncionalProgramatica> funcionalProgramaticas;

}

