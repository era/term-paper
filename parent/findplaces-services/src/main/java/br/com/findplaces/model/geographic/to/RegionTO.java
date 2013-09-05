package br.com.findplaces.model.geographic.to;

import java.io.Serializable;


public class RegionTO implements Serializable {

	private Long id;

	private String name;

	private CountryTO country;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CountryTO getCountry() {
		return country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(CountryTO country) {
		this.country = country;
	}

}
