package br.com.findplaces.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "place", fetch = FetchType.LAZY)
	@JoinColumn(name = "fid")
	private PlaceSpatial spatial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private Seller seller;

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
	private String code;
	
	@Column
	private String description;
	
	@Column
	private Double price;
	
	@Column
	private Double complexPrice;
	
	@Column
	private Integer room;
	
	@Column
	private Integer bathroom;
	
	@Column
	private Integer bedroom;
	
	@Column
	private Integer suite;
	
	@Column
	private Double m2;
	
	@Column
	private Integer garage;
	
	@OneToMany
	private List<Image> photos;
	

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
	

	public PlaceSpatial getSpatial() {
		return spatial;
	}

	public void setSpatial(PlaceSpatial spatial) {
		this.spatial = spatial;
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

	public Integer getGarage() {
		return garage;
	}

	public void setGarage(Integer garage) {
		this.garage = garage;
	}

	public void setM2(Double m2) {
		this.m2 = m2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Image> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Image> photos) {
		this.photos = photos;
	}

	

}
