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
@Table(name = "BANCO")
@Entity
public class Banco {
	@Id
	@Column(name = "COD_BANCO")
	private Long codigoBanco;

	@Column(name = "DES_BANCO")
	private String descricaoBanco;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DES_SIGLA")
	private String descricaoSigla;

	@OneToMany(mappedBy = "idAgencia.banco", fetch=FetchType.LAZY)
	private List<Agencia> agencias;
}

