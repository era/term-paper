package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.interfaces.StreetDAO;
import br.com.findplaces.jpa.entity.geographic.Street;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(StreetDAO.class)
public class StreetDAOImpl extends BaseDAOImpl<Street, Long> implements
		StreetDAO {

	private static final long serialVersionUID = 1L;

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

	@Override
	public Street findByName(String name) {
		Query query = getEntityManager().createNamedQuery(Street.findStreetByName,	Street.class);
		query.setParameter("name", name);
		List resultList = query.getResultList();
		if (resultList.isEmpty()) {
			return null;
		} else {
			return (Street) resultList.get(0);
		}

	}
}
