package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VdsetorId generated by hbm2java
 */
@Embeddable
public class VdsetorId implements java.io.Serializable {

	private int codsetor;
	private short codfilial;
	private int codemp;

	public VdsetorId() {
	}

	public VdsetorId(int codsetor, short codfilial, int codemp) {
		this.codsetor = codsetor;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODSETOR", nullable = false)
	public int getCodsetor() {
		return this.codsetor;
	}

	public void setCodsetor(int codsetor) {
		this.codsetor = codsetor;
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
		if (!(other instanceof VdsetorId))
			return false;
		VdsetorId castOther = (VdsetorId) other;

		return (this.getCodsetor() == castOther.getCodsetor())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodsetor();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
