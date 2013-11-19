package br.com.findplaces.jpa.dao.spatial.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.findplaces.jpa.dao.spatial.interfaces.BaseSpatialDAO;
import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.exception.DAOException;

public abstract class BaseSpatialDAOImpl<SpatialEntity extends BaseEntity,ID> implements Serializable, BaseSpatialDAO<SpatialEntity,ID> {
	
	public abstract EntityManager getEntitySpatialManager();
	
	public abstract void setEntitySpatialManager(EntityManager emSpatial);
	
	
	public Session getSession() {
    	return (Session) getEntitySpatialManager().getDelegate();
    }
	
	@SuppressWarnings("unchecked")
	protected <T extends BaseEntity> Class<T> getEntityClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0];
    }
	
	@SuppressWarnings("unchecked")
	public ID create(SpatialEntity spatialEntity) throws DAOException {
        try {
        	this.getEntitySpatialManager().flush();
            this.getEntitySpatialManager().persist(spatialEntity);
            return (ID) ((BaseEntity) spatialEntity).getPrimaryKey();
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	public void delete(ID id) throws DAOException {
        try {
        	SpatialEntity entity = (SpatialEntity) this.getEntitySpatialManager().find(getEntityClass(), id);
            this.getEntitySpatialManager().remove(entity);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	public SpatialEntity findById(ID id) throws DAOException {
    	try {
            return (SpatialEntity) this.getEntitySpatialManager().find(getEntityClass(), id);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void update(SpatialEntity spatialEntity) throws DAOException {
        try {        	
            this.getEntitySpatialManager().merge(spatialEntity);
        } catch (Exception e) {
        	throw new DAOException(e);
        }
    }
	
	public void save(SpatialEntity spatialEntity) throws DAOException{
		update(spatialEntity);
	}

}
