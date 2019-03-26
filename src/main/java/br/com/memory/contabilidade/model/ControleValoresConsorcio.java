
package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
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
@Table(name = "PCA_CONTROLEVALORES")
@Entity
public class ControleValoresConsorcio {
	@Id
	@Column(name = "ID_CONTROLEVALORES")
	private Long idControlevalores;

	@Column(name = "COD_FUNCAO")
	private String codigoFuncao;

	@Column(name = "COD_SUBFUNCAO")
	private String codigoSubfuncao;

	@Column(name = "COD_NATUREZADESPESA")
	private String codigoNaturezadespesa;

	@Column(name = "COD_DESDOBRAMENTO")
	private String codigoDesdobramento;

	@Column(name = "VLR_EMPENHADO")
	private BigDecimal valorEmpenhado;

	@Column(name = "VLR_ANULADO")
	private BigDecimal valorAnulado;

	@Column(name = "VLR_LIQUIDADO")
	private BigDecimal valorLiquidado;

	@Column(name = "VLR_LIQUIDADOANULADO")
	private BigDecimal valorLiquidadoanulado;

	@Column(name = "VLR_PAGO")
	private BigDecimal valorPago;

	@Column(name = "VLR_PAGOANULADO")
	private BigDecimal valorPagoanulado;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_FONTERECURSO")
	private Long codigoFonterecurso;

	@Column(name = "IDT_TIPO")
	private String idtTipo;

	@Column(name = "IDT_MODALIDADEENSINOINFANTIL")
	private String idtModalidadeensinoinfantil;

	@Column(name = "NRO_ANOFISCAL")
	private Long numeroAnofiscal;

	@Column(name = "VLR_EXECPROCCANCELADOCOMDISP")
	private BigDecimal valorExecproccanceladocomdisp;

	@Column(name = "VLR_EXECPROCCANCELADOSEMDISP")
	private BigDecimal valorExecproccanceladosemdisp;

	@Column(name = "VLR_EXECNAOPROCCANCELADOCOMDISP")
	private BigDecimal valorExecnaoproccanceladocomdis;

	@Column(name = "VLR_EXECNAOPROCCANCELADOSEMDISP")
	private BigDecimal valorExecnaoproccanceladosemdis;

	@Column(name = "VLR_EXECPROCPAGOCOMDISP")
	private BigDecimal valorExecprocpagocomdisp;

	@Column(name = "VLR_EXECPROCPAGOSEMDISP")
	private BigDecimal valorExecprocpagosemdisp;

	@Column(name = "VLR_EXECNAOPROCPAGOCOMDISP")
	private BigDecimal valorExecnaoprocpagocomdisp;

	@Column(name = "VLR_EXECNAOPROCPAGOSEMDISP")
	private BigDecimal valorExecnaoprocpagosemdisp;

	@Column(name = "VLR_DISPONIBILIDADECAIXA")
	private BigDecimal valorDisponibilidadecaixa;

	@Column(name = "VLR_DEMAISOBRIGACOES")
	private BigDecimal valorDemaisobrigacoes;

	@Column(name = "VLR_INSCPROCESSADOCOMDISP")
	private BigDecimal valorInscprocessadocomdisp;

	@Column(name = "VLR_INSCPROCESSADOSEMDISP")
	private BigDecimal valorInscprocessadosemdisp;

	@Column(name = "VLR_INSCNAOPROCESSADOCOMDISP")
	private BigDecimal valorInscnaoprocessadocomdisp;

	@Column(name = "VLR_INSCNAOPROCESSADOSEMDISP")
	private BigDecimal valorInscnaoprocessadosemdisp;

	@Column(name = "VLR_PATLIQEXERCANTERIOR")
	private BigDecimal valorPatliqexercanterior;

	@Column(name = "VLR_PATLIQEXERCATUAL")
	private BigDecimal valorPatliqexercatual;

	@Column(name = "VLR_PERCPARTEXERCANTERIOR")
	private BigDecimal valorPercpartexercanterior;

	@Column(name = "VLR_PERCPARTEXERCATUAL")
	private BigDecimal valorPercpartexercatual;

	@Column(name = "ANO_EXERCICIO")
	private Long anoExercicio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CONTROLECONSORCIO", referencedColumnName = "ID_CONTROLECONSORCIO")
	private ControleConsorcio controleConsorcio; // @RELACIONAMENTO:PCA_CONTROLECONSORCIO

}

