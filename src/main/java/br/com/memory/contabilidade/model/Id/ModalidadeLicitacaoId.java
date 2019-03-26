package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.GrupoEntidadeCompras;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ModalidadeLicitacaoId implements Serializable {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_GRUPOENTIDADE", referencedColumnName = "COD_GRUPOENTIDADE")
	private GrupoEntidadeCompras grupoEntidadeCompras; // @RELACIONAMENTO:GRUPOENTIDADE

	@Column(name = "COD_MODALIDADELICITACAO")
	private Long codigoModalidadelicitacao;

}
