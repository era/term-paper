package br.com.findplaces.jpa.entity.spatial;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.entity.Place;

import com.vividsolutions.jts.geom.Geometry;

@NamedQueries({
	@NamedQuery(name="FindByPointLatLogDistance", query="SELECT u FROM PlaceSpatial u")
})
@Entity
@Table(name = "TB_PLACE_F")
@SequenceGenerator(name = "feature_seq", sequenceName = "feature_id_seq")  
public class PlaceSpatial extends BaseEntity implements Serializable{
	
	public static final String findByPointLatLogDistance = "FindByPointLatLogDistance";
	
	private static final long serialVersionUID = 2203313888884370553L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="feature_seq")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "place_id")
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
