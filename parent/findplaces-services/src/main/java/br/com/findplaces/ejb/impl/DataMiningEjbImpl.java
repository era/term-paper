package br.com.findplaces.ejb.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.findplaces.commons.helpers.MapReduceHelper;
import br.com.findplaces.ejb.DataMiningEJB;
import br.com.findplaces.jpa.dao.interfaces.DataMiningDAO;
import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.CountPlaceViewedTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "DataMiningEJB", mappedName = "DataMining")
@Remote(DataMiningEJB.class)
public class DataMiningEjbImpl implements DataMiningEJB {
	
	private static final long serialVersionUID = 2910805335687356463L;
	
	@EJB
	private DataMiningDAO dao;
	

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
		List<CountPlaceViewedTO> response = new ArrayList<CountPlaceViewedTO>();
		try{
			List<PlaceViewed> neighboord = dao.getUsersFromNeighboord(name);
			HashMap<Object, Integer> reduce = new HashMap<Object,Integer>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			for(PlaceViewed place : neighboord){
				String key = dateFormat.format(place.getDate());
				MapReduceHelper.addOrIncrease(reduce, key);
			}
			
			//FIXME this should't be here		
			for(Object key :reduce.keySet()){
				CountPlaceViewedTO viewedTO = new CountPlaceViewedTO();
				viewedTO.setViewedDate(dateFormat.parse(key.toString()));
				viewedTO.setViewedObject(reduce.get(key));
				response.add(viewedTO);
			}
		}catch(Exception e){
			//FIXME
		}
		
		return response;
	}

	@Override
	public List<CountPlaceViewedTO> getPlaceViews(Long id) {
		List<CountPlaceViewedTO> response = new ArrayList<CountPlaceViewedTO>();
		try{
			List<PlaceViewed> neighboord = dao.getUsersFromPlace(id);
			HashMap<Object, Integer> reduce = new HashMap<Object,Integer>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			for(PlaceViewed place : neighboord){
				String key = dateFormat.format(place.getDate());
				MapReduceHelper.addOrIncrease(reduce, key);
			}
			
			//FIXME this should't be here		
			for(Object key :reduce.keySet()){
				CountPlaceViewedTO viewedTO = new CountPlaceViewedTO();
				viewedTO.setViewedDate(dateFormat.parse(key.toString()));
				viewedTO.setViewedObject(reduce.get(key));
				response.add(viewedTO);
			}
		}catch(Exception e){
			//FIXME
		}
		
		return response;
	}

	@Override
	public PlaceTO sugestPlaceByAge(UserTO user) {
		PlaceTO place = null;
		try{
			List<PlaceViewed> placesViewed = dao.findPlacesWithSameUserAge(ConverterTO.converter(user));
			if(placesViewed!=null && !placesViewed.isEmpty()){
				place = placesViewed.get(0).getPlace()!=null 
						? ConverterTO.converter(placesViewed.get(0).getPlace())
								:null;
				
			}
		} catch(Exception e){
			//FIXME
		}
		return place;
	}

	@Override
	public PlaceTO sugestPlaceByLikesFromUser(UserTO user) {
		PlaceTO place = null;
		try{
			List<PlaceViewed> placesViewed = dao.findPlacesWithSameLikes(ConverterTO.converter(user));
			if(placesViewed!=null && !placesViewed.isEmpty()){
				place = placesViewed.get(0).getPlace()!=null 
						? ConverterTO.converter(placesViewed.get(0).getPlace())
								:null;
				
			}
		} catch(Exception e){
			//FIXME
		}
		return place;
	}
	
	@Override
	public PlaceTO sugestPlaceByUser(UserTO user,Long placeID) {
		PlaceTO place = null;
		try{
			List<PlaceViewed> placesViewed = dao.whoSawThisAlsoSaw(placeID, user.getId());
			if(placesViewed!=null && !placesViewed.isEmpty()){
				place = placesViewed.get(0).getPlace()!=null 
						? ConverterTO.converter(placesViewed.get(0).getPlace())
								:null;
				
			}
		} catch(Exception e){
			//FIXME
		}
		return place;
	}

}
