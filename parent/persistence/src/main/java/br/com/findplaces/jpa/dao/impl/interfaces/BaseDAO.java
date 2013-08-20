package br.com.findplaces.jpa.dao.impl.interfaces;

import br.com.findplaces.jpa.entity.BaseEntity;
import br.com.findplaces.jpa.exception.DAOException;

public interface BaseDAO<TO extends BaseEntity,ID> {
	
	ID create(TO to) throws DAOException;
	
	void delete(ID id) throws DAOException;
	
	TO findById(ID id) throws DAOException;
	
	void update(TO to) throws DAOException;
	
	void save(TO to) throws DAOException;

}
