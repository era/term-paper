package br.com.findplaces.jpa.dao.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findplaces.jpa.dao.interfaces.PlaceDAO;
import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.PlaceType;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Country;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Region;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.jpa.exception.DAOException;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(PlaceDAO.class)
public class PlaceDAOImpl extends BaseDAOImpl<Place, Long> implements PlaceDAO {

	private static final long serialVersionUID = -2569793427518741401L;

	@Resource
	@PersistenceContext(unitName = "FindPlaces")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;

	}


}
