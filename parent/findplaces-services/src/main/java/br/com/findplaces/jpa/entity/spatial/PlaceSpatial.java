package br.com.findplaces.jpa.entity.spatial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.entity.Place;

import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name = "TB_PLACE_F")
public class PlaceSpatial extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2203313888884370553L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Place place;
	
	@Column
	@Type(type="org.hibernate.spatial.GeometryType")
	private Geometry geom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Geometry getGeom() {
		return geom;
	}

	public void setGeom(Geometry geom) {
		this.geom = geom;
	}

}
