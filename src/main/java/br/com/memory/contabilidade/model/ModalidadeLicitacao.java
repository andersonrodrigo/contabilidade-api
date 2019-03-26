package br.com.memory.contabilidade.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.ModalidadeLicitacaoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MODALIDADELICITACAO")
@Entity
public class ModalidadeLicitacao {
	@EmbeddedId
	private ModalidadeLicitacaoId idModalidadeLicitacao;

	@Column(name = "DES_MODALIDADELICITACAO")
	private String descricaoModalidadelicitacao;

	@Column(name = "CTR_SEQMODALIDADE")
	private Long ctr_seqmodalidade;

	@Column(name = "VLR_PRAZOPROPOSTA")
	private Long valorPrazoproposta;

	@Column(name = "VLR_LIMITESERVICO")
	private BigDecimal valorLimiteservico;

	@Column(name = "VLR_LIMITEOBRA")
	private BigDecimal valorLimiteobra;

	@Column(name = "FGL_VERIFICALIMITE")
	private String flagVerificalimite;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "modalidadeLicitacao", fetch=FetchType.LAZY)
	private List<Empenho> listaEmpenho;

	/*
	@OneToMany(mappedBy = "PROCESSO", fetch=FetchType.LAZY)
	private List<PROCESSO> listaPROCESSO;
	*/

}

