package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VditgruporcId generated by hbm2java
 */
@Embeddable
public class VditgruporcId implements java.io.Serializable {

	private int codgo;
	private short seqitgo;
	private short codfilial;
	private int codemp;

	public VditgruporcId() {
	}

	public VditgruporcId(int codgo, short seqitgo, short codfilial, int codemp) {
		this.codgo = codgo;
		this.seqitgo = seqitgo;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODGO", nullable = false)
	public int getCodgo() {
		return this.codgo;
	}

	public void setCodgo(int codgo) {
		this.codgo = codgo;
	}

	@Column(name = "SEQITGO", nullable = false)
	public short getSeqitgo() {
		return this.seqitgo;
	}

	public void setSeqitgo(short seqitgo) {
		this.seqitgo = seqitgo;
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
		if (!(other instanceof VditgruporcId))
			return false;
		VditgruporcId castOther = (VditgruporcId) other;

		return (this.getCodgo() == castOther.getCodgo())
				&& (this.getSeqitgo() == castOther.getSeqitgo())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodgo();
		result = 37 * result + this.getSeqitgo();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
