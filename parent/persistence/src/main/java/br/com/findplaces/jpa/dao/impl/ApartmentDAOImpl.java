package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.impl.interfaces.ApartmentDAO;
import br.com.findplaces.jpa.entity.Apartment;
import br.com.findplaces.jpa.entity.User;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Local(ApartmentDAO.class)
public class ApartmentDAOImpl extends BaseDAOImpl<Apartment, Long> implements ApartmentDAO {
	
	@Resource
	@PersistenceContext(unitName="findplaces")
	private EntityManager em;

	@Override
	public List<Apartment> findApartmentByRegion(String region) {
		Query query = getEManager().createNamedQuery(Apartment.FIND_APARTMENT_BY_REGION, Apartment.class);
		query.setParameter("region", region);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return resultList;
		}
	}

	@Override
	public EntityManager getEManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEManager(EntityManager em) {
		// TODO Auto-generated method stub
		
	}

}
