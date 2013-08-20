package br.com.findplaces.jpa.dao.impl.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Apartment;

public interface ApartmentDAO extends BaseDAO<Apartment, Long> {
	
	
	List<Apartment> findApartmentByRegion(String region);
	

	
}
