package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
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
@Table(name = "PESSOAJURIDICA")
@Entity
public class PessoaJuridica {
	@Id
	@Column(name = "NRO_CGC")
	private String numeroCgc;

	@Column(name = "DES_RAZAOSOCIAL")
	private String descricaoRazaoSocial;

	@Column(name = "NRO_INSCESTADUAL")
	private String numeroInscricaoEstadual;

	@Column(name = "FGL_MICROEMPRESA")
	private String flagMicroEmpresa;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "IDT_CLASSIFICACAOTRIBUTARIA")
	private String idtClassificacaoTributaria;

	@OneToMany(mappedBy = "pessoaJuridica", fetch=FetchType.LAZY)
	private List<CadastroUnico> cadastroUnicos;

	@OneToMany(mappedBy = "idPessoaJuridicaSocio.pessoaJuridica", fetch=FetchType.LAZY)
	private List<PessoaJuridicaSocio> pessoaJuridicaSocio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_NATUREZAJURIDICAESOCIAL", referencedColumnName = "ID_NATUREZAJURIDICAESOCIAL")
	private NaturezaJuridicaESocial naturezaJuridicaESocial; // @RELACIONAMENTO:NATUREZAJURIDICAESOCIAL

}

