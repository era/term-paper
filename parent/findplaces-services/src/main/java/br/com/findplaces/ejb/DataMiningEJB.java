package br.com.findplaces.ejb;

import java.io.Serializable;
import java.util.List;

import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.Viewed;

public interface DataMiningEJB extends Serializable {
	
	PlaceTO sugestPlaceByUser(UserTO user);
	
	void saveResultFromTest(String algorithm, Integer liked, UserTO user);
	
	void savePlaceViewed(PlaceViewed pv);
	
	List<Viewed> getNeighboordViews(Long id); 
	
	List<Viewed> getPlaceViews(Long id);
	
}
