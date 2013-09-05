package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.jpa.dao.interfaces.UserDAO;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.exception.DAOException;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name="UserLoginEJB", mappedName = "UserLogin")
@Remote(UserLogin.class)
public class UserLoginImpl implements UserLogin {

	private static final long serialVersionUID = 1L;
	
	//private static final Logger logger = Logger.getLogger(UserLoginImpl.class);
	
	@EJB
	private UserDAO userDAO;

	@Override
	public UserTO findUserById(Long id)   {
		try {
			User user = userDAO.findById(id);
			
			if(user==null){
				//logger.info("Não foi encontrado o usuário "+ id.toString());				
			}
			
			return ConverterTO.converter(user);
			
		} catch (DAOException e) {
			//logger.error(e);
		}
		return null;
	}

	@Override
	public UserTO findUserBySocialID(String id)   {
		User user = null;
		try{
			user = userDAO.findUserBySocialID(id);
			if(user == null){
				//logger.info("Não foi encontrado o usuário "+ id);
			}
		}catch(NoResultException e){
		}
		return ConverterTO.converter(user);
	}

	@Override
	public UserTO createUser(UserTO user)   {
		try {
			//TODO Encrypt password
			Long id = userDAO.create(ConverterTO.converter(user));
			return this.findUserById(id);
		} catch (DAOException e) {
		} 
		
		return user;
	}

	@Override
	public UserTO updateUser(UserTO user)   {
		return null;
	}

	@Override
	public UserTO login(UserTO user)   {
		User userFound = userDAO.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(userFound==null){
		}
		
		return ConverterTO.converter(userFound);
	}

	@Override
	public SellerTO saveSeller(SellerTO sellerTO)
			  {
		Seller seller = ConverterTO.converter(sellerTO);
		
		return ConverterTO.converter(userDAO.saveSellerConfigurations(seller));
		
	}

	@Override
	public SellerTO findSeller(String socialID){
		Seller sellerFound = userDAO.findSellerBySocialID(socialID);
		
		if(sellerFound==null){
		}
		
		return ConverterTO.converter(sellerFound);
	}


}
