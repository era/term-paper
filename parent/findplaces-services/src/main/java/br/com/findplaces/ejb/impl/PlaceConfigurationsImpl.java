package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateFilter;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.jpa.dao.interfaces.CityDAO;
import br.com.findplaces.jpa.dao.interfaces.NeighborhoodDAO;
import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.dao.interfaces.StreetDAO;
import br.com.findplaces.jpa.dao.spatial.interfaces.PlaceSpatialDAO;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "PlaceConfigurationsEJB", mappedName = "PlaceConfigurationsImpl")
public class PlaceConfigurationsImpl implements PlaceConfigurations {

	private static final long serialVersionUID = 1L;
	
	public static final int SRID = 4326;

	@EJB
	private PlaceDAO placeDAO;

	@EJB
	private CityDAO cityDAO;

	@EJB
	private StreetDAO streetDAO;

	@EJB
	private NeighborhoodDAO neighDAO;
	
	@EJB
	private PlaceSpatialDAO spatialDAO;

	public PlaceTO createPlace(PlaceTO place) {
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
	public PlaceTO findPlaceById(Long id) {

		try {
			Place place = placeDAO.findById(id);

			if (place == null) {
				// logger.info("Não foi encontrado o usuário "+ id.toString());
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
			// logger.info("Não foi encontrado o usuário "+ id.toString());
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
			// logger.info("Não foi encontrado o usuário "+ id.toString());
		}

		return ConverterTO.converter(neigh);
	}

}
