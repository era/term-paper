package br.com.findplaces.usermodule.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.findeplaces.jpa.dao.IUserDAO;
import br.com.findeplaces.jpa.entity.User;
import br.com.findeplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.usermodule.ejb.UserLogin;
import br.com.findplaces.usermodule.exceptions.CouldNotFindUserException;
import br.com.findplaces.usermodule.exceptions.CouldNotSaveUserException;
import br.com.findplaces.usermodule.utils.ConverterTO;

@Stateless
@Remote(UserLogin.class)
public class UserLoginImpl implements UserLogin {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(UserLoginImpl.class);
	
	@EJB
	private IUserDAO userDAO;

	@Override
	public UserTO findUserById(Long id) throws CouldNotFindUserException {
		try {
			User user = userDAO.findById(id);
			
			if(user==null){
				logger.info("Não foi encontrado o usuário "+ id.toString());
				throw new CouldNotFindUserException();
			}
			
			return ConverterTO.converter(user);
			
		} catch (DAOException e) {
			logger.error(e);
			throw new CouldNotFindUserException(e);
		}
	}

	@Override
	public UserTO findUserBySocialID(String id) throws CouldNotFindUserException {
		User user = userDAO.findUserBySocialID(id);
		if(user == null){
			logger.info("Não foi encontrado o usuário "+ id);
			throw new CouldNotFindUserException();
		}
		return ConverterTO.converter(user);
	}

	@Override
	public UserTO createUser(UserTO user) throws CouldNotSaveUserException {
		try {
			userDAO.save(ConverterTO.converter(user));
		} catch (DAOException e) {
			throw new CouldNotSaveUserException(e);
		}
		return null;
	}

	@Override
	public UserTO updateUser(UserTO user) throws CouldNotSaveUserException {
		// TODO Auto-generated method stub
		return null;
	}


}
