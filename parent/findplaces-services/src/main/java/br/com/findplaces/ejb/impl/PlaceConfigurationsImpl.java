package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "PlaceConfigurationsEJB", mappedName = "PlaceConfigurationsImpl")
public class PlaceConfigurationsImpl implements PlaceConfigurations {

	private static final long serialVersionUID = 1L;

	@EJB
	private PlaceDAO placeDAO;

	public PlaceTO createPlace(PlaceTO place) {
//		try {
			
//			Long id = placeDAO.createPlaceTest(ConverterTO.converter(place));

			return place;

//		} catch (DAOException e) {
//			e.printStackTrace();
//		}

//		return place;
	}

	@Override
	public PlaceTO findPlaceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
