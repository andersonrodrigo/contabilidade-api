package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.CadastroUnico;
import br.com.memory.contabilidade.model.PessoaJuridica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaJuridicaSocioId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC")
	private CadastroUnico cadastroUnico; // @RELACIONAMENTO:CUC

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CGC", referencedColumnName = "NRO_CGC")
	private PessoaJuridica pessoaJuridica; // @RELACIONAMENTO:PESSOAJURIDICA
}