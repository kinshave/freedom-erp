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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rhfuncao generated by hbm2java
 */
@Entity
@Table(name = "RHFUNCAO")
public class Rhfuncao implements java.io.Serializable {

	private RhfuncaoId id;
	private String descfunc;
	private String cbofunc;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set rhvagas = new HashSet(0);
	private Set rhempregados = new HashSet(0);
	private Set rhcandidatofuncs = new HashSet(0);
	private Set vdvendedors = new HashSet(0);
	private Set atconveniados = new HashSet(0);

	public Rhfuncao() {
	}

	public Rhfuncao(RhfuncaoId id, String descfunc, Date dtins, Date hins,
			String idusuins) {
		this.id = id;
		this.descfunc = descfunc;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Rhfuncao(RhfuncaoId id, String descfunc, String cbofunc, Date dtins,
			Date hins, String idusuins, Date dtalt, Date halt, String idusualt,
			Set rhvagas, Set rhempregados, Set rhcandidatofuncs,
			Set vdvendedors, Set atconveniados) {
		this.id = id;
		this.descfunc = descfunc;
		this.cbofunc = cbofunc;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.rhvagas = rhvagas;
		this.rhempregados = rhempregados;
		this.rhcandidatofuncs = rhcandidatofuncs;
		this.vdvendedors = vdvendedors;
		this.atconveniados = atconveniados;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codfunc", column = @Column(name = "CODFUNC", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public RhfuncaoId getId() {
		return this.id;
	}

	public void setId(RhfuncaoId id) {
		this.id = id;
	}

	@Column(name = "DESCFUNC", nullable = false, length = 100)
	public String getDescfunc() {
		return this.descfunc;
	}

	public void setDescfunc(String descfunc) {
		this.descfunc = descfunc;
	}

	@Column(name = "CBOFUNC", length = 10)
	public String getCbofunc() {
		return this.cbofunc;
	}

	public void setCbofunc(String cbofunc) {
		this.cbofunc = cbofunc;
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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhfuncao")
	public Set getRhvagas() {
		return this.rhvagas;
	}

	public void setRhvagas(Set rhvagas) {
		this.rhvagas = rhvagas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhfuncao")
	public Set getRhempregados() {
		return this.rhempregados;
	}

	public void setRhempregados(Set rhempregados) {
		this.rhempregados = rhempregados;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhfuncao")
	public Set getRhcandidatofuncs() {
		return this.rhcandidatofuncs;
	}

	public void setRhcandidatofuncs(Set rhcandidatofuncs) {
		this.rhcandidatofuncs = rhcandidatofuncs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhfuncao")
	public Set getVdvendedors() {
		return this.vdvendedors;
	}

	public void setVdvendedors(Set vdvendedors) {
		this.vdvendedors = vdvendedors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhfuncao")
	public Set getAtconveniados() {
		return this.atconveniados;
	}

	public void setAtconveniados(Set atconveniados) {
		this.atconveniados = atconveniados;
	}
*/
}
