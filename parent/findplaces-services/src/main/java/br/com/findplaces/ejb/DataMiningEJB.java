package br.com.findplaces.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.model.to.CountPlaceViewedTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.Viewed;

public interface DataMiningEJB extends Serializable {
	
	PlaceTO sugestPlaceByUser(UserTO user, Long placeID);
	
	PlaceTO sugestPlaceByAge(UserTO user);
	
	PlaceTO sugestPlaceByLikesFromUser(UserTO user);
	
	void saveResultFromTest(String algorithm, Integer liked, UserTO user);
	
	void savePlaceViewed(PlaceViewed pv);
	
	List<CountPlaceViewedTO> getNeighboordViews(String name); 
	
	List<CountPlaceViewedTO> getPlaceViews(Long id);
	
	Map<Integer,Double> getAgeFromUsers(Long placeID);
	
	Map<String,Double> getLikesFromUsers(Long placeID);
	
}
