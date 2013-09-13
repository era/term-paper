package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="city")
public class CityTO implements Serializable {

	private static final long serialVersionUID = 3983833284361662445L;

	private Long id;

	private String name;

	@XmlTransient
	private RegionTO region;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public RegionTO getRegion() {
		return region;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegion(RegionTO region) {
		this.region = region;
	}

}
