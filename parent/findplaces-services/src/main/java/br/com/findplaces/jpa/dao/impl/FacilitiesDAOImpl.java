package br.com.findplaces.jpa.dao.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findplaces.jpa.dao.interfaces.FacilitiesDAO;
import br.com.findplaces.jpa.entity.Facilities;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(FacilitiesDAO.class)
public class FacilitiesDAOImpl extends BaseDAOImpl<Facilities, Long> implements FacilitiesDAO {

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
