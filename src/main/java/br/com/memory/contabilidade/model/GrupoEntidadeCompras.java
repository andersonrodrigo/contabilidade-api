package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "GRUPOENTIDADE")
@Entity
public class GrupoEntidadeCompras {
	@Id
	@Column(name = "COD_GRUPOENTIDADE")
	private Long codigoGrupoentidade;

	@Column(name = "ANO_GRUPO")
	private Long anoGrupo;

	@Column(name = "NRO_PROCESSO")
	private Long numeroProcesso;

	@Column(name = "NRO_NAF")
	private Long numeroNaf;

	@Column(name = "NRO_REQUISICAO")
	private Long numeroRequisicao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	/*
	@OneToMany(mappedBy = "idModalidadeLicitacao.grupoEntidadeCompras", 
			   cascade={CascadeType.PERSIST, CascadeType.MERGE },
			   fetch=FetchType.LAZY)
	*/
	@OneToMany(mappedBy = "idModalidadeLicitacao.grupoEntidadeCompras", fetch=FetchType.LAZY)
	private List<ModalidadeLicitacao> listaModalidadeLicitacao;

	/*
	@OneToMany(mappedBy = "ENTIDADEGRUPOENTIDADE", fetch=FetchType.LAZY)
	private List<ENTIDADEGRUPOENTIDADE> listaENTIDADEGRUPOENTIDADE;

	@OneToMany(mappedBy = "NAF", fetch=FetchType.LAZY)
	private List<NAF> listaNAF;

	@OneToMany(mappedBy = "PROCESSO", fetch=FetchType.LAZY)
	private List<PROCESSO> listaPROCESSO;

	@OneToMany(mappedBy = "REQUISICAOCOMPRA", fetch=FetchType.LAZY)
	private List<REQUISICAOCOMPRA> listaREQUISICAOCOMPRA;
	*/
}

