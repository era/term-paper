package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

public class CityTO implements Serializable {

	private Long id;

	private String name;

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
