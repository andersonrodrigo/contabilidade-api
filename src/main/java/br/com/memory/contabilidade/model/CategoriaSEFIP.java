package br.com.memory.contabilidade.model;
import java.sql.Timestamp;
import java.util.Currency;
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
@Table(name = "CATEGORIASEFIP")
@Entity
public class CategoriaSEFIP {
	@Id
	@Column(name = "COD_CATSEFIP")
	private Long codigoCatsefip;

	@Column(name = "DES_CATSEFIP")
	private String descricaoCatsefip;

	@Column(name = "PER_BASEINSS")
	private Currency percentualBaseinss;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FGL_AUTONOMO")
	private String flagAutonomo;

	@OneToMany(mappedBy = "categoriaSEFIP", fetch=FetchType.LAZY)
	private List<PessoaFisica> pessoaFisicas;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CBO", referencedColumnName = "COD_CBO")
	private CBO CBO; // @RELACIONAMENTO:CBO

}

