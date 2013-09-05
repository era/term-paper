package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

public class StreetTO implements Serializable{

	private Long id;

	private NeighborhoodTO hood;

	public Long getId() {
		return id;
	}

	public NeighborhoodTO getHood() {
		return hood;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHood(NeighborhoodTO hood) {
		this.hood = hood;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	private String streetName;
}
