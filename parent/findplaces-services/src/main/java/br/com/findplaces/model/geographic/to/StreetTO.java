package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="street")
public class StreetTO implements Serializable{

	private static final long serialVersionUID = -2816662858255122569L;

	@XmlTransient
	private Long id;

	@XmlTransient
	private NeighborhoodTO hood;
	
	@XmlTransient
	private String name;

	public Long getId() {
		return id;
	}

	public NeighborhoodTO getHood() {
		return hood;
	}

	public String getStreetName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHood(NeighborhoodTO hood) {
		this.hood = hood;
	}

	public void setStreetName(String streetName) {
		this.name = streetName;
	}

	
}
