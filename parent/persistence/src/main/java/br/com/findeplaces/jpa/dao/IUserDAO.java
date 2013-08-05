package br.com.findeplaces.jpa.dao;

import br.com.findeplaces.jpa.entity.User;

public interface IUserDAO extends IBaseDao<User, Long> {

	User findUserBySocialID(String id);
}
