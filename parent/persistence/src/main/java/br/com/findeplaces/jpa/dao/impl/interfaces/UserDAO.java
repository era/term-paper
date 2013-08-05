package br.com.findeplaces.jpa.dao.impl.interfaces;

import br.com.findeplaces.jpa.entity.User;

public interface UserDAO extends BaseDAO<User, Long> {

	User findUserBySocialID(String id);
}
