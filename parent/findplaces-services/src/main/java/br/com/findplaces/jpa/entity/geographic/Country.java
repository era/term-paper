package br.com.findplaces.jpa.entity.geographic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.BaseEntity;

@Entity
@Table(name = "TB_COUNTRY")
public class Country extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2901450606350051285L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@OneToMany(mappedBy="country", targetEntity = Region.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Region> regions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

}
