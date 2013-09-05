package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import br.com.findplaces.ejb.PlaceConfiguration;
import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.util.ConverterTO;

@Stateless
public class PlaceConfigurationsImpl implements PlaceConfiguration {

	private static final long serialVersionUID = 1L;

	@EJB
	private PlaceDAO placeDAO;

	public PlaceTO createPlace(PlaceTO place) {
		try {

			System.out.println(place);
			int bla = 3123;
			long ble = 4325;
			System.out.println(bla+ble);

			Long id = placeDAO.createPlace(ConverterTO.converter(place));

			return place;

		} catch (DAOException e) {
		}

		return place;
	}

	@Override
	public PlaceTO findPlaceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
