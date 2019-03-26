package br.com.memory.contabilidade.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.memory.contabilidade.model.Id.FonteRecursoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "FONTERECURSO")
@Entity
public class FonteRecurso {
	@EmbeddedId
	private FonteRecursoId idFonteRecurso;

	@Column(name = "DES_FONTERECURSO")
	private String descricaoFonterecurso;

	@Column(name = "IDT_TIPORECURSO")
	private String idtTiporecurso;

	@Column(name = "DAT_LASTREC")
	private Timestamp dataLastrec;

	@Column(name = "COD_USUARIO")
	private String codigoUsuario;

	@Column(name = "COD_FONTERECURSODESTINACAO")
	private String codigoFonterecursodestinacao;

	@Column(name = "COD_FONTERECURSODESTINACAOSUP")
	private String codigoFonterecursodestinacaosup;

	@Column(name = "COD_FONTESEMMASCARA")
	private String codigoFontesemmascara;

	@Column(name = "FLG_SINTETICA")
	private String flagSintetica;

	@Column(name = "IDT_PRIMARIA")
	private String idtPrimaria;

	@Column(name = "FLG_SICOM")
	private String flagSicom;

	@Column(name = "COD_AUXILIAR")
	private String codigoAuxiliar;

	@Column(name = "ID_GRUPOFONTERECURSO")
	private Long idGrupofonterecurso;

	@Column(name = "FLG_FONTEEXERCICIOANT")
	private String flagFonteexercicioant;

	@Column(name = "COD_FONTERECURSO_MSC")
	private String codigoFonterecursomsc;

	/*
	@OneToMany(mappedBy = "CT_FONTERECURSOSIOPE", fetch=FetchType.LAZY)
	private List<CT_FONTERECURSOSIOPE> CT_FONTERECURSOSIOPEs;

	@OneToMany(mappedBy = "CT_VINCULACTCORRENTE", fetch=FetchType.LAZY)
	private List<CT_VINCULACTCORRENTE> CT_VINCULACTCORRENTEs;

	@OneToMany(mappedBy = "fonteRecurso", fetch=FetchType.LAZY)
	private List<OrcamentoDespesa> orcamentoDespesas;

	@OneToMany(mappedBy = "PCA_ADIANTAMENTOFICHAS", fetch=FetchType.LAZY)
	private List<PCA_ADIANTAMENTOFICHAS> PCA_ADIANTAMENTOFICHASs;

	@OneToMany(mappedBy = "fonteRecursp", fetch=FetchType.LAZY)
	private List<BalanceteChaveDetalhe> balanceteChaveDetalhes;

	@OneToMany(mappedBy = "PPA_FONTERECURSO", fetch=FetchType.LAZY)
	private List<PPA_FONTERECURSO> PPA_FONTERECURSOs;

	@OneToMany(mappedBy = "fonteRecurso", fetch=FetchType.LAZY)
	private List<OrcamentoReceita> orcamentoReceitas;

	@OneToMany(mappedBy = "RPSUFICIENCIARESUMO", fetch=FetchType.LAZY)
	private List<RPSUFICIENCIARESUMO> RPSUFICIENCIARESUMOs;
	*/
}

