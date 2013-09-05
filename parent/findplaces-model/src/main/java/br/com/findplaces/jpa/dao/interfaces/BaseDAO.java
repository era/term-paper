package br.com.findplaces.jpa.dao.interfaces;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.exception.DAOException;

public interface BaseDAO<Entity extends BaseEntity , ID> {
	
	ID create(Entity entity) throws DAOException;
	
	void delete(ID id) throws DAOException;
	
	Entity findById(ID id) throws DAOException;
	
	void update(Entity entity) throws DAOException;
	
	void save(Entity entity) throws DAOException;

}
