package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EqitrecmercitcpId generated by hbm2java
 */
@Embeddable
public class EqitrecmercitcpId implements java.io.Serializable {

	private int ticket;
	private int coditrecmerc;
	private short codfilial;
	private int codemp;
	private int codempcp;
	private short codfilialcp;
	private int codcompra;
	private short coditcompra;

	public EqitrecmercitcpId() {
	}

	public EqitrecmercitcpId(int ticket, int coditrecmerc, short codfilial,
			int codemp, int codempcp, short codfilialcp, int codcompra,
			short coditcompra) {
		this.ticket = ticket;
		this.coditrecmerc = coditrecmerc;
		this.codfilial = codfilial;
		this.codemp = codemp;
		this.codempcp = codempcp;
		this.codfilialcp = codfilialcp;
		this.codcompra = codcompra;
		this.coditcompra = coditcompra;
	}

	@Column(name = "TICKET", nullable = false)
	public int getTicket() {
		return this.ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	@Column(name = "CODITRECMERC", nullable = false)
	public int getCoditrecmerc() {
		return this.coditrecmerc;
	}

	public void setCoditrecmerc(int coditrecmerc) {
		this.coditrecmerc = coditrecmerc;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	@Column(name = "CODEMPCP", nullable = false)
	public int getCodempcp() {
		return this.codempcp;
	}

	public void setCodempcp(int codempcp) {
		this.codempcp = codempcp;
	}

	@Column(name = "CODFILIALCP", nullable = false)
	public short getCodfilialcp() {
		return this.codfilialcp;
	}

	public void setCodfilialcp(short codfilialcp) {
		this.codfilialcp = codfilialcp;
	}

	@Column(name = "CODCOMPRA", nullable = false)
	public int getCodcompra() {
		return this.codcompra;
	}

	public void setCodcompra(int codcompra) {
		this.codcompra = codcompra;
	}

	@Column(name = "CODITCOMPRA", nullable = false)
	public short getCoditcompra() {
		return this.coditcompra;
	}

	public void setCoditcompra(short coditcompra) {
		this.coditcompra = coditcompra;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EqitrecmercitcpId))
			return false;
		EqitrecmercitcpId castOther = (EqitrecmercitcpId) other;

		return (this.getTicket() == castOther.getTicket())
				&& (this.getCoditrecmerc() == castOther.getCoditrecmerc())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp())
				&& (this.getCodempcp() == castOther.getCodempcp())
				&& (this.getCodfilialcp() == castOther.getCodfilialcp())
				&& (this.getCodcompra() == castOther.getCodcompra())
				&& (this.getCoditcompra() == castOther.getCoditcompra());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTicket();
		result = 37 * result + this.getCoditrecmerc();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		result = 37 * result + this.getCodempcp();
		result = 37 * result + this.getCodfilialcp();
		result = 37 * result + this.getCodcompra();
		result = 37 * result + this.getCoditcompra();
		return result;
	}

}
