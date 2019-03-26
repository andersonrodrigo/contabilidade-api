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
@Table(name = "PCA_NIVEISCONSOLIDACAO")
@Entity
public class NivelConsolidacao {
	@Id
	@Column(name = "ID_NIVELCONSOLIDACAO")
	private Long idNivelconsolidacao;

	@Column(name = "COD_NIVELCONSOLIDACAO")
	private Long codigoNivelconsolidacao;

	@Column(name = "DES_NIVELCONSOLIDACAO")
	private String descricaoNivelconsolidacao;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "NivelConsolidacao", fetch=FetchType.LAZY)
	private List<PlanoContasPCASP> planoContasPCASPs;
}
