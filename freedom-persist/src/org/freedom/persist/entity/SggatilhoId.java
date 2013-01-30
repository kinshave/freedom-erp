package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SggatilhoId generated by hbm2java
 */
@Embeddable
public class SggatilhoId implements java.io.Serializable {

	private int codobj;
	private String dispgat;
	private int codemp;

	public SggatilhoId() {
	}

	public SggatilhoId(int codobj, String dispgat, int codemp) {
		this.codobj = codobj;
		this.dispgat = dispgat;
		this.codemp = codemp;
	}

	@Column(name = "CODOBJ", nullable = false)
	public int getCodobj() {
		return this.codobj;
	}

	public void setCodobj(int codobj) {
		this.codobj = codobj;
	}

	@Column(name = "DISPGAT", nullable = false, length = 2)
	public String getDispgat() {
		return this.dispgat;
	}

	public void setDispgat(String dispgat) {
		this.dispgat = dispgat;
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
		if (!(other instanceof SggatilhoId))
			return false;
		SggatilhoId castOther = (SggatilhoId) other;

		return (this.getCodobj() == castOther.getCodobj())
				&& ((this.getDispgat() == castOther.getDispgat()) || (this
						.getDispgat() != null && castOther.getDispgat() != null && this
						.getDispgat().equals(castOther.getDispgat())))
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodobj();
		result = 37 * result
				+ (getDispgat() == null ? 0 : this.getDispgat().hashCode());
		result = 37 * result + this.getCodemp();
		return result;
	}

}
