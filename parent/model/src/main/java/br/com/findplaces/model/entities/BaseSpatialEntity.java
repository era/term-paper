package br.com.findplaces.model.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseSpatialEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	protected Long fid;

	@Column(name = "version")
	@Version
	private Long version;

	public Long getFid() {
		return fid;
	}

	public Long getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getFid() != null ? this.getFid().hashCode() : 0);

		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		BaseSpatialEntity other = (BaseSpatialEntity) object;
		if (this.getFid() != other.getFid()
				&& (this.getFid() == null || !this.fid.equals(other.fid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [FID=" + fid + "]";
	}

}
