package org.freedom.persist.entity;

// Generated 31/05/2013 12:00:37 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tkemail generated by hbm2java
 */
@Entity
@Table(name = "TKEMAIL")
public class Tkemail implements java.io.Serializable {

	private TkemailId id;
	private Tkconfemail tkconfemail;
	private String descemail;
	private String assunto;
	private String corpo;
	private String formato;
	private String charset;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set<Sgprefere3> sgprefere3sForSgprefere3fktkemec = new HashSet<Sgprefere3>(
			0);
	private Set<Sgprefere3> sgprefere3sForSgprefere3fktkemai = new HashSet<Sgprefere3>(
			0);
	private Set<Sgprefere3> sgprefere3sForSgprefere3fktkeme2 = new HashSet<Sgprefere3>(
			0);
	private Set<Sgprefere3> sgprefere3sForSgprefere3fktkemea = new HashSet<Sgprefere3>(
			0);
	private Set<Sgprefere3> sgprefere3sForSgprefere3fktkemen = new HashSet<Sgprefere3>(
			0);
	private Set<Tkcampanhaemail> tkcampanhaemails = new HashSet<Tkcampanhaemail>(
			0);

	public Tkemail() {
	}

	public Tkemail(TkemailId id, Tkconfemail tkconfemail, String descemail,
			String assunto, String corpo, String formato, String charset,
			Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.tkconfemail = tkconfemail;
		this.descemail = descemail;
		this.assunto = assunto;
		this.corpo = corpo;
		this.formato = formato;
		this.charset = charset;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Tkemail(TkemailId id, Tkconfemail tkconfemail, String descemail,
			String assunto, String corpo, String formato, String charset,
			Date dtins, Date hins, String idusuins, Date dtalt, Date halt,
			String idusualt, Set<Sgprefere3> sgprefere3sForSgprefere3fktkemec,
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemai,
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkeme2,
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemea,
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemen,
			Set<Tkcampanhaemail> tkcampanhaemails) {
		this.id = id;
		this.tkconfemail = tkconfemail;
		this.descemail = descemail;
		this.assunto = assunto;
		this.corpo = corpo;
		this.formato = formato;
		this.charset = charset;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.sgprefere3sForSgprefere3fktkemec = sgprefere3sForSgprefere3fktkemec;
		this.sgprefere3sForSgprefere3fktkemai = sgprefere3sForSgprefere3fktkemai;
		this.sgprefere3sForSgprefere3fktkeme2 = sgprefere3sForSgprefere3fktkeme2;
		this.sgprefere3sForSgprefere3fktkemea = sgprefere3sForSgprefere3fktkemea;
		this.sgprefere3sForSgprefere3fktkemen = sgprefere3sForSgprefere3fktkemen;
		this.tkcampanhaemails = tkcampanhaemails;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codemail", column = @Column(name = "CODEMAIL", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public TkemailId getId() {
		return this.id;
	}

	public void setId(TkemailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCONFEMAIL", referencedColumnName = "CODCONFEMAIL", nullable = false),
			@JoinColumn(name = "CODFILIALCM", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPCM", referencedColumnName = "CODEMP", nullable = false) })
	public Tkconfemail getTkconfemail() {
		return this.tkconfemail;
	}

	public void setTkconfemail(Tkconfemail tkconfemail) {
		this.tkconfemail = tkconfemail;
	}

	@Column(name = "DESCEMAIL", nullable = false, length = 50)
	public String getDescemail() {
		return this.descemail;
	}

	public void setDescemail(String descemail) {
		this.descemail = descemail;
	}

	@Column(name = "ASSUNTO", nullable = false, length = 120)
	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	@Column(name = "CORPO", nullable = false, length = 20000)
	public String getCorpo() {
		return this.corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	@Column(name = "FORMATO", nullable = false, length = 10)
	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Column(name = "CHARSET", nullable = false, length = 10)
	public String getCharset() {
		return this.charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
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

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemailBySgprefere3fktkemec")
	public Set<Sgprefere3> getSgprefere3sForSgprefere3fktkemec() {
		return this.sgprefere3sForSgprefere3fktkemec;
	}

	public void setSgprefere3sForSgprefere3fktkemec(
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemec) {
		this.sgprefere3sForSgprefere3fktkemec = sgprefere3sForSgprefere3fktkemec;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemailBySgprefere3fktkemai")
	public Set<Sgprefere3> getSgprefere3sForSgprefere3fktkemai() {
		return this.sgprefere3sForSgprefere3fktkemai;
	}

	public void setSgprefere3sForSgprefere3fktkemai(
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemai) {
		this.sgprefere3sForSgprefere3fktkemai = sgprefere3sForSgprefere3fktkemai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemailBySgprefere3fktkeme2")
	public Set<Sgprefere3> getSgprefere3sForSgprefere3fktkeme2() {
		return this.sgprefere3sForSgprefere3fktkeme2;
	}

	public void setSgprefere3sForSgprefere3fktkeme2(
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkeme2) {
		this.sgprefere3sForSgprefere3fktkeme2 = sgprefere3sForSgprefere3fktkeme2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemailBySgprefere3fktkemea")
	public Set<Sgprefere3> getSgprefere3sForSgprefere3fktkemea() {
		return this.sgprefere3sForSgprefere3fktkemea;
	}

	public void setSgprefere3sForSgprefere3fktkemea(
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemea) {
		this.sgprefere3sForSgprefere3fktkemea = sgprefere3sForSgprefere3fktkemea;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemailBySgprefere3fktkemen")
	public Set<Sgprefere3> getSgprefere3sForSgprefere3fktkemen() {
		return this.sgprefere3sForSgprefere3fktkemen;
	}

	public void setSgprefere3sForSgprefere3fktkemen(
			Set<Sgprefere3> sgprefere3sForSgprefere3fktkemen) {
		this.sgprefere3sForSgprefere3fktkemen = sgprefere3sForSgprefere3fktkemen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tkemail")
	public Set<Tkcampanhaemail> getTkcampanhaemails() {
		return this.tkcampanhaemails;
	}

	public void setTkcampanhaemails(Set<Tkcampanhaemail> tkcampanhaemails) {
		this.tkcampanhaemails = tkcampanhaemails;
	}

}
