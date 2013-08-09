package br.com.findeplaces.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findeplaces.jpa.dao.impl.interfaces.UserDAO;
import br.com.findeplaces.jpa.entity.Likes;
import br.com.findeplaces.jpa.entity.User;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
@Local(UserDAO.class)
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

	private static final long serialVersionUID = 1L;
	
	@Resource
	@PersistenceContext(unitName="findplaces")
	private EntityManager em;

	@Override
	public EntityManager getEManager() {
		return em;
	}

	@Override
	public void setEManager(EntityManager em) {
		this.em = em;
	}
	
	public User findUserBySocialID(String id){
		Query query = getEManager().createNamedQuery(User.findUserBySocialID, User.class);
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
		getEManager().persist(likes);
	}

}
