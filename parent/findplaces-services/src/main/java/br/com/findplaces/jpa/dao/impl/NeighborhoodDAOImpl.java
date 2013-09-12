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

import br.com.findplaces.jpa.dao.interfaces.NeighborhoodDAO;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;


@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(NeighborhoodDAO.class)
public class NeighborhoodDAOImpl extends BaseDAOImpl<Neighborhood, Long> implements NeighborhoodDAO {

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
	
	@Override
	public Neighborhood findByName(String name) {
		Query query = getEntityManager().createNamedQuery(Neighborhood.findNeighborhoodByName, Neighborhood.class);
		query.setParameter("name", name);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return (Neighborhood) resultList.get(0);
		}
	}


}