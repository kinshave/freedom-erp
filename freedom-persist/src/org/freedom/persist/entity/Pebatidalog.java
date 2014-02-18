package org.freedom.persist.entity;

// Generated 18/02/2014 15:53:28 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Pebatidalog generated by hbm2java
 */
public class Pebatidalog implements java.io.Serializable {

	private PebatidalogId id;
	private char tipolog;
	private char tipobat;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private String idusulog;
	private Date dtinslog;
	private Date hinslog;

	public Pebatidalog() {
	}

	public Pebatidalog(PebatidalogId id, char tipolog, char tipobat,
			Date dtins, Date hins, String idusuins, Date dtalt, Date halt,
			String idusualt, String idusulog, Date dtinslog, Date hinslog) {
		this.id = id;
		this.tipolog = tipolog;
		this.tipobat = tipobat;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.idusulog = idusulog;
		this.dtinslog = dtinslog;
		this.hinslog = hinslog;
	}

	public PebatidalogId getId() {
		return this.id;
	}

	public void setId(PebatidalogId id) {
		this.id = id;
	}

	public char getTipolog() {
		return this.tipolog;
	}

	public void setTipolog(char tipolog) {
		this.tipolog = tipolog;
	}

	public char getTipobat() {
		return this.tipobat;
	}

	public void setTipobat(char tipobat) {
		this.tipobat = tipobat;
	}

	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	public String getIdusulog() {
		return this.idusulog;
	}

	public void setIdusulog(String idusulog) {
		this.idusulog = idusulog;
	}

	public Date getDtinslog() {
		return this.dtinslog;
	}

	public void setDtinslog(Date dtinslog) {
		this.dtinslog = dtinslog;
	}

	public Date getHinslog() {
		return this.hinslog;
	}

	public void setHinslog(Date hinslog) {
		this.hinslog = hinslog;
	}

}
