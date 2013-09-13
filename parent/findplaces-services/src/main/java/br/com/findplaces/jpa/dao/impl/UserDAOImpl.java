package br.com.findplaces.jpa.dao.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findplaces.jpa.dao.interfaces.UserDAO;
import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.User;

@Stateless
@Remote(UserDAO.class)
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

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
	
	public User findUserBySocialID(String id){
		Query query = getEntityManager().createNamedQuery(User.findUserBySocialID, User.class);
		query.setParameter("socialID", id);
		List resultList = query.getResultList();
		if(resultList.isEmpty()){
			return null;
		} else{
			return (User) resultList.get(0);
		}
	}

	@Override
	public void saveLikesFromUser(List<Likes> likes) {
		for(Likes like : likes){
			saveLikesFromUser(like);
		}
	}

	@Override
	public void saveLikesFromUser(Likes likes) {
		getEntityManager().persist(likes);
	}
	
	public User findUserByEmailAndPassword(String email, String password){
		Query query  = getEntityManager().createNamedQuery(User.loginUserWithPassword, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		List resultList = query.getResultList();
		
		if(resultList.isEmpty()){
			return null;
		} else{
			return (User) resultList.get(0);
		}
	}

	@Override
	public Seller saveSellerConfigurations(Seller seller) {
		return getEntityManager().merge(seller);
	}
	
	

}
