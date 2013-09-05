package br.com.findplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

@Entity
@Table(name = "TB_PLACE")
public class Place extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String address;
	
	@ManyToOne
	private City city;

	@ManyToOne
	private Neighborhood neighborhood;

	@ManyToOne
	private Street street;

	@ManyToOne
	private PlaceType type;
	
	@Column
	private String description;
	
	@OneToOne
	private PlaceSpatial spatial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public PlaceType getType() {
		return type;
	}

	public void setType(PlaceType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
