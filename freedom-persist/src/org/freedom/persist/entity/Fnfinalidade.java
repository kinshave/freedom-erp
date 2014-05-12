package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fnfinalidade generated by hbm2java
 */
@Entity
@Table(name = "FNFINALIDADE")
public class Fnfinalidade implements java.io.Serializable {

	private String codfin;
	private String descfin;
	private char esfin;
	private char clasfin;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Fnfinalidade() {
	}

	public Fnfinalidade(String codfin, String descfin, char esfin,
			char clasfin, Date dtins, Date hins, String idusuins) {
		this.codfin = codfin;
		this.descfin = descfin;
		this.esfin = esfin;
		this.clasfin = clasfin;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Fnfinalidade(String codfin, String descfin, char esfin,
			char clasfin, Date dtins, Date hins, String idusuins, Date dtalt,
			Date halt, String idusualt) {
		this.codfin = codfin;
		this.descfin = descfin;
		this.esfin = esfin;
		this.clasfin = clasfin;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	@Id
	@Column(name = "CODFIN", unique = true, nullable = false, length = 3)
	public String getCodfin() {
		return this.codfin;
	}

	public void setCodfin(String codfin) {
		this.codfin = codfin;
	}

	@Column(name = "DESCFIN", nullable = false, length = 50)
	public String getDescfin() {
		return this.descfin;
	}

	public void setDescfin(String descfin) {
		this.descfin = descfin;
	}

	@Column(name = "ESFIN", nullable = false, length = 1)
	public char getEsfin() {
		return this.esfin;
	}

	public void setEsfin(char esfin) {
		this.esfin = esfin;
	}

	@Column(name = "CLASFIN", nullable = false, length = 1)
	public char getClasfin() {
		return this.clasfin;
	}

	public void setClasfin(char clasfin) {
		this.clasfin = clasfin;
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

}
