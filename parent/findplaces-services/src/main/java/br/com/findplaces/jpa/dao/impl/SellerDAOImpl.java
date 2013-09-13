package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.interfaces.SellerDAO;
import br.com.findplaces.jpa.entity.Seller;

@Stateless
@Remote(SellerDAO.class)
public class SellerDAOImpl extends BaseDAOImpl<Seller, Long> implements SellerDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="FindPlaces")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override()
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public Seller findSellerByUserSocialId(String id){
		Query query = getEntityManager().createNamedQuery(Seller.FIND_SELLER_BY_SOCIAL_ID, Seller.class);
		query.setParameter("socialID", id);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return (Seller) resultList.get(0);
		}
	}	
	

}
