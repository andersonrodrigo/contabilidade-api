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
@Table(name = "PCA_SISTEMASCONTABEIS")
@Entity
public class SistemaContabilPCASP {
	@Id
	@Column(name = "ID_SISTEMACONTABIL")
	private Long idSistemacontabil;

	@Column(name = "COD_SISTEMACONTABIL")
	private Long codigoSistemacontabil;

	@Column(name = "DES_SISTEMACONTABIL")
	private String descricaoSistemacontabil;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "sistemaContabilPCASP", fetch=FetchType.LAZY)
	private List<GrupoPCASP> grupoPCASPs;

}
