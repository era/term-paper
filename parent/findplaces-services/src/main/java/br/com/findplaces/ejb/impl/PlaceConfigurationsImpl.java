package br.com.findplaces.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.jpa.dao.interfaces.CityDAO;
import br.com.findplaces.jpa.dao.interfaces.FacilitiesDAO;
import br.com.findplaces.jpa.dao.interfaces.NeighborhoodDAO;
import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.dao.interfaces.RegionDAO;
import br.com.findplaces.jpa.dao.interfaces.StreetDAO;
import br.com.findplaces.jpa.dao.spatial.interfaces.PlaceSpatialDAO;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.SellType;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Region;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;
import br.com.findplaces.model.to.FilterSearchRequest;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.util.ConverterTO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

@Stateless(name = "PlaceConfigurationsEJB", mappedName = "PlaceConfigurationsImpl")
public class PlaceConfigurationsImpl implements PlaceConfigurations {

	private static final Logger logger = Logger
			.getLogger(PlaceConfigurationsImpl.class);

	private static final long serialVersionUID = 1L;

	public static final int SRID = 4326;

	@EJB
	private CityDAO cityDAO;

	@EJB
	private FacilitiesDAO facilitiesDAO;

	@EJB
	private NeighborhoodDAO neighDAO;

	@EJB
	private PlaceDAO placeDAO;

	@EJB
	private PlaceSpatialDAO spatialDAO;

	@EJB
	private StreetDAO streetDAO;

	@EJB
	private RegionDAO regionDAO;

	public PlaceTO createPlace(PlaceTO place) { //FIXME Should not convert and create in the same method!
		try {

			Double lat = place.getLat();
			Double log = place.getLog();
			GeometryFactory geoFactory = new GeometryFactory();
			Coordinate coord = new Coordinate();
			coord.x = lat;
			coord.y = log;
			Point point = geoFactory.createPoint(coord);
			point.setSRID(SRID);

			place.setSpatialTO(new PlaceSpatialTO());
			place.getSpatialTO().setGeom(point);
			place.getSpatialTO().setLat(lat);
			place.getSpatialTO().setLon(log);
			place.getSpatialTO().setPlace(place);

			String alias = place.getCity().getRegion().getAlias();
			Region region = regionDAO.findByAlias(alias);

			

			City city = cityDAO.findByName(place.getCity().getName());
			if (city == null) {
				place.getCity().setRegion(ConverterTO.converter(region));
				Long cityID = cityDAO.create(ConverterTO.converter(place.getCity()));
				city = cityDAO.findById(cityID);
			}

			Neighborhood neigh = neighDAO.findByName(place.getNeighborhood().getName());
			if(neigh == null){				
				place.getNeighborhood().setCity(ConverterTO.converter(city));
				Long neighID = neighDAO.create(ConverterTO.converter(place.getNeighborhood()));
				neigh = neighDAO.findById(neighID);				
			}

			Street street = streetDAO.findByName(place.getStreet().getStreetName());
			if(street == null){
				place.getStreet().setHood(ConverterTO.converter(neigh));
				Long streetID = streetDAO.create(ConverterTO.converter(place.getStreet()));
				street = streetDAO.findById(streetID);
			}
			
			place.setCity(ConverterTO.converter(city));
			place.setNeighborhood(ConverterTO.converter(neigh));
			place.setStreet(ConverterTO.converter(street));
			
			ArrayList<SellType> sellTypes = new ArrayList<SellType>();
			for(Long sellType : place.getSellType()){
				SellType type = new SellType();
				type.setId(sellType);
				
				sellTypes.add(type);
			}

			Long id = placeDAO.create(ConverterTO.converter(place));
			PlaceSpatialTO spatialTO = place.getSpatialTO();
			spatialTO.setPlace(findPlaceById(id));
			Long fid = spatialDAO.create(ConverterTO.converter(spatialTO));

			return this.findPlaceById(id);
		} catch (DAOException e) {

		}
		return place;
	}

