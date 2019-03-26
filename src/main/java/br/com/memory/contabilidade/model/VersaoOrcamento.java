package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.VersaoOrcamentoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "VERSAOORCAMENTO")
@Entity
public class VersaoOrcamento {
	@EmbeddedId
	private VersaoOrcamentoId idVersaoOrcamento;

	@Column(name = "DES_MENSAGEM")
	private String descricaoMensagem;

	@Column(name = "IDT_STATUS")
	private String idtStatus;

	@Column(name = "DAT_ENVIO")
	private Timestamp dataEnvio;

	@Column(name = "DAT_APROVACAO")
	private Timestamp dataAprovacao;

	@Column(name = "DAT_REJEICAO")
	private Timestamp dataRejeicao;

	@Column(name = "DAT_VIGENCIA")
	private Timestamp dataVigencia;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "NRO_LEIORCAMENTO")
	private Long numeroLeiorcamento;

	@Column(name = "NRO_ANOLEI")
	private Long numeroAnolei;

	@Column(name = "NRO_LEILDO")
	private Long numeroLeildo;

	@Column(name = "NRO_ANOLEILDO")
	private Long numeroAnoleildo;

	@Column(name = "IDT_TIPOLEI")
	private String idtTipolei;

	@OneToMany(mappedBy = "versaoOrcamento", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;

	/*
	@OneToMany(mappedBy = "VERSAOORCAMENTO", fetch=FetchType.LAZY)
	private List<OrcamentoReceita> orcamentoReceitas;
	*/
}

