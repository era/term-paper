package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.jpa.dao.interfaces.CityDAO;
import br.com.findplaces.jpa.dao.interfaces.NeighborhoodDAO;
import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.dao.interfaces.StreetDAO;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "PlaceConfigurationsEJB", mappedName = "PlaceConfigurationsImpl")
public class PlaceConfigurationsImpl implements PlaceConfigurations {

	private static final long serialVersionUID = 1L;

	@EJB
	private PlaceDAO placeDAO;

	@EJB
	private CityDAO cityDAO;

	@EJB
	private StreetDAO streetDAO;

	@EJB
	private NeighborhoodDAO neighDAO;

	public PlaceTO createPlace(PlaceTO place) {
		try {
			// TODO Encrypt password
			Long id = placeDAO.create(ConverterTO.converter(place));
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
