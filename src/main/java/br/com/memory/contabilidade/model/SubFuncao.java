package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.SubFuncaoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SUBFUNCAO")
@Entity
public class SubFuncao {
	@EmbeddedId
	private SubFuncaoId idSubFuncao;

	@Column(name = "DES_SUBFUNCAO")
	private String descricaoSubfuncao;

	@Column(name = "FGL_SAUDE")
	private String flagSaude;

	@Column(name = "FGL_EDUCACAO")
	private String flagEducacao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "COD_FUNCAO")
	private String codigoFuncao;

	@OneToMany(mappedBy = "idFuncionalProgramatica.subFuncao", fetch=FetchType.LAZY)
	private List<FuncionalProgramatica> funcionalProgramaticas;

	/*
	@OneToMany(mappedBy = "subFuncao", fetch=FetchType.LAZY)
	private List<Siope> siopes;

	@OneToMany(mappedBy = "PPAACAO", fetch=FetchType.LAZY)
	private List<PPAACAO> PPAACAOs;
	*/

}

