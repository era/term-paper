package br.com.findeplaces.jpa.dao.impl.interfaces;

import br.com.findeplaces.jpa.entity.BaseEntity;
import br.com.findeplaces.jpa.exception.DAOException;

public interface BaseDAO<TO extends BaseEntity,ID> {
	
	ID create(TO to) throws DAOException;
	
	void delete(ID id) throws DAOException;
	
	TO findById(ID id) throws DAOException;
	
	void update(TO to) throws DAOException;
	
	void save(TO to) throws DAOException;

}
