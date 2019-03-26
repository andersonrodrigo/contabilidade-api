package br.com.memory.contabilidade.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PCA_TIPOPRECATORIOS")
@Entity
public class TipoPrecatorio {
	@Id
	@Column(name = "ID_TIPOPRECATORIO")
	private Long idTipoprecatorio;

	@Column(name = "COD_TIPOPRECATORIO")
	private Long codigoTipoprecatorio;

	@Column(name = "DES_TIPOPRECATORIO")
	private String descricaoTipoprecatorio;

	@Column(name = "DAT_DESATIVACAO")
	private Timestamp dataDesativacao;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "tipoPrecatorio", fetch=FetchType.LAZY)
	private List<Precatorio> listaPrecatorio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TPSENTENCAJUDICIAL", referencedColumnName = "ID_TPSENTENCAJUDICIAL")
	private TipoSentencaJudicial tipoSentencaJudicial; // @RELACIONAMENTO:PCA_TPSENTENCASJUDICIAIS

}

