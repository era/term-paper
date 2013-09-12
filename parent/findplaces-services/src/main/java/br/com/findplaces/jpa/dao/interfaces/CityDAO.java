package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.geographic.City;

public interface CityDAO extends BaseDAO<City, Long> {
	
	City findByName(String name);

}