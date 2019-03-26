package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.memory.contabilidade.model.CadastroUnico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CredorId implements Serializable {
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_CUC", referencedColumnName = "NRO_CUC")
	private CadastroUnico cadastroUnico;

}
