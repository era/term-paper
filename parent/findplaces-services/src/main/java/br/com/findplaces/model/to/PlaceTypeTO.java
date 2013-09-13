package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "placetype")
public class PlaceTypeTO implements Serializable {

	private static final long serialVersionUID = 590328857891269254L;

	@XmlTransient
	private Long id;
	
	@XmlTransient
	private String name;

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

}
