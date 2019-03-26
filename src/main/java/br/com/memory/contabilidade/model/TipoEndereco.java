package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TIPOENDERECO")
@Entity
public class TipoEndereco {
	@Id
	@Column(name = "COD_TIPOENDERECO")
	private Long codigoTipoendereco;

	@Column(name = "DES_TIPOENDERECO")
	private String descricaoTipoendereco;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;
}

