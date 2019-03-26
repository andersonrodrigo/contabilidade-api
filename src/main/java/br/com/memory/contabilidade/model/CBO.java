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
@Table(name = "CBO")
@Entity
public class CBO {
	@Id
	@Column(name = "COD_CBO")
	private Long codigoCbo;

	@Column(name = "DES_CBO")
	private String descricaoCbo;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "FLG_IMPORTADO")
	private String flagImportado;

	@OneToMany(mappedBy = "CBO", fetch=FetchType.LAZY)
	private List<CategoriaSEFIP> categoriaSEFIPs;

	/*
	@OneToMany(mappedBy = "CBODTO", fetch=FetchType.LAZY)
	private List<TFuncaoFolhaCargo> tFuncaoFolhaCargos;
	*/
}

