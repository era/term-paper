package br.com.findplaces.jpa.dao.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Place;

public interface PlaceDAO extends BaseDAO<Place, Long> {
	
	List<Place> findAll();

}
