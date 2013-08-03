package br.com.findeplaces.jpa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.findeplaces.jpa.entity.BaseEntity;
import br.com.findeplaces.jpa.exception.DAOException;


public abstract class BaseDAO<TO extends BaseEntity,ID> implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract EntityManager getEManager();
	
	public abstract void setEMManager(EntityManager em);
	
	public Session getSession() {
    	return (Session) getEManager().getDelegate();
    }
	
	@SuppressWarnings("unchecked")
	protected <T extends BaseEntity> Class<T> getEntityClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0];
    }
	
	@SuppressWarnings("unchecked")
	public ID create(TO to) throws DAOException {
        try {
            this.getEManager().persist(to);
            return (ID) ((BaseEntity) to).getId();
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
	@SuppressWarnings("unchecked")
	public void delete(ID id) throws DAOException {
        try {
			TO entity = (TO) this.getEManager().find(getEntityClass(), id);
            this.getEManager().remove(entity);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	public TO findById(ID id) throws DAOException {
    	try {
            return (TO) this.getEManager().find(getEntityClass(), id);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void update(TO to) throws DAOException {
        try {        	
            this.getEManager().merge(to);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void save(TO to) throws DAOException{
		update(to);
	}
	
}
