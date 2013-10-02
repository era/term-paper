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
public class FilterSearchRequest implements Serializable {

	private static final long serialVersionUID = -5508737983115479710L;
	
	
	public static FilterSearchRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, FilterSearchRequest.class);
	}
	
	private String address;

	private Integer bathroom;

	private Integer bedroom;

	private CityTO city;

	private String code;

	private Double complexPrice;

	private String description;

	private Integer garage;

	private Double lat;

	private Double log;

	private Double m2;

	private NeighborhoodTO neighborhood;

	private PlaceTypeTO placetype;

	private Double price;

	private Integer room;

	private SellerTO seller;

	private String socialid;

	private PlaceSpatialTO spatial;

	private StreetTO street;

	private Integer suite;
	
	private String token;


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBathroom() {
		return bathroom;
	}

	public void setBathroom(Integer bathroom) {
		this.bathroom = bathroom;
	}

	public Integer getBedroom() {
		return bedroom;
	}

	public void setBedroom(Integer bedroom) {
		this.bedroom = bedroom;
	}

	public CityTO getCity() {
		return city;
	}

	public void setCity(CityTO city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getComplexPrice() {
		return complexPrice;
	}

	public void setComplexPrice(Double complexPrice) {
		this.complexPrice = complexPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGarage() {
		return garage;
	}

	public void setGarage(Integer garage) {
		this.garage = garage;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLog() {
		return log;
	}

	public void setLog(Double log) {
		this.log = log;
	}

	public Double getM2() {
		return m2;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public NeighborhoodTO getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(NeighborhoodTO neighborhood) {
		this.neighborhood = neighborhood;
	}

	public PlaceTypeTO getPlacetype() {
		return placetype;
	}

	public void setPlacetype(PlaceTypeTO placetype) {
		this.placetype = placetype;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public String getSocialid() {
		return socialid;
	}

	public void setSocialid(String socialid) {
		this.socialid = socialid;
	}

	public PlaceSpatialTO getSpatial() {
		return spatial;
	}

	public void setSpatial(PlaceSpatialTO spatial) {
		this.spatial = spatial;
	}

	public StreetTO getStreet() {
		return street;
	}

	public void setStreet(StreetTO street) {
		this.street = street;
	}

	public Integer getSuite() {
		return suite;
	}

	public void setSuite(Integer suite) {
		this.suite = suite;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
