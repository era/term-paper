package br.com.findplaces.ejb.impl;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.apache.log4j.Logger;

import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.exceptions.CouldNotFindUserException;
import br.com.findplaces.exceptions.CouldNotSaveUserException;
import br.com.findplaces.exceptions.TokenInvalidException;
import br.com.findplaces.jpa.dao.interfaces.UserDAO;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.Token;
import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.util.ConverterTO;
import br.com.findplaces.util.RandomString;

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
			if(user.getPassword()!=null){
				user.setPassword(criptgraphPassword(user.getPassword()));
			}
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

	@Override
	public String isValidToken(String token, Long id) throws TokenInvalidException {
		Token tokenOnDB = userDAO.findToken(token, id);
		if(tokenOnDB == null) {
			throw new TokenInvalidException();
		} else if ( tokenOnDB.getValid().after(new Date())) {
			userDAO.deleteToken(tokenOnDB);
			throw new TokenInvalidException();
		} 
		
		tokenOnDB.setValid(this.increaseValidTimeToken());
		
		userDAO.saveToken(tokenOnDB);
		
		return tokenOnDB.getToken();
	}

	@Override
	public String generateTokenForUser(UserTO user) {
		try{
			Date valid = increaseValidTimeToken();
			
			StringBuilder token = new StringBuilder();
			token.append(valid.toString());
			token.append(new RandomString(30).nextString());
	
			Token tokenOnDB = new Token();
			tokenOnDB.setToken(token.toString());
			tokenOnDB.setUser(userDAO.findById(user.getId()));
			tokenOnDB.setValid(valid);
			userDAO.saveToken(tokenOnDB);
			
			return tokenOnDB.getToken();
		} catch(Exception e) {
			return null; //FIXME
		}
	}

	private Date increaseValidTimeToken() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.MINUTE,30);
		
		Date valid = new Date(calendar.getTimeInMillis());
		return valid;
	}

	@Override
	public UserTO findUserByEmailAndPassword(String email, String password)
			throws CouldNotFindUserException {
		User user = userDAO.findUserByEmailAndPassword(email, criptgraphPassword(password));
		
		if(user== null) {
			throw new CouldNotFindUserException();
		}
		
		return ConverterTO.converter(user);
	}

	private String criptgraphPassword(String password) {
		try {
			MessageDigest cript = MessageDigest.getInstance("MD5");
			return (new HexBinaryAdapter()).marshal(cript.digest(password.getBytes("UTF-8")));
		} catch(Exception e) {
			return null; //FIXME
		}
	}

	@Override
	public SellerTO findSeller(Long userID) throws CouldNotFindUserException {
		Seller sellerFound = userDAO.findSellerByUserID(userID);

		if (sellerFound == null) {
			throw new CouldNotFindUserException();
		}

		return ConverterTO.converter(sellerFound);
	}

}