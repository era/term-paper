package br.com.findplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PLACES_IMAGES")
public class PlaceImage extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Place place;
	
	@OneToOne
	private Image image;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
}