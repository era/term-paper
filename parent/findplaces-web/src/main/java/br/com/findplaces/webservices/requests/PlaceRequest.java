package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;
import br.com.findplaces.model.to.PlaceTypeTO;
import br.com.findplaces.model.to.SellerTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class PlaceRequest implements Serializable {

	private static final long serialVersionUID = 329237857291104899L;

	public static PlaceRequest fromString(String json) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, PlaceRequest.class);
	}

	private Double lat;

	private Double log;

	private String address;

	private CityTO city;

	private NeighborhoodTO neighborhood;

	private StreetTO street;

	private PlaceTypeTO type;

	private String description;

	private PlaceSpatialTO spatial;

	private SellerTO seller;

	public String getAddress() {
		return address;
	}

	public CityTO getCity() {
		return city;
	}

	public NeighborhoodTO getNeighborhood() {
		return neighborhood;
	}

	public StreetTO getStreet() {
		return street;
	}

	public PlaceTypeTO getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public PlaceSpatialTO getSpatial() {
		return spatial;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(CityTO city) {
		this.city = city;
	}

	public void setNeighborhood(NeighborhoodTO neighborhood) {
		this.neighborhood = neighborhood;
	}

	public void setStreet(StreetTO street) {
		this.street = street;
	}

	public void setType(PlaceTypeTO type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSpatial(PlaceSpatialTO spatial) {
		this.spatial = spatial;
	}

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLog() {
		return log;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLog(Double log) {
		this.log = log;
	}

}
