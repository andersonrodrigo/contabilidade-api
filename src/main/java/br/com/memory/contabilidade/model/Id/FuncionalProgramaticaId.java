package br.com.memory.contabilidade.model.Id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.com.memory.contabilidade.model.AnoFiscal;
import br.com.memory.contabilidade.model.Funcao;
import br.com.memory.contabilidade.model.Programa;
import br.com.memory.contabilidade.model.ProjetoAtividade;
import br.com.memory.contabilidade.model.SubFuncao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionalProgramaticaId implements Serializable {
	//@Column(name = "NRO_ANOFISCAL")
	//private Long numeroAnoFiscal; // @RELACIONAMENTO:ANOFISCAL

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NRO_ANOFISCAL", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false)
	private AnoFiscal anofiscal; // @RELACIONAMENTO:ANOFISCAL
	
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_FUNCAO", referencedColumnName = "COD_FUNCAO")
	private Funcao funcao; // @RELACIONAMENTO:FUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_SUBFUNCAO", referencedColumnName = "COD_SUBFUNCAO")
	private SubFuncao subFuncao; // @RELACIONAMENTO:SUBFUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA")
	private Programa programa; // @RELACIONAMENTO:PROGRAMA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COD_PROJETOATIVIDADE", referencedColumnName = "COD_PROJETOATIVIDADE")
	private ProjetoAtividade projetoAtividade; // @RELACIONAMENTO:PROJETOATIVIDADE
	*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name =  "NRO_ANOFISCAL_1", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_FUNCAO", referencedColumnName = "COD_FUNCAO", insertable=false, updatable=false)
	})
	private Funcao funcao; // @RELACIONAMENTO:FUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL_2", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_SUBFUNCAO", referencedColumnName = "COD_SUBFUNCAO", insertable=false, updatable=false)
	})
	private SubFuncao subFuncao; // @RELACIONAMENTO:SUBFUNCAO

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL_3", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable=false, updatable=false)
	})
	private Programa programa; // @RELACIONAMENTO:PROGRAMA

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "NRO_ANOFISCAL_4", referencedColumnName = "NRO_ANOFISCAL", insertable=false, updatable=false), 
		@JoinColumn(name = "COD_PROJETOATIVIDADE", referencedColumnName = "COD_PROJETOATIVIDADE", insertable=false, updatable=false)
	})
	private ProjetoAtividade projetoAtividade; // @RELACIONAMENTO:PROJETOATIVIDADE
}
