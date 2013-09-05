package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

public class NeighborhoodTO implements Serializable {

	private Long id;

	private String hoodName;

	private CityTO city;

	public Long getId() {
		return id;
	}

	public String getHoodName() {
		return hoodName;
	}

	public CityTO getCity() {
		return city;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHoodName(String hoodName) {
		this.hoodName = hoodName;
	}

	public void setCity(CityTO city) {
		this.city = city;
	}

}
