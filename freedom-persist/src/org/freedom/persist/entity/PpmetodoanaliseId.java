package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PpmetodoanaliseId generated by hbm2java
 */
@Embeddable
public class PpmetodoanaliseId implements java.io.Serializable {

	private short codmtanalise;
	private short codfilial;
	private int codemp;

	public PpmetodoanaliseId() {
	}

	public PpmetodoanaliseId(short codmtanalise, short codfilial, int codemp) {
		this.codmtanalise = codmtanalise;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODMTANALISE", nullable = false)
	public short getCodmtanalise() {
		return this.codmtanalise;
	}

	public void setCodmtanalise(short codmtanalise) {
		this.codmtanalise = codmtanalise;
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
		if (!(other instanceof PpmetodoanaliseId))
			return false;
		PpmetodoanaliseId castOther = (PpmetodoanaliseId) other;

		return (this.getCodmtanalise() == castOther.getCodmtanalise())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodmtanalise();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
