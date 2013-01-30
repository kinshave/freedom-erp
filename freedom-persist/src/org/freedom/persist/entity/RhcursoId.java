package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RhcursoId generated by hbm2java
 */
@Embeddable
public class RhcursoId implements java.io.Serializable {

	private int codcurso;
	private short codfilial;
	private int codemp;

	public RhcursoId() {
	}

	public RhcursoId(int codcurso, short codfilial, int codemp) {
		this.codcurso = codcurso;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODCURSO", nullable = false)
	public int getCodcurso() {
		return this.codcurso;
	}

	public void setCodcurso(int codcurso) {
		this.codcurso = codcurso;
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
		if (!(other instanceof RhcursoId))
			return false;
		RhcursoId castOther = (RhcursoId) other;

		return (this.getCodcurso() == castOther.getCodcurso())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodcurso();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
