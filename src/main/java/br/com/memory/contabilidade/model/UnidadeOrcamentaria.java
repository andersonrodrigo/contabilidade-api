package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.UnidadeOrcamentariaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "UNIDADEORCAMENTO")
@Entity
public class UnidadeOrcamentaria {
	@EmbeddedId
	private UnidadeOrcamentariaId idUnidadeOrcamentaria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_UNIDORC", referencedColumnName = "COD_UNIDORC", insertable=false, updatable=false)
	})
	private UnidadeOrcamentaria unidadeOrcamentoSUP; // @RELACIONAMENTO:UNIDADEORCAMENTO

	@Column(name = "COD_UNIDORCSEMMASCARA")
	private String codigoUnidorcsemmascara;

	@Column(name = "DES_UNIDADEORC")
	private String descricaoUnidadeorc;

	@Column(name = "FGL_SINTETICA")
	private String flagSintetica;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "ID_ORGAOSICOM")
	private Long idOrgaosicom;

	@Column(name = "COD_UNIDORC_SICOM")
	private String codigoUnidorcsicom;

	@Column(name = "COD_UNIDORC_ORIG_RSP")
	private String codigoUnidorcorigrsp;

	@OneToMany(mappedBy = "unidadeOrcamentaria", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;

	/*
	@OneToMany(mappedBy = "ESTOQUEREQUISITANTEUO", fetch=FetchType.LAZY)
	private List<ESTOQUEREQUISITANTEUO> ESTOQUEREQUISITANTEUOs;

	@OneToMany(mappedBy = "ESTOQUERESERVA", fetch=FetchType.LAZY)
	private List<ESTOQUERESERVA> ESTOQUERESERVAs;

	@OneToMany(mappedBy = "FRT_EQUIPAMENTOORGAO", fetch=FetchType.LAZY)
	private List<FRT_EQUIPAMENTOORGAO> FRT_EQUIPAMENTOORGAOs;

	@OneToMany(mappedBy = "PPAACAO", fetch=FetchType.LAZY)
	private List<PPAACAO> PPAACAOs;

	@OneToMany(mappedBy = "RESPONSAVELORCAMENTO", fetch=FetchType.LAZY)
	private List<RESPONSAVELORCAMENTO> RESPONSAVELORCAMENTOs;
	*/

	@OneToMany(mappedBy = "unidadeOrcamentoSUP", fetch=FetchType.LAZY)
	private List<UnidadeOrcamentaria> unidadeOrcamentarias;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_ENTIDADE", referencedColumnName = "COD_ENTIDADE")
	private Entidade entidade; // @RELACIONAMENTO:ENTIDADE

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_UNIDADESICOM", referencedColumnName = "ID_UNIDADESICOM")
	private UnidadeSICOM unidadeSICOM; // @RELACIONAMENTO:UNIDADESICOM

}

