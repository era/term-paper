package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class FilterSearchRequest implements Serializable {

	private static final long serialVersionUID = -5508737983115479710L;

	public static FilterSearchRequest fromString(String json) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, FilterSearchRequest.class);
	}

	private Double weightSellType;

	private Double weightPlaceType;

	private Double weightPrice;

	private Double weightNeiborhood;

	private Double weightDistance;

	private Double weightBedroom;

	private Double weightGarage;
	
	private Long placeType;

	private Integer bathroom;

	private Integer bedroom;

	private String code;

	private Double complexPrice;

	private String description;

	private Integer garage;

	private Double lat;

	private Double lng;

	private Double m2;

	private Double priceMin;
	
	private Double priceMax;

	private Integer room;

	private SellerTO seller;

	private String socialid;

	private Integer suite;

	private String token;

	private Long sellType;
	
	private String neibohoord;
	
	private Double distance;

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

	public Double getWeightSellType() {
		return weightSellType;
	}

	public void setWeightSellType(Double weightSellType) {
		this.weightSellType = weightSellType;
	}

	public Double getWeightPlaceType() {
		return weightPlaceType;
	}

	public void setWeightPlaceType(Double weightPlaceType) {
		this.weightPlaceType = weightPlaceType;
	}

	public Double getWeightPrice() {
		return weightPrice;
	}

	public void setWeightPrice(Double weightPrice) {
		this.weightPrice = weightPrice;
	}

	public Double getWeightNeiborhood() {
		return weightNeiborhood;
	}

	public void setWeightNeiborhood(Double weightNeiborhood) {
		this.weightNeiborhood = weightNeiborhood;
	}

	public Double getWeightDistance() {
		return weightDistance;
	}

	public void setWeightDistance(Double weightDistance) {
		this.weightDistance = weightDistance;
	}

	public Double getWeightBedroom() {
		return weightBedroom;
	}

	public void setWeightBedroom(Double weightBedroom) {
		this.weightBedroom = weightBedroom;
	}

	public Double getWeightGarage() {
		return weightGarage;
	}

	public void setWeightGarage(Double weightGarage) {
		this.weightGarage = weightGarage;
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

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getM2() {
		return m2;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
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

	public Long getSellType() {
		return sellType;
	}

	public void setSellType(Long sellType) {
		this.sellType = sellType;
	}

	public Long getPlaceType() {
		return placeType;
	}

	public void setPlaceType(Long placeType) {
		this.placeType = placeType;
	}

	public String getNeibohoord() {
		return neibohoord;
	}

	public void setNeibohoord(String neibohoord) {
		this.neibohoord = neibohoord;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}
