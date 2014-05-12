package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

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
 * Fntipocob generated by hbm2java
 */
@Entity
@Table(name = "FNTIPOCOB")
public class Fntipocob implements java.io.Serializable {

	private FntipocobId id;
	private Sgfilial sgfilial;
	private Fntalaocheq fntalaocheq;
	private String desctipocob;
	private String tipofebraban;
	private String tiposped;
	private String duplcob;
	private char obrigcartcob;
	private Integer codempct;
	private Short codfilialct;
	private Short nrodiascomp;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set vdclientes = new HashSet(0);
	private Set fnitrecebers = new HashSet(0);
	private Set fnitpagars = new HashSet(0);
	private Set vdvendas = new HashSet(0);
	private Set fnrecebers = new HashSet(0);
	private Set cpcompras = new HashSet(0);
	private Set fnpagars = new HashSet(0);

	public Fntipocob() {
	}

	public Fntipocob(FntipocobId id, Sgfilial sgfilial,
			Fntalaocheq fntalaocheq, String desctipocob, String tipofebraban,
			char obrigcartcob, Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.fntalaocheq = fntalaocheq;
		this.desctipocob = desctipocob;
		this.tipofebraban = tipofebraban;
		this.obrigcartcob = obrigcartcob;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Fntipocob(FntipocobId id, Sgfilial sgfilial,
			Fntalaocheq fntalaocheq, String desctipocob, String tipofebraban,
			String tiposped, String duplcob, char obrigcartcob,
			Integer codempct, Short codfilialct, Short nrodiascomp, Date dtins,
			Date hins, String idusuins, Date dtalt, Date halt, String idusualt,
			Set vdclientes, Set fnitrecebers, Set fnitpagars, Set vdvendas,
			Set fnrecebers, Set cpcompras, Set fnpagars) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.fntalaocheq = fntalaocheq;
		this.desctipocob = desctipocob;
		this.tipofebraban = tipofebraban;
		this.tiposped = tiposped;
		this.duplcob = duplcob;
		this.obrigcartcob = obrigcartcob;
		this.codempct = codempct;
		this.codfilialct = codfilialct;
		this.nrodiascomp = nrodiascomp;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.vdclientes = vdclientes;
		this.fnitrecebers = fnitrecebers;
		this.fnitpagars = fnitpagars;
		this.vdvendas = vdvendas;
		this.fnrecebers = fnrecebers;
		this.cpcompras = cpcompras;
		this.fnpagars = fnpagars;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codtipocob", column = @Column(name = "CODTIPOCOB", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public FntipocobId getId() {
		return this.id;
	}

	public void setId(FntipocobId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Sgfilial getSgfilial() {
		return this.sgfilial;
	}

	public void setSgfilial(Sgfilial sgfilial) {
		this.sgfilial = sgfilial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "NUMCONTA", referencedColumnName = "NUMCONTA", insertable = false, updatable = false),
			@JoinColumn(name = "SEQTALAO", referencedColumnName = "SEQTALAO", insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Fntalaocheq getFntalaocheq() {
		return this.fntalaocheq;
	}

	public void setFntalaocheq(Fntalaocheq fntalaocheq) {
		this.fntalaocheq = fntalaocheq;
	}

	@Column(name = "DESCTIPOCOB", nullable = false, length = 40)
	public String getDesctipocob() {
		return this.desctipocob;
	}

	public void setDesctipocob(String desctipocob) {
		this.desctipocob = desctipocob;
	}

	@Column(name = "TIPOFEBRABAN", nullable = false, length = 2)
	public String getTipofebraban() {
		return this.tipofebraban;
	}

	public void setTipofebraban(String tipofebraban) {
		this.tipofebraban = tipofebraban;
	}

	@Column(name = "TIPOSPED", length = 2)
	public String getTiposped() {
		return this.tiposped;
	}

	public void setTiposped(String tiposped) {
		this.tiposped = tiposped;
	}

	@Column(name = "DUPLCOB", length = 8)
	public String getDuplcob() {
		return this.duplcob;
	}

	public void setDuplcob(String duplcob) {
		this.duplcob = duplcob;
	}

	@Column(name = "OBRIGCARTCOB", nullable = false, length = 1)
	public char getObrigcartcob() {
		return this.obrigcartcob;
	}

	public void setObrigcartcob(char obrigcartcob) {
		this.obrigcartcob = obrigcartcob;
	}

	@Column(name = "CODEMPCT")
	public Integer getCodempct() {
		return this.codempct;
	}

	public void setCodempct(Integer codempct) {
		this.codempct = codempct;
	}

	@Column(name = "CODFILIALCT")
	public Short getCodfilialct() {
		return this.codfilialct;
	}

	public void setCodfilialct(Short codfilialct) {
		this.codfilialct = codfilialct;
	}

	@Column(name = "NRODIASCOMP")
	public Short getNrodiascomp() {
		return this.nrodiascomp;
	}

	public void setNrodiascomp(Short nrodiascomp) {
		this.nrodiascomp = nrodiascomp;
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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getVdclientes() {
		return this.vdclientes;
	}

	public void setVdclientes(Set vdclientes) {
		this.vdclientes = vdclientes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getFnitrecebers() {
		return this.fnitrecebers;
	}

	public void setFnitrecebers(Set fnitrecebers) {
		this.fnitrecebers = fnitrecebers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getFnitpagars() {
		return this.fnitpagars;
	}

	public void setFnitpagars(Set fnitpagars) {
		this.fnitpagars = fnitpagars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getVdvendas() {
		return this.vdvendas;
	}

	public void setVdvendas(Set vdvendas) {
		this.vdvendas = vdvendas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getFnrecebers() {
		return this.fnrecebers;
	}

	public void setFnrecebers(Set fnrecebers) {
		this.fnrecebers = fnrecebers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getCpcompras() {
		return this.cpcompras;
	}

	public void setCpcompras(Set cpcompras) {
		this.cpcompras = cpcompras;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fntipocob")
	public Set getFnpagars() {
		return this.fnpagars;
	}

	public void setFnpagars(Set fnpagars) {
		this.fnpagars = fnpagars;
	}
*/
}
