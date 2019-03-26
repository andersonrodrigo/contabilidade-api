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
@Table(name = "PCA_GRUPOS")
@Entity
public class GrupoPCASP {
	@Id
	@Column(name = "ID_GRUPO")
	private Long idGrupo;

	@Column(name = "COD_GRUPO")
	private Long codigoGrupo;

	@Column(name = "DES_GRUPO")
	private String descricaoGrupo;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "grupoPCASP", fetch=FetchType.LAZY)
	private List<Identificadores> identificadoress;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SISTEMACONTABIL", referencedColumnName = "ID_SISTEMACONTABIL")
	private SistemaContabilPCASP sistemaContabilPCASP; // @RELACIONAMENTO:PCA_SISTEMASCONTABEIS

}

