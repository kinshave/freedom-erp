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
 * Vdprazoent generated by hbm2java
 */
@Entity
@Table(name = "VDPRAZOENT")
public class Vdprazoent implements java.io.Serializable {

	private VdprazoentId id;
	private String descpe;
	private short diaspe;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set vditvendas = new HashSet(0);
	private Set eqprodutos = new HashSet(0);
	private Set vditorcamentos = new HashSet(0);

	public Vdprazoent() {
	}

	public Vdprazoent(VdprazoentId id, String descpe, short diaspe, Date dtins,
			Date hins, String idusuins, Date halt) {
		this.id = id;
		this.descpe = descpe;
		this.diaspe = diaspe;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.halt = halt;
	}

	public Vdprazoent(VdprazoentId id, String descpe, short diaspe, Date dtins,
			Date hins, String idusuins, Date dtalt, Date halt, String idusualt,
			Set vditvendas, Set eqprodutos, Set vditorcamentos) {
		this.id = id;
		this.descpe = descpe;
		this.diaspe = diaspe;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.vditvendas = vditvendas;
		this.eqprodutos = eqprodutos;
		this.vditorcamentos = vditorcamentos;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codpe", column = @Column(name = "CODPE", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public VdprazoentId getId() {
		return this.id;
	}

	public void setId(VdprazoentId id) {
		this.id = id;
	}

	@Column(name = "DESCPE", nullable = false, length = 50)
	public String getDescpe() {
		return this.descpe;
	}

	public void setDescpe(String descpe) {
		this.descpe = descpe;
	}

	@Column(name = "DIASPE", nullable = false)
	public short getDiaspe() {
		return this.diaspe;
	}

	public void setDiaspe(short diaspe) {
		this.diaspe = diaspe;
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
	@Column(name = "HALT", nullable = false, length = 8)
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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "vdprazoent")
	public Set getVditvendas() {
		return this.vditvendas;
	}

	public void setVditvendas(Set vditvendas) {
		this.vditvendas = vditvendas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vdprazoent")
	public Set getEqprodutos() {
		return this.eqprodutos;
	}

	public void setEqprodutos(Set eqprodutos) {
		this.eqprodutos = eqprodutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vdprazoent")
	public Set getVditorcamentos() {
		return this.vditorcamentos;
	}

	public void setVditorcamentos(Set vditorcamentos) {
		this.vditorcamentos = vditorcamentos;
	}
*/
}
