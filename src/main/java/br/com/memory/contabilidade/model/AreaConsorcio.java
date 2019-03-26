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
@Table(name = "PCA_AREASCONSORCIOS")
@Entity
public class AreaConsorcio {
	@Id
	@Column(name = "ID_AREASCONSORCIOPUBLICO")
	private Long idAreasconsorcio;

	@Column(name = "COD_AREASCONSORCIO")
	private Long codigoAreasconsorcio;

	@Column(name = "DES_AREASCONSORCIO")
	private String descricaoAreasconsorcio;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "areaConsorcio", fetch=FetchType.LAZY)
	private List<Consorcio> listaConsorcio;

	@OneToMany(mappedBy = "areaConsorcio", fetch=FetchType.LAZY)
	private List<Entidade> listaEntidade;
}

