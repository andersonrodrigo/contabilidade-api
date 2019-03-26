package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PCA_SITUACAOCONSORCIOS")
@Entity
public class SituacaoConsorcio {
	@Id
	@Column(name = "ID_SITUACAOCONSORCIO")
	private Long idSituacaoconsorcio;

	@Column(name = "COD_SITUACAOCONSORCIO")
	private Long codigoSituacaoconsorcio;

	@Column(name = "DES_SITUACAOCONSORCIO")
	private String descricaoSituacaoconsorcio;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "DAT_DESATIVACAO")
	private Timestamp dataDesativacao;

	@OneToMany(mappedBy = "situacaoConsorcio", fetch=FetchType.LAZY)
	private List<Entidade> listaEntidade;

	@OneToMany(mappedBy = "situacaoConsorcio", fetch=FetchType.LAZY)
	private List<Consorcio> listaConsorcio;

}
