package br.com.findplaces.model.entities.spatial.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.postgis.Geometry;

import com.vividsolutions.jts.geom.Point;

import br.com.findplaces.model.entities.BaseSpatialEntity;
import br.com.findplaces.model.entities.impl.Apartment;

@Entity
@Table(name = "APARTMENT_F")
public class ApartmentSpatial extends BaseSpatialEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Apartment apartment;
	
	@Column(name = "geometry", columnDefinition="Geometry", nullable = true) 
	private Geometry geometry;

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
}
