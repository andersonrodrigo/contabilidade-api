package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PCA_IDENTIFICADORES")
@Entity
public class Identificadores {
	@Id
	@Column(name = "ID_IDENTIFICADOR")
	private Long idIdentificador;

	@Column(name = "COD_IDENTIFICADOR")
	private Long codigoIdentificador;

	@Column(name = "DES_IDENTIFICADOR")
	private String descricaoIdentificador;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "Identificadores", fetch=FetchType.LAZY)
	private List<PlanoContasPCASP> planoContasPCASPs;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_GRUPO")
	private GrupoPCASP grupoPCASP; // @RELACIONAMENTO:PCA_GRUPOS

}

