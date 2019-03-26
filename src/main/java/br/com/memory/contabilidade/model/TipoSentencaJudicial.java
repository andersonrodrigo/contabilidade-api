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
@Table(name = "PCA_TPSENTENCASJUDICIAIS")
@Entity
public class TipoSentencaJudicial {
	@Id
	@Column(name = "ID_TPSENTENCAJUDICIAL")
	private Long idTpsentencajudicial;

	@Column(name = "COD_TPSENTENCAJUDICIAL")
	private Long codigoTpsentencajudicial;

	@Column(name = "DES_TPSENTENCASJUDICIAL")
	private String descricaoTpsentencasjudicial;

	@Column(name = "DAT_DESATIVACAO")
	private Timestamp dataDesativacao;

	@Column(name = "FLG_PRECATORIO")
	private String flagPrecatorio;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@OneToMany(mappedBy = "tipoSentencaJudicial", fetch=FetchType.LAZY)
	private List<Precatorio> listaPrecatorio;

	@OneToMany(mappedBy = "tipoSentencaJudicial", fetch=FetchType.LAZY)
	private List<TipoPrecatorio> listaTipoPrecatorio;

}

