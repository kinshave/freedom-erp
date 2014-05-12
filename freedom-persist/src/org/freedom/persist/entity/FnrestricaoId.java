package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FnrestricaoId generated by hbm2java
 */
@Embeddable
public class FnrestricaoId implements java.io.Serializable {

	private int codcli;
	private short seqrestr;
	private short codfilial;
	private int codemp;

	public FnrestricaoId() {
	}

	public FnrestricaoId(int codcli, short seqrestr, short codfilial, int codemp) {
		this.codcli = codcli;
		this.seqrestr = seqrestr;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODCLI", nullable = false)
	public int getCodcli() {
		return this.codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}

	@Column(name = "SEQRESTR", nullable = false)
	public short getSeqrestr() {
		return this.seqrestr;
	}

	public void setSeqrestr(short seqrestr) {
		this.seqrestr = seqrestr;
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
		if (!(other instanceof FnrestricaoId))
			return false;
		FnrestricaoId castOther = (FnrestricaoId) other;

		return (this.getCodcli() == castOther.getCodcli())
				&& (this.getSeqrestr() == castOther.getSeqrestr())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodcli();
		result = 37 * result + this.getSeqrestr();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
