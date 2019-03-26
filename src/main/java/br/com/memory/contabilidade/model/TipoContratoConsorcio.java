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
@Table(name = "PCA_TPCONTRATOCONSORCIOS")
@Entity
public class TipoContratoConsorcio {
	@Id
	@Column(name = "ID_TPCONTRATOCONSORCIO")
	private Long idTpcontratoconsorcio;

	@Column(name = "COD_TPCONTRATOCONSORCIO")
	private Long codigoTpcontratoconsorcio;

	@Column(name = "DES_TPCONTRATOCONSORCIO")
	private String descricaoTpcontratoconsorcio;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "tipoContratoConsorcio", fetch=FetchType.LAZY)
	private List<Consorcio> listaConsorcio;
}
