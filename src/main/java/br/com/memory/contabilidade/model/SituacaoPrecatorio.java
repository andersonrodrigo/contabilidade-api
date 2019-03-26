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
@Table(name = "PCA_SITUACAOPRECATORIO")
@Entity
public class SituacaoPrecatorio {
	@Id
	@Column(name = "ID_SITUACAOPRECATORIO")
	private Long idSituacaoprecatorio;

	@Column(name = "COD_SITUACAOPRECATORIO")
	private Long codigoSituacaoprecatorio;

	@Column(name = "DES_SITUACAOPRECATORIO")
	private String descricaoSituacaoprecatorio;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "situacaPrecatorio", fetch=FetchType.LAZY)
	private List<Precatorio> listaPrecatorio;

}

