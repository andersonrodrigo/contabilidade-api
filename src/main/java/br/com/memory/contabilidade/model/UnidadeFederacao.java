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
@Table(name = "UF")
@Entity
public class UnidadeFederacao {
	@Id
	@Column(name = "COD_UF")
	private String codigoUf;

	@Column(name = "DES_UF")
	private String descricaoUf;

	@Column(name = "COD_IBGE")
	private Long codigoIbge;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "unidadeFederacao", fetch=FetchType.LAZY)
	private List<Municipio> municipios;

	/*
	@OneToMany(mappedBy = "MUNICIPIOFOLHA", fetch=FetchType.LAZY)
	private List<MUNICIPIOFOLHA> MUNICIPIOFOLHAs;

	@OneToMany(mappedBy = "uf", fetch=FetchType.LAZY)
	private List<PessoaFisica> pessoaFisicas;
	*/

}

