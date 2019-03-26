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
@Table(name = "PCA_ENCERRAMENTOCONSORCIOS")
@Entity
public class EncerramentoConsorcio {
	@Id
	@Column(name = "ID_ENCERRAMENTOCONSORCIO")
	private Long idEncerramentoconsorcio;

	@Column(name = "COD_ENCERRAMENTOCONSORCIO")
	private Long codigoEncerramentoconsorcio;

	@Column(name = "DES_ENCERRAMENTOCONSORCIO")
	private String descricaoEncerramentoconsorcio;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "encerramentoConsorcio", fetch=FetchType.LAZY)
	private List<Entidade> listaEntidade;

	@OneToMany(mappedBy = "encerramentoConsorcio", fetch=FetchType.LAZY)
	private List<Consorcio> listaConsorcio;

}

