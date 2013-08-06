package br.com.findeplaces.jpa.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findeplaces.jpa.dao.impl.interfaces.UserDAO;
import br.com.findeplaces.jpa.entity.Likes;
import br.com.findeplaces.jpa.entity.User;

@Stateless
@Local(UserDAO.class)
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(name="findplaces")
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
		query.setParameter(":socialID", id);
		
		return (User) query.getSingleResult();
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
