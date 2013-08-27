package br.com.findplaces.model.to;

import java.io.Serializable;

public class ApartmentTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String address;

	private String description;
	
	private Long code;

	private Double rentPrice;

	private Double complexPrice;

	private Double sellPrice;

	private Double m2;

	private Integer garage;

	private Integer bathRoomNum;

	private Integer bedRoomNum;

	private Integer bedRoomSpecialNum;
	

	
	private SellerTO seller;

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Double getComplexPrice() {
		return complexPrice;
	}

	public void setComplexPrice(Double complexPrice) {
		this.complexPrice = complexPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getM2() {
		return m2;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public Integer getGarage() {
		return garage;
	}

	public void setGarage(Integer garage) {
		this.garage = garage;
	}

	public Integer getBathRoomNum() {
		return bathRoomNum;
	}

	public void setBathRoomNum(Integer bathRoomNum) {
		this.bathRoomNum = bathRoomNum;
	}

	public Integer getBedRoomNum() {
		return bedRoomNum;
	}

	public void setBedRoomNum(Integer bedRoomNum) {
		this.bedRoomNum = bedRoomNum;
	}

	public Integer getBedRoomSpecialNum() {
		return bedRoomSpecialNum;
	}

	public void setBedRoomSpecialNum(Integer bedRoomSpecialNum) {
		this.bedRoomSpecialNum = bedRoomSpecialNum;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
