package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PptipoanaliseId generated by hbm2java
 */
@Embeddable
public class PptipoanaliseId implements java.io.Serializable {

	private short codtpanalise;
	private short codfilial;
	private int codemp;

	public PptipoanaliseId() {
	}

	public PptipoanaliseId(short codtpanalise, short codfilial, int codemp) {
		this.codtpanalise = codtpanalise;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODTPANALISE", nullable = false)
	public short getCodtpanalise() {
		return this.codtpanalise;
	}

	public void setCodtpanalise(short codtpanalise) {
		this.codtpanalise = codtpanalise;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PptipoanaliseId))
			return false;
		PptipoanaliseId castOther = (PptipoanaliseId) other;

		return (this.getCodtpanalise() == castOther.getCodtpanalise())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodtpanalise();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
