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

import br.com.findplaces.jpa.dao.interfaces.CityDAO;
import br.com.findplaces.jpa.dao.interfaces.RegionDAO;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Region;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Remote(RegionDAO.class)
public class RegionDAOImpl extends BaseDAOImpl<Region, Long> implements RegionDAO {

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
	public Region findByName(String name) {
		Query query = getEntityManager().createNamedQuery(Region.findRegionByName, Region.class);
		query.setParameter("name", name);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return (Region) resultList.get(0);
		}
	}

	@Override
	public Region findByAlias(String alias) {
		Query query = getEntityManager().createNamedQuery(Region.findRegionByAlias, Region.class);
		query.setParameter("alias", alias);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return (Region) resultList.get(0);
		}
	}

}
