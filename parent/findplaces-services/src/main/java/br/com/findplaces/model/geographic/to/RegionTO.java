package br.com.findplaces.model.geographic.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="region")
public class RegionTO implements Serializable {

	private static final long serialVersionUID = 9210091287956666312L;

	@XmlTransient
	private Long id;

	@XmlTransient
	private String name;
	
	@XmlTransient
	private String alias;

	@XmlTransient
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
