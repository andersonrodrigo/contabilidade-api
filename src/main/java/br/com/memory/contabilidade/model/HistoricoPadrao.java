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
@Table(name = "HISTORICOPADRAO")
@Entity
public class HistoricoPadrao {
	@Id
	@Column(name = "COD_HISTORICO")
	private Long codigoHistorico;

	@Column(name = "DES_HISTORICO")
	private String descricaoHistorico;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "IDT_HISTORICO")
	private String idtHistorico;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "historicoPadrao", fetch=FetchType.LAZY)
	private List<Evento> listaEvento;

	/*
	@OneToMany(mappedBy = "historicoPadrao", fetch=FetchType.LAZY)
	private List<TabelaContabilFolha> listaTabelaContabilFolha;
	*/

}

