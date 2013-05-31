package org.freedom.persist.entity;

// Generated 31/05/2013 12:00:37 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SgmoduloId generated by hbm2java
 */
@Embeddable
public class SgmoduloId implements java.io.Serializable {

	private int codmodu;
	private int codsis;

	public SgmoduloId() {
	}

	public SgmoduloId(int codmodu, int codsis) {
		this.codmodu = codmodu;
		this.codsis = codsis;
	}

	@Column(name = "CODMODU", nullable = false)
	public int getCodmodu() {
		return this.codmodu;
	}

	public void setCodmodu(int codmodu) {
		this.codmodu = codmodu;
	}

	@Column(name = "CODSIS", nullable = false)
	public int getCodsis() {
		return this.codsis;
	}

	public void setCodsis(int codsis) {
		this.codsis = codsis;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SgmoduloId))
			return false;
		SgmoduloId castOther = (SgmoduloId) other;

		return (this.getCodmodu() == castOther.getCodmodu())
				&& (this.getCodsis() == castOther.getCodsis());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodmodu();
		result = 37 * result + this.getCodsis();
		return result;
	}

}
