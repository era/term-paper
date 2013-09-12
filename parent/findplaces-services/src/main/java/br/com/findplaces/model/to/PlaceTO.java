package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;

@XmlRootElement(name = "place")
public class PlaceTO implements Serializable {

	private static final long serialVersionUID = -4443449674515309396L;

	private Long id;

	private String address;

	private CityTO city;

	private NeighborhoodTO neighborhood;

	private StreetTO street;

	private PlaceTypeTO type;

	private String description;


	private PlaceSpatialTO spatial;
	
	private SellerTO seller;

	private Double lat;
	
	private Double log;
	
	private PlaceSpatialTO spatialTO;


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

	public CityTO getCity() {
		return city;
	}

	public void setCity(CityTO city) {
		this.city = city;
	}

	public NeighborhoodTO getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(NeighborhoodTO neighborhood) {
		this.neighborhood = neighborhood;
	}

	public StreetTO getStreet() {
		return street;
	}

	public void setStreet(StreetTO street) {
		this.street = street;
	}

	public PlaceTypeTO getType() {
		return type;
	}

	public void setType(PlaceTypeTO type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLog() {
		return log;
	}


	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLog(Double log) {
		this.log = log;
	}

	public PlaceSpatialTO getSpatialTO() {
		return spatialTO;
	}

	public void setSpatialTO(PlaceSpatialTO spatialTO) {
		this.spatialTO = spatialTO;
	}
	

}
