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
@Table(name = "PCA_PRAZOS")
@Entity
public class PrazosPCASP {
	@Id
	@Column(name = "ID_PRAZO")
	private Long idPrazo;

	@Column(name = "COD_PRAZO")
	private Long codigoPrazo;

	@Column(name = "DES_PRAZO")
	private String descricaoPrazo;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@OneToMany(mappedBy = "prazosPCASP", fetch=FetchType.LAZY)
	private List<PlanoContasPCASP> planoContasPCASPs;

}

