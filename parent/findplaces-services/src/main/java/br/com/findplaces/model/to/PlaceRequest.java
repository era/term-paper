package br.com.findplaces.model.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class PlaceRequest implements Serializable {

	private static final long serialVersionUID = 329237857291104899L;

	public static PlaceRequest fromString(String json) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, PlaceRequest.class);
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
	
	private Long userID;

	private PlaceSpatialTO spatial;

	private StreetTO street;

	private Integer suite;
	
	private String token;
	
	private List<Long> sellType;

	public String getToken() {
		return token;
	}

	public String getSocialid() {
		return socialid;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLog() {
		return log;
	}

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

	public PlaceTypeTO getPlacetype() {
		return placetype;
	}

	public String getDescription() {
		return description;
	}

	public PlaceSpatialTO getSpatial() {
		return spatial;
	}

	public SellerTO getSeller() {
		return seller;
	}

	public String getCode() {
		return code;
	}

	public Double getPrice() {
		return price;
	}

	public Double getComplexPrice() {
		return complexPrice;
	}

	public Integer getRoom() {
		return room;
	}

	public Integer getBathroom() {
		return bathroom;
	}

	public Integer getBedroom() {
		return bedroom;
	}

	public Integer getSuite() {
		return suite;
	}

	public Double getM2() {
		return m2;
	}

	public Integer getGarage() {
		return garage;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setSocialid(String socialid) {
		this.socialid = socialid;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLog(Double log) {
		this.log = log;
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

	public void setPlacetype(PlaceTypeTO placetype) {
		this.placetype = placetype;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSpatial(PlaceSpatialTO spatial) {
		this.spatial = spatial;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setComplexPrice(Double complexPrice) {
		this.complexPrice = complexPrice;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public void setBathroom(Integer bathroom) {
		this.bathroom = bathroom;
	}

	public void setBedroom(Integer bedroom) {
		this.bedroom = bedroom;
	}

	public void setSuite(Integer suite) {
		this.suite = suite;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public void setGarage(Integer garage) {
		this.garage = garage;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public List<Long> getSellType() {
		return sellType;
	}

	public void setSellType(List<Long> sellType) {
		this.sellType = sellType;
	}
	
}
