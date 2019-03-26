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
@Table(name = "UNIDADESICOM")
@Entity
public class UnidadeSICOM {
	@Id
	@Column(name = "ID_UNIDADESICOM")
	private Long idUnidadesicom;

	@Column(name = "NRO_ANOFISCAL")
	private Long numeroAnofiscal;

	@Column(name = "COD_UNIDADESICOM")
	private Long codigoUnidadesicom;

	@Column(name = "DES_UNIDADESICOM")
	private String descricaoUnidadesicom;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "unidadeSICOM", fetch=FetchType.LAZY)
	private List<UnidadeOrcamentaria> unidadeOrcamentarias;

}

