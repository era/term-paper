package br.com.findplaces.model.to;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="place")
public class PlaceTO implements Serializable {

	private static final long serialVersionUID = -4443449674515309396L;
	
	private SellerTO seller;
	
	private String latitude;
	
	private String longitude;
	
	private String price;
	
	private Integer qtyRooms;
	
	private String description;
	
	private List<PhotoTO> photos;
	
	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getQtyRooms() {
		return qtyRooms;
	}

	public void setQtyRooms(Integer qtyRooms) {
		this.qtyRooms = qtyRooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PhotoTO> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoTO> photos) {
		this.photos = photos;
	}

	public Integer getQtyBathrooms() {
		return qtyBathrooms;
	}

	public void setQtyBathrooms(Integer qtyBathrooms) {
		this.qtyBathrooms = qtyBathrooms;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	private Integer qtyBathrooms;
	
	private Integer size;

}
