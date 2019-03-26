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
@Table(name = "ENDERECO")
@Entity
public class EnderecoCadastroUnico {
	@Id
	@Column(name = "SEQ_ENDERECO")
	private Long seq_Endereco;

	@Column(name = "DES_UF")
	private String descricaoUf;

	@Column(name = "DES_MUNICIPIO")
	private String descricaoMunicipio;

	@Column(name = "DES_LOGRADOURO")
	private String descricaoLogradouro;

	@Column(name = "NRO_ENDERECO")
	private String numeroEndereco;

	@Column(name = "DES_COMPLEMENTO")
	private String descricaoComplemento;

	@Column(name = "DES_BAIRRO")
	private String descricaoBairro;

	@Column(name = "NRO_CEP")
	private String numeroCep;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DES_PAIS")
	private String descricaoPais;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC")
	private CadastroUnico cadastroUnico; // @RELACIONAMENTO:CUC

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_TIPOENDERECO", referencedColumnName = "COD_TIPOENDERECO")
	private TipoEndereco tipoEndereco; // @RELACIONAMENTO:TIPOENDERECO

}
