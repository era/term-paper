package br.com.findplaces.jpa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.findplaces.jpa.dao.interfaces.BaseDAO;
import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.exception.DAOException;


public abstract class BaseDAOImpl<Entity extends BaseEntity,ID> implements Serializable, BaseDAO<Entity,ID> {

	private static final long serialVersionUID = 1L;

	public abstract EntityManager getEntityManager();
	
	public abstract void setEntityManager(EntityManager em);
	
	
	public Session getSession() {
    	return (Session) getEntityManager().getDelegate();
    }
	
	@SuppressWarnings("unchecked")
	protected <T extends BaseEntity> Class<T> getEntityClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0];
    }
	
	@SuppressWarnings("unchecked")
	public ID create(Entity entity) throws DAOException {
        try {
            this.getEntityManager().persist(entity);
            return (ID) ((BaseEntity) entity).getPrimaryKey();
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	public void delete(ID id) throws DAOException {
        try {
			Entity entity = (Entity) this.getEntityManager().find(getEntityClass(), id);
            this.getEntityManager().remove(entity);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	public Entity findById(ID id) throws DAOException {
    	try {
            return (Entity) this.getEntityManager().find(getEntityClass(), id);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void update(Entity entity) throws DAOException {
        try {        	
            this.getEntityManager().merge(entity);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void save(Entity entity) throws DAOException{
		update(entity);
	}
	
}
