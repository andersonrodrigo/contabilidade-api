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
@Table(name = "NATUREZAJURIDICAESOCIAL")
@Entity
public class NaturezaJuridicaESocial {
	@Id
	@Column(name = "ID_NATUREZAJURIDICAESOCIAL")
	private Long identificacaoNaturezaJurESocial;

	@Column(name = "COD_NATUREZAJURIDICA")
	private Long codigoNaturezaJurESocial;

	@Column(name = "DES_NATUREZAJURIDICA")
	private String descricaoidNaturezaJurESocial;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataUltimaGravacao;

	@OneToMany(mappedBy = "naturezaJuridicaESocial", fetch=FetchType.LAZY)
	private List<PessoaJuridica> pessoaJuridicas;

}