	@Override
	public List<PlaceTO> findPlaceByLatLogDistance(Double lat, Double log,
			Double distance) {

		List<Place> places = spatialDAO.findPlaceByLatLogDistance(lat, log,
				distance);

		if (places == null) {
			logger.info("Não foi encontrado o lugar pela latitude e longitude ");
			return null;
		}

		List<PlaceTO> placesTO = new ArrayList<PlaceTO>();
		for (Place place : places) {
			PlaceTO to = ConverterTO.converter(place);
			placesTO.add(to);
		}

		return placesTO;
	}

	@Override
	public PlaceTO findPlaceById(Long id) {

		try {
			Place place = placeDAO.findById(id);

			if (place == null) {
				logger.info("Não foi encontrado o usuário " + id.toString());
			}

			return ConverterTO.converter(place);

		} catch (DAOException e) {
			// logger.error(e);
		}
		return null;
	}

	@Override
	public CityTO findCityByName(String name) {

		City city = cityDAO.findByName(name);

		if (city == null) {
			logger.info("Não foi encontrado o usuário ");
		}

		return ConverterTO.converter(city);
	}

	@Override
	public StreetTO findStreetByName(String name) {
		Street street = streetDAO.findByName(name);

		if (street == null) {
			// logger.info("Não foi encontrado o usuário "+ id.toString());
		}

		return ConverterTO.converter(street);
	}

	@Override
	public NeighborhoodTO findNeighborhoodByName(String name) {
		Neighborhood neigh = neighDAO.findByName(name);

		if (neigh == null) {
			logger.info("Não foi encontrado o usuário ");
		}

		return ConverterTO.converter(neigh);
	}

	/**
	 * This method is very slow, but when it comes so slow that we can use any more
	 * we will have to change to MapReduce design pattern.
	 */
	@Override
	public List<PlaceTO> findByFilter(FilterSearchRequest filter) {
		
		List<Place> allPlaces = placeDAO.findAll();
		
		List<PlaceTO> placesMatchedWithUser = new ArrayList<PlaceTO>();
		//FIXME OMG, how many ifs inside ifs are there? D:
		for(Place place : allPlaces){
			Double points = 0d;
			Integer numberOfFilters = 0;
			if(filter.getSellType() != null){
				numberOfFilters++;
				if(place.getSellType().indexOf(filter.getSellType()) != -1){
					points += filter.getWeightSellType();
				}
			}
			if(filter.getPlaceType()!=null){
				numberOfFilters++;
				if(filter.getPlaceType().equals(place.getType().getId())){
					points += filter.getWeightPlaceType();
				}
			}
			
			if(filter.getPriceMax()!=null && filter.getPriceMin() != null){
				numberOfFilters++;
				if(filter.getPriceMax() >= place.getPrice() && filter.getPriceMin() <= place.getPrice()){
					points+= filter.getWeightPrice();
				}
			}
			
			if(filter.getNeibohoord()!=null){
				numberOfFilters++;
				if(filter.getNeibohoord().equals(place.getNeighborhood().getHoodName())){
					points+=filter.getWeightNeiborhood();
				}
			}
			
			if(filter.getDistance()!=null){
				//numberOfFilters++;
				//How we get the distance from here? :(
			}
			
			if(filter.getBedroom()!=null){
				numberOfFilters++;
				if(filter.getBedroom().equals(place.getBedroom())){
					points += filter.getWeightBedroom();
				}
			}
			
			if(filter.getGarage()!=null){
				 numberOfFilters++;
				 if(filter.getGarage().equals(place.getGarage())){
					 points += filter.getWeightGarage();
				 }
			}
			
			if( (points / numberOfFilters) > 0.3 ){
				placesMatchedWithUser.add(ConverterTO.converter(place));
			}
		}
		
		
		return placesMatchedWithUser;
	}

}
