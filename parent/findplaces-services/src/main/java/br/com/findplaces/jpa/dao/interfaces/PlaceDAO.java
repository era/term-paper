package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.exception.DAOException;

public interface PlaceDAO extends BaseDAO<Place, Long> {

	Long createPlaceTest(Place entity) throws DAOException;

}
