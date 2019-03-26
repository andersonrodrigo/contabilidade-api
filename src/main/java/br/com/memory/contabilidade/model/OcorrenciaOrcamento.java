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
@Table(name = "OCORRENCIAORCAMENTO")
@Entity
public class OcorrenciaOrcamento {
	@Id
	@Column(name = "COD_OCORRENCIA")
	private Long codigoOcorrencia;

	@Column(name = "DES_CORRENCIA")
	private String descricaoCorrencia;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "ocorrenciaOrcamento", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;
}
