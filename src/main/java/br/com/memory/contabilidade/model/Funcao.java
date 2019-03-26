package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.FuncaoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "FUNCAO")
@Entity
public class Funcao {
	@EmbeddedId
	private FuncaoId idFuncao;

	@Column(name = "DES_FUNCAO")
	private String descricaoFuncao;

	@Column(name = "FGL_SAUDE")
	private String flagSaude;

	@Column(name = "FGL_EDUCACAO")
	private String flagEducacao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DES_ABREVIADA")
	private String descricaoAbreviada;

	@Column(name = "FGL_ASSISTENCIASOCIAL")
	private String flagAssistenciasocial;

	@OneToMany(mappedBy = "idFuncionalProgramatica.funcao", fetch=FetchType.LAZY)
	private List<FuncionalProgramatica> funcionalProgramaticas;

	/*
	@OneToMany(mappedBy = "PPAACAO", fetch=FetchType.LAZY)
	private List<PPAACAO> PPAACAOs;
	*/

}

