package br.com.findplaces.ejb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.DataMiningEJB;
import br.com.findplaces.jpa.dao.interfaces.DataMiningDAO;
import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.CountPlaceViewedTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;

@Stateless(name = "DataMiningEJB", mappedName = "DataMining")
@Remote(DataMiningEJB.class)
public class DataMiningEjbImpl implements DataMiningEJB {
	
	private static final long serialVersionUID = 2910805335687356463L;
	
	@EJB
	private DataMiningDAO dao;
	

	@Override
	public PlaceTO sugestPlaceByUser(UserTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveResultFromTest(String algorithm, Integer liked, UserTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlaceViewed(PlaceViewed pv) {
		try {
			dao.save(pv);
		} catch (DAOException e) {
			//FIXME
		}
	}

	@Override
	public Map<Integer, Double> getAgeFromUsers(Long placeID) {
		List<PlaceViewed> views = dao.getUsersFromPlace(placeID);
		HashMap<Integer, Double> ageFromUsers = new HashMap<Integer, Double>();
		
		for(PlaceViewed place : views ){
			if(place.getUser()!=null){
				Integer age = Integer.valueOf(place.getUser().getAge());
				if(ageFromUsers.containsKey(age)){
					Double count = ageFromUsers.get(age);
					ageFromUsers.put(age,count++);
				} else {
					ageFromUsers.put(age,1d);
				}
			}
		}
		
		return ageFromUsers;
	}

	@Override
	public Map<String, Double> getLikesFromUsers(Long placeID) {
		List<PlaceViewed> views = dao.getUsersFromPlace(placeID);
		
		Map<String,Double> map = new HashMap<String,Double>();
		
		for(PlaceViewed place : views ){
			if(place.getUser()!=null){
				setLikesFromUser(map, place);
			}
		}
		return map;
	}

	private void setLikesFromUser(Map<String, Double> map, PlaceViewed place) {
		if(place.getUser().getLikes()!=null) {
			for(Likes like : place.getUser().getLikes()){
				String name = like.getName();
				if(map.containsKey(name)){
					Double count = map.get(name);
					map.put(name, count++);
				} else {
					map.put(name, 1d);
				}
			}
		}
	}

	@Override
	public List<CountPlaceViewedTO> getNeighboordViews(String name) {
		dao.getUsersFromNeighboord(name);
		return null;
	}

	@Override
	public List<CountPlaceViewedTO> getPlaceViews(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
