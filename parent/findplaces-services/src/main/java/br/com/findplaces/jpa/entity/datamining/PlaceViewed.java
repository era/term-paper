package br.com.findplaces.jpa.entity.datamining;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.User;


@NamedQueries({
	@NamedQuery(name="WhoSawThisAlsoSaw", query="SELECT pv FROM PlaceViewed pv where pv.place.id IN (SELECT pv2.place.id FROM PlaceViewed pv2 WHERE " +
			"pv2.user.id IN (SELECT pv.user.id from PlaceViewed pv3 where pv3.user.id != :userID AND pv3.place.id = :placeID) )"),
	@NamedQuery(name="FindPlacesWithSameType", query="SELECT pv FROM PlaceViewed pv where pv.user.id != :userID and pv.place.type = :type"),
	@NamedQuery(name="FindPlacesWithSameUserAge", query="SELECT pv FROM PlaceViewed pv where pv.user.id != :userID and pv.user.age = :age"),
	@NamedQuery(name="FindPlacesWithSameRelationship", query="SELECT pv FROM PlaceViewed pv where pv.user.id != :userID and pv.user.relationship = :relantionship"),
	@NamedQuery(name="FindPlacesWithSameStudyAt", query="SELECT pv FROM PlaceViewed pv where pv.user.id != :userID and pv.user.studyAt = :studyAt"),
	@NamedQuery(name=PlaceViewed.findViewsByPlace, query="SELECT pv FROM PlaceViewed pv where pv.place.id = :placeID"),	
	@NamedQuery(name=PlaceViewed.findPlacesByLike, query="SELECT pv FROM PlaceViewed pv where pv.user.likes IN (SELECT pv2.user.likes FROM PlaceViewed pv2 WHERE " +
			"pv2.user.id = :userID )")
})
@Entity
@Table(name="TB_PLACE_USER_DM")
public class PlaceViewed extends BaseEntity {

	private static final long serialVersionUID = -2815321876732559697L;
	
	public static final String whoSawThisAlsoSaw = "WhoSawThisAlsoSaw";
	
	public static final String findPlacesWithSameType = "FindPlacesWithSameType";
	
	public static final String findPlacesWithSameUserAge = "FindPlacesWithSameUserAge";
	
	public static final String findPlacesWithSameRelationship = "FindPlacesWithSameRelationship";
	
	public static final String findPlacesWithSameStudyAt = "FindPlacesWithSameStudyAt";
	
	public static final String findViewsByPlace = "findViewByPlaces";
	
	public static final String findViewsByNeighborhood ="findViewsByNeighborhood"; 
	
	public static final String findPlacesByLike = "findplacesByLike";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Place place;
	
	@OneToOne
	private User user;
	
	@Column
	private Date date;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
