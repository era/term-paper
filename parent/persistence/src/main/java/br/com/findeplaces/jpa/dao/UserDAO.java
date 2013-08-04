package br.com.findeplaces.jpa.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.findeplaces.jpa.entity.User;

@Stateless
@Local
public class UserDAO extends BaseDAO<User, Long> {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEManager() {
		return em;
	}

	@Override
	public void setEManager(EntityManager em) {
		this.em = em;
	}

}
