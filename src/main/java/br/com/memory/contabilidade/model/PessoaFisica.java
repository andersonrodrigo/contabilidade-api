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
@Table(name = "PESSOAFISICA")
@Entity
public class PessoaFisica {
	@Id
	@Column(name = "NRO_CPF")
	private String numeroCpf;

	@Column(name = "DES_TIPO")
	private String descricaoTipo;

	@Column(name = "NRO_CI")
	private String numeroCi;

	@Column(name = "DES_ORGAOEXPEDIDOR")
	private String descricaoOrgaoExpedidor;

	@Column(name = "DAT_EXPEDICAO")
	private Timestamp dataExpedicao;

	@Column(name = "DES_UF_IDENTIDADE")
	private String descricaoUfIdentidade;

	@Column(name = "NRO_PIS")
	private String numeroPis;

	@Column(name = "NRO_REGCONSELHO")
	private String numeroRegConselho;

	@Column(name = "DES_OBS")
	private String descricaoObs;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastRec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "NRO_DEPENDENTES")
	private Long numeroDependentes;

	@Column(name = "NRO_NIT")
	private String numeroNit;

	@Column(name = "DAT_NASCIMENTO")
	private Timestamp dataNascimento;

	@Column(name = "NOM_PAI")
	private String nomeDoPai;

	@Column(name = "NOM_MAE")
	private String nomeDaMae;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_CATSEFIP", referencedColumnName = "COD_CATSEFIP")
	private CategoriaSEFIP categoriaSEFIP; // @RELACIONAMENTO:CATEGORIASEFIP

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_UF", referencedColumnName = "COD_UF")
	private UnidadeFederacao unidadeFederacao; // @RELACIONAMENTO:UF

}

