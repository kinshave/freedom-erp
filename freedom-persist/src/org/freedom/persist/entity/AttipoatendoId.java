package org.freedom.persist.entity;

// Generated 31/05/2013 12:00:37 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AttipoatendoId generated by hbm2java
 */
@Embeddable
public class AttipoatendoId implements java.io.Serializable {

	private int codtpatendo;
	private short codfilial;
	private int codemp;

	public AttipoatendoId() {
	}

	public AttipoatendoId(int codtpatendo, short codfilial, int codemp) {
		this.codtpatendo = codtpatendo;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODTPATENDO", nullable = false)
	public int getCodtpatendo() {
		return this.codtpatendo;
	}

	public void setCodtpatendo(int codtpatendo) {
		this.codtpatendo = codtpatendo;
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
		if (!(other instanceof AttipoatendoId))
			return false;
		AttipoatendoId castOther = (AttipoatendoId) other;

		return (this.getCodtpatendo() == castOther.getCodtpatendo())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodtpatendo();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
