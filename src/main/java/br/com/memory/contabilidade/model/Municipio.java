package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MUNICIPIO")
@Entity
public class Municipio {
	@Id
	@Column(name = "COD_MUNICIPIO")
	private Long codigoMunicipio;

	@Column(name = "DES_MUNICIPIO")
	private String descricaoMunicipio;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "COD_MUNICIPIOSICOM")
	private Long codigoMunicipioSicom;

	@Column(name = "NRO_SIAFI")
	private Long numeroSiafi;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_UF", referencedColumnName = "COD_UF")
	private UnidadeFederacao unidadeFederacao; // @RELACIONAMENTO:UF

	/*
	@OneToMany(mappedBy = "CONSORCIOCONSORCIADO", fetch=FetchType.LAZY)
	private List<CONSORCIOCONSORCIADO> CONSORCIOCONSORCIADOs;

	@OneToMany(mappedBy = "municipio", fetch=FetchType.LAZY)
	private List<Entidade> entidades;

	@OneToMany(mappedBy = "municipio", fetch=FetchType.LAZY)
	private List<Responsavel> responsavels;
	*/
}

