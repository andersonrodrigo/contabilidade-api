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
@Table(name = "PCA_VERSAO")
@Entity
public class VersaoPCASP {
	@Id
	@Column(name = "ID_VERSAO")
	private Long idVersao;

	@Column(name = "COD_VERSAO")
	private Long codigoVersao;

	@Column(name = "DES_VERSAO")
	private String descricaoVersao;

	@Column(name = "IDT_MASCARA")
	private String idtMascara;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "DAT_INICIO")
	private Timestamp dataInicio;

	@Column(name = "DAT_FIM")
	private Timestamp dataFim;

	@OneToMany(mappedBy = "versaoPCASP", fetch=FetchType.LAZY)
	private List<AnoFiscal> anoFiscals;

	/*
	@OneToMany(mappedBy = "PCA_PLANOCONTAS", fetch=FetchType.LAZY)
	private List<PCA_PLANOCONTAS> PCA_PLANOCONTASs;

	@OneToMany(mappedBy = "VersaoPca", fetch=FetchType.LAZY)
	private List<TVWModulosDTO> tVWModulosDTOs;
	*/

}
