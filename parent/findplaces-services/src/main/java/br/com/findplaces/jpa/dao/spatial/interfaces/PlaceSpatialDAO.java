package br.com.findplaces.jpa.dao.spatial.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

public interface PlaceSpatialDAO extends BaseSpatialDAO<PlaceSpatial, Long> {
	
	List<PlaceSpatial> findPlaceByLatLogDistance(Double lat, Double log, Double distance);

	List<PlaceSpatial> findPlaceByFilterBasic();

}
