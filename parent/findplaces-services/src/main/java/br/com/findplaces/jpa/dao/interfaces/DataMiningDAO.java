package br.com.findplaces.jpa.dao.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.jpa.entity.datamining.TestAB;

public interface DataMiningDAO extends BaseDAO<PlaceViewed, Long> {
	
	List<PlaceViewed> whoSawThisAlsoSaw(Long placeID, Long userID);
	
	List<PlaceViewed> findPlacesWithSameType(String type, Long userID);
	
	List<PlaceViewed> findPlacesWithSameRelationship(User user);
	
	List<PlaceViewed> findPlacesWithSameStudyAt(User user);
	
	List<PlaceViewed> findPlacesWithSameUserAge(User user);
	
	List<PlaceViewed> findPlacesWithSameLikes(User user);
	
	TestAB saveResultFromTest(TestAB test);

	List<PlaceViewed> getUsersFromPlace(Long placeID);

	List<PlaceViewed> getUsersFromNeighboord(String name);
	
}
