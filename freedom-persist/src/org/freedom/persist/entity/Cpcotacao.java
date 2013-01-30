package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cpcotacao generated by hbm2java
 */
@Entity
@Table(name = "CPCOTACAO")
public class Cpcotacao implements java.io.Serializable {

	private CpcotacaoId id;
	private Fnplanopag fnplanopag;
	private Date dtcot;
	private Date dtvalidcot;
	private String idusucot;
	private int codempfr;
	private short codfilialfr;
	private int codfor;
	private BigDecimal qtdcot;
	private BigDecimal qtdaprovcot;
	private BigDecimal precocot;
	private String sitcompitsol;
	private String sitaprovitsol;
	private String sititsol;
	private String motivocanccot;
	private String motivocotabaixo;
	private Character usarendacot;
	private Short rendacot;
	private String idusualt;
	private BigDecimal vlrfreteitcompra;
	private BigDecimal percipiitcompra;
	private BigDecimal vlrbaseipiitcompra;
	private BigDecimal vlripiitcompra;
	private BigDecimal vlrliqitcompra;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;

	public Cpcotacao() {
	}

	public Cpcotacao(CpcotacaoId id, Date dtcot, Date dtvalidcot,
			String idusucot, int codempfr, short codfilialfr, int codfor,
			BigDecimal qtdcot, BigDecimal qtdaprovcot, BigDecimal precocot,
			Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.dtcot = dtcot;
		this.dtvalidcot = dtvalidcot;
		this.idusucot = idusucot;
		this.codempfr = codempfr;
		this.codfilialfr = codfilialfr;
		this.codfor = codfor;
		this.qtdcot = qtdcot;
		this.qtdaprovcot = qtdaprovcot;
		this.precocot = precocot;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Cpcotacao(CpcotacaoId id, Fnplanopag fnplanopag, Date dtcot,
			Date dtvalidcot, String idusucot, int codempfr, short codfilialfr,
			int codfor, BigDecimal qtdcot, BigDecimal qtdaprovcot,
			BigDecimal precocot, String sitcompitsol, String sitaprovitsol,
			String sititsol, String motivocanccot, String motivocotabaixo,
			Character usarendacot, Short rendacot, String idusualt,
			BigDecimal vlrfreteitcompra, BigDecimal percipiitcompra,
			BigDecimal vlrbaseipiitcompra, BigDecimal vlripiitcompra,
			BigDecimal vlrliqitcompra, Date dtins, Date hins, String idusuins,
			Date dtalt, Date halt) {
		this.id = id;
		this.fnplanopag = fnplanopag;
		this.dtcot = dtcot;
		this.dtvalidcot = dtvalidcot;
		this.idusucot = idusucot;
		this.codempfr = codempfr;
		this.codfilialfr = codfilialfr;
		this.codfor = codfor;
		this.qtdcot = qtdcot;
		this.qtdaprovcot = qtdaprovcot;
		this.precocot = precocot;
		this.sitcompitsol = sitcompitsol;
		this.sitaprovitsol = sitaprovitsol;
		this.sititsol = sititsol;
		this.motivocanccot = motivocanccot;
		this.motivocotabaixo = motivocotabaixo;
		this.usarendacot = usarendacot;
		this.rendacot = rendacot;
		this.idusualt = idusualt;
		this.vlrfreteitcompra = vlrfreteitcompra;
		this.percipiitcompra = percipiitcompra;
		this.vlrbaseipiitcompra = vlrbaseipiitcompra;
		this.vlripiitcompra = vlripiitcompra;
		this.vlrliqitcompra = vlrliqitcompra;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codsol", column = @Column(name = "CODSOL", nullable = false)),
			@AttributeOverride(name = "coditsol", column = @Column(name = "CODITSOL", nullable = false)),
			@AttributeOverride(name = "codcot", column = @Column(name = "CODCOT", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public CpcotacaoId getId() {
		return this.id;
	}

	public void setId(CpcotacaoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPLANOPAG", referencedColumnName = "CODPLANOPAG"),
			@JoinColumn(name = "CODFILIALPP", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPPP", referencedColumnName = "CODEMP") })
	public Fnplanopag getFnplanopag() {
		return this.fnplanopag;
	}

	public void setFnplanopag(Fnplanopag fnplanopag) {
		this.fnplanopag = fnplanopag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTCOT", nullable = false, length = 10)
	public Date getDtcot() {
		return this.dtcot;
	}

	public void setDtcot(Date dtcot) {
		this.dtcot = dtcot;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTVALIDCOT", nullable = false, length = 10)
	public Date getDtvalidcot() {
		return this.dtvalidcot;
	}

	public void setDtvalidcot(Date dtvalidcot) {
		this.dtvalidcot = dtvalidcot;
	}

	@Column(name = "IDUSUCOT", nullable = false, length = 8)
	public String getIdusucot() {
		return this.idusucot;
	}

	public void setIdusucot(String idusucot) {
		this.idusucot = idusucot;
	}

	@Column(name = "CODEMPFR", nullable = false)
	public int getCodempfr() {
		return this.codempfr;
	}

	public void setCodempfr(int codempfr) {
		this.codempfr = codempfr;
	}

	@Column(name = "CODFILIALFR", nullable = false)
	public short getCodfilialfr() {
		return this.codfilialfr;
	}

	public void setCodfilialfr(short codfilialfr) {
		this.codfilialfr = codfilialfr;
	}

	@Column(name = "CODFOR", nullable = false)
	public int getCodfor() {
		return this.codfor;
	}

	public void setCodfor(int codfor) {
		this.codfor = codfor;
	}

	@Column(name = "QTDCOT", nullable = false, precision = 15, scale = 5)
	public BigDecimal getQtdcot() {
		return this.qtdcot;
	}

	public void setQtdcot(BigDecimal qtdcot) {
		this.qtdcot = qtdcot;
	}

	@Column(name = "QTDAPROVCOT", nullable = false, precision = 15, scale = 5)
	public BigDecimal getQtdaprovcot() {
		return this.qtdaprovcot;
	}

	public void setQtdaprovcot(BigDecimal qtdaprovcot) {
		this.qtdaprovcot = qtdaprovcot;
	}

	@Column(name = "PRECOCOT", nullable = false, precision = 15, scale = 5)
	public BigDecimal getPrecocot() {
		return this.precocot;
	}

	public void setPrecocot(BigDecimal precocot) {
		this.precocot = precocot;
	}

	@Column(name = "SITCOMPITSOL", length = 2)
	public String getSitcompitsol() {
		return this.sitcompitsol;
	}

	public void setSitcompitsol(String sitcompitsol) {
		this.sitcompitsol = sitcompitsol;
	}

	@Column(name = "SITAPROVITSOL", length = 2)
	public String getSitaprovitsol() {
		return this.sitaprovitsol;
	}

	public void setSitaprovitsol(String sitaprovitsol) {
		this.sitaprovitsol = sitaprovitsol;
	}

	@Column(name = "SITITSOL", length = 2)
	public String getSititsol() {
		return this.sititsol;
	}

	public void setSititsol(String sititsol) {
		this.sititsol = sititsol;
	}

	@Column(name = "MOTIVOCANCCOT", length = 10000)
	public String getMotivocanccot() {
		return this.motivocanccot;
	}

	public void setMotivocanccot(String motivocanccot) {
		this.motivocanccot = motivocanccot;
	}

	@Column(name = "MOTIVOCOTABAIXO", length = 10000)
	public String getMotivocotabaixo() {
		return this.motivocotabaixo;
	}

	public void setMotivocotabaixo(String motivocotabaixo) {
		this.motivocotabaixo = motivocotabaixo;
	}

	@Column(name = "USARENDACOT", length = 1)
	public Character getUsarendacot() {
		return this.usarendacot;
	}

	public void setUsarendacot(Character usarendacot) {
		this.usarendacot = usarendacot;
	}

	@Column(name = "RENDACOT")
	public Short getRendacot() {
		return this.rendacot;
	}

	public void setRendacot(Short rendacot) {
		this.rendacot = rendacot;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	@Column(name = "VLRFRETEITCOMPRA", precision = 15, scale = 5)
	public BigDecimal getVlrfreteitcompra() {
		return this.vlrfreteitcompra;
	}

	public void setVlrfreteitcompra(BigDecimal vlrfreteitcompra) {
		this.vlrfreteitcompra = vlrfreteitcompra;
	}

	@Column(name = "PERCIPIITCOMPRA", precision = 9)
	public BigDecimal getPercipiitcompra() {
		return this.percipiitcompra;
	}

	public void setPercipiitcompra(BigDecimal percipiitcompra) {
		this.percipiitcompra = percipiitcompra;
	}

	@Column(name = "VLRBASEIPIITCOMPRA", precision = 15, scale = 5)
	public BigDecimal getVlrbaseipiitcompra() {
		return this.vlrbaseipiitcompra;
	}

	public void setVlrbaseipiitcompra(BigDecimal vlrbaseipiitcompra) {
		this.vlrbaseipiitcompra = vlrbaseipiitcompra;
	}

	@Column(name = "VLRIPIITCOMPRA", precision = 15, scale = 5)
	public BigDecimal getVlripiitcompra() {
		return this.vlripiitcompra;
	}

	public void setVlripiitcompra(BigDecimal vlripiitcompra) {
		this.vlripiitcompra = vlripiitcompra;
	}

	@Column(name = "VLRLIQITCOMPRA", precision = 15, scale = 5)
	public BigDecimal getVlrliqitcompra() {
		return this.vlrliqitcompra;
	}

	public void setVlrliqitcompra(BigDecimal vlrliqitcompra) {
		this.vlrliqitcompra = vlrliqitcompra;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

}
