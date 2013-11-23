package br.com.findplaces.jpa.dao.interfaces;

import java.util.List;

import br.com.findplaces.jpa.entity.Coment;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

public interface PlaceDAO extends BaseDAO<Place, Long> {
	
	List<Place> findAll();
	
	Place save(Coment coment);
	
	Coment findComentById(Long id);
	
	Place findBySpatial(PlaceSpatial spatial);
	
	List<Place> findByUserID(Long id);

}
