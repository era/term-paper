package br.com.findeplaces.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "TB_APARTMENT")
public class Apartment extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private Long code;	
	
	@Column
	private Double rentPrice;
	
	@Column
	private Double complexPrice;
	
	@Column
	private Double sellPrice;
	
	@Column
	private Double m2;
	
	@Column
	private Integer garage;
	
	@Column
	private Integer bathRoomNum;
	
	@Column
	private Integer bedRoomNum;
	
	@Column
	private Integer bedRoomSpecialNum;
	
	@Column
	private Point point;
	
	@ManyToOne
	private Seller seller;

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
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

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
