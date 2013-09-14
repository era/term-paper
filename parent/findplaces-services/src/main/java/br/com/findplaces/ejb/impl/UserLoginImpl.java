package br.com.findplaces.usermodule.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.exceptions.CouldNotFindUserException;
import br.com.findplaces.exceptions.CouldNotSaveUserException;
import br.com.findplaces.jpa.dao.interfaces.UserDAO;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name = "UserLoginEJB", mappedName = "UserLogin")
@Remote(UserLogin.class)
public class UserLoginImpl implements UserLogin {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(UserLoginImpl.class);

	@EJB
	private UserDAO userDAO;

	@Override
	public UserTO findUserById(Long id) throws CouldNotFindUserException {
		try {
			User user = userDAO.findById(id);

			if (user == null) {
				logger.info("Não foi encontrado o usuário " + id.toString());
				throw new CouldNotFindUserException();
			}

			return ConverterTO.converter(user);

		} catch (DAOException e) {
			logger.error(e);
			throw new CouldNotFindUserException(e);
		}
	}

	@Override
	public UserTO findUserBySocialID(String id)
			throws CouldNotFindUserException {
		User user = null;
		try {
			user = userDAO.findUserBySocialID(id);
			if (user == null) {
				logger.info("Não foi encontrado o usuário " + id);
				throw new CouldNotFindUserException();
			}
		} catch (NoResultException e) {
			throw new CouldNotFindUserException(e);
		}
		return ConverterTO.converter(user);
	}

	@Override
	public UserTO createUser(UserTO user) throws CouldNotSaveUserException {
		try {
			Long id = userDAO.create(ConverterTO.converter(user));
			return this.findUserById(id);
		} catch (DAOException e) {
			throw new CouldNotSaveUserException(e);
		} catch (CouldNotFindUserException e) {
			throw new CouldNotSaveUserException(e);
		}
	}

	@Override
	public UserTO updateUser(UserTO user) throws CouldNotSaveUserException {
		try{
			userDAO.save(ConverterTO.converter(user));
			return this.findUserById(user.getId());
		} catch(Exception e){
			throw new CouldNotSaveUserException(e);
		}
	}

	@Override
	public UserTO login(UserTO user) throws CouldNotFindUserException {
		User userFound = userDAO.findUserByEmailAndPassword(user.getEmail(),
				user.getPassword());

		if (userFound == null) {
			throw new CouldNotFindUserException();
		}

		return ConverterTO.converter(userFound);
	}

	@Override
	public SellerTO saveSeller(SellerTO sellerTO) {
		Seller seller = ConverterTO.converter(sellerTO);

		return ConverterTO.converter(userDAO.saveSellerConfigurations(seller));

	}

	@Override
	public SellerTO findSeller(String socialID)
			throws CouldNotFindUserException {
		
		Seller sellerFound = userDAO.findSellerBySocialID(socialID);

		if (sellerFound == null) {
			throw new CouldNotFindUserException();
		}

		return ConverterTO.converter(sellerFound);
	}

}