package br.com.findeplaces.jpa.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.findeplaces.jpa.entity.User;

@Stateless
@Local(IUserDAO.class)
public class UserDAO extends BaseDAO<User, Long> implements IUserDAO {

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

}
