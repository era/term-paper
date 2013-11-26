package br.com.findplaces.model.to;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
	
	private FacilitiesTO facilities;
	
	private String address;

	private Integer bathroom;

	private Integer bedroom;

	private CityTO city;

	private String code;

	private Double complexPrice;

	private String description;

	private Integer garage;

	private Double lat;

	private Double lng;

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
	
	private Double deposit;
	
	private Integer rentMonths;
	
	private Integer placeFloor;
	
	private Integer qtdPlaceFloor;
	
	private Double iptu;
	
	private Double totalPrice;
	
	private String cellphone;
	
	private String cellphone2;
	
	private Double rent;
	
	private Integer contract_time;
	
	private Double internet;
	
	private Double tv;
	
	private Double condominiumPrice;
	
	private List<Long> idImages;

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
		return lng;
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

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Integer getRentMonths() {
		return rentMonths;
	}

	public void setRentMonths(Integer rentMonths) {
		this.rentMonths = rentMonths;
	}

	public Integer getPlaceFloor() {
		return placeFloor;
	}

	public void setPlaceFloor(Integer placeFloor) {
		this.placeFloor = placeFloor;
	}

	public Integer getQtdPlaceFloor() {
		return qtdPlaceFloor;
	}

	public void setQtdPlaceFloor(Integer qtdPlaceFloor) {
		this.qtdPlaceFloor = qtdPlaceFloor;
	}

	public Double getIptu() {
		return iptu;
	}

	public void setIptu(Double iptu) {
		this.iptu = iptu;
	}
	

//	public Double getInternet() {
//		return internet;
//	}
//
//	public void setInternet(Double internet) {
//		this.internet = internet;
//	}

//	public Double getTv() {
//		return tv;
//	}
//
//	public void setTv(Double tv) {
//		this.tv = tv;
//	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCellphone2() {
		return cellphone2;
	}

	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
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

	public void setLog(Double lng) {
		this.lng = lng;
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

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Integer getContract_time() {
		return contract_time;
	}

	public Double getCondominiumPrice() {
		return condominiumPrice;
	}

	public void setCondominiumPrice(Double condominiumPrice) {
		this.condominiumPrice = condominiumPrice;
	}

	public void setContract_time(Integer contract_time) {
		this.contract_time = contract_time;
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

	public FacilitiesTO getFacilities() {
		return facilities;
	}

	public void setFacilities(FacilitiesTO facilities) {
		this.facilities = facilities;
	}

	public Double getInternet() {
		return internet;
	}

	public void setInternet(Double internet) {
		this.internet = internet;
	}

	public Double getTv() {
		return tv;
	}

	public void setTv(Double tv) {
		this.tv = tv;
	}

	public List<Long> getIdImages() {
		return idImages;
	}

	public void setIdImages(List<Long> idImages) {
		this.idImages = idImages;
	}
	
}
