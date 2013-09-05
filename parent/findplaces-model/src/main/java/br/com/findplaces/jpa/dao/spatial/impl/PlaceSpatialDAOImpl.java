package br.com.findplaces.jpa.dao.spatial.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.dao.spatial.interfaces.PlaceSpatialDAO;
import br.com.findplaces.jpa.entity.spatial.PlaceSpatial;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(PlaceSpatialDAO.class)
public class PlaceSpatialDAOImpl extends BaseSpatialDAOImpl<PlaceSpatial, Long>
		implements Serializable {

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

}
