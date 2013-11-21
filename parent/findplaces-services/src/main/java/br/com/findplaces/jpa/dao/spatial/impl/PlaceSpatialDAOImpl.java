package br.com.findplaces.jpa.dao.spatial.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.spatial.interfaces.PlaceSpatialDAO;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(PlaceSpatialDAO.class)
public class PlaceSpatialDAOImpl extends BaseSpatialDAOImpl<PlaceSpatial, Long>
		implements Serializable, PlaceSpatialDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4160579997091589127L;

	@Resource
	@PersistenceContext(unitName = "FindPlaces")
	private EntityManager emSpatial;

	@Override
	public EntityManager getEntitySpatialManager() {
		return emSpatial;
	}

	@Override
	public void setEntitySpatialManager(EntityManager emSpatial) {
		this.emSpatial = emSpatial;
	}

	@Override
	public List<PlaceSpatial> findPlaceByLatLogDistance(Double lat, Double log,
			Double distance) {
		List<PlaceSpatial> places = new ArrayList<PlaceSpatial>();	
		String sql = "SELECT * FROM tb_place_f s WHERE ST_DWithin(Geography(s.geom), Geography(ST_MakePoint(?, ?, 4326)), ?)";
		Query query = getEntitySpatialManager().createNativeQuery(sql, PlaceSpatial.class);				
		query.setParameter(1, lat);
		query.setParameter(2, log);
		query.setParameter(3, distance);
		List<PlaceSpatial> resultList = query.getResultList();
		

		if (resultList.isEmpty()) {
			return null;
		} else {
			places.addAll(resultList);
			return places;
		}
	}
	
	
	
	@Override
	public List<PlaceSpatial> findPlaceByFilterBasic() {
		//FIX FILTRO BASICO
		List<PlaceSpatial> places = new ArrayList<PlaceSpatial>();	
		String sql = "SELECT * FROM tb_place_f s WHERE ST_DWithin(Geography(s.geom), Geography(ST_MakePoint(?, ?, 4326)), ?)";
		Query query = getEntitySpatialManager().createNativeQuery(sql, PlaceSpatial.class);				
	
		List<PlaceSpatial> resultList = query.getResultList();

		if (resultList.isEmpty()) {
			return null;
		} else {
			places.addAll(resultList);
			return places;
		}
	}

}
