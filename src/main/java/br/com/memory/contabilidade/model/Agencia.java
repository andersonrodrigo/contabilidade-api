package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.AgenciaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "AGENCIA")
@Entity
public class Agencia {
	@EmbeddedId
	private AgenciaId idAgencia;

	@Column(name = "NRO_DIGTOAGENCIA")
	private String numeroDigitoAgencia;

	@Column(name = "DES_AGENCIA")
	private String descricaoAgencia;

	@Column(name = "DES_ENDERECO")
	private String descricaoEndereco;

	@Column(name = "DES_BAIRRO")
	private String descricaoBairro;

	@Column(name = "DES_CIDADE")
	private String descricaoCidade;

	@Column(name = "DES_UF")
	private String descricaoUF;

	@Column(name = "NRO_CEP")
	private String numeroCEP;

	@Column(name = "NRO_TELEFONE")
	private String numeroTelefone;

	@Column(name = "DES_EMAIL")
	private String descricaoEmail;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;
	
	/*
	@OneToMany(mappedBy = "agencia", fetch=FetchType.LAZY)
	private List<ContaCorrente> contaCorrentes;
	*/
}

