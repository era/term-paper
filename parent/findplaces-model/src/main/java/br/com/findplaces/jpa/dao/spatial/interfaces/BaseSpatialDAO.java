package br.com.findplaces.jpa.dao.spatial.interfaces;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.exception.DAOException;

public interface BaseSpatialDAO <SpatialEntity extends BaseEntity , ID>  {
	
	ID create(SpatialEntity entity) throws DAOException;
	
	void delete(ID id) throws DAOException;
	
	SpatialEntity findById(ID id) throws DAOException;
	
	void update(SpatialEntity entity) throws DAOException;
	
	void save(SpatialEntity entity) throws DAOException;

}
