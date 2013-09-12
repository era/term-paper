package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.geographic.Neighborhood;

public interface NeighborhoodDAO extends BaseDAO<Neighborhood, Long> {
	
	
	Neighborhood findByName(String name);

}
