package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="neighborhood")
public class NeighborhoodTO implements Serializable {

	private static final long serialVersionUID = 4857989604856875351L;

	@XmlTransient
	private Long id;

	@XmlTransient
	private String name;

	@XmlTransient
	private CityTO city;

	public Long getId() {
		return id;
	}
	

	public CityTO getCity() {
		return city;
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



	public void setCity(CityTO city) {
		this.city = city;
	}

}
