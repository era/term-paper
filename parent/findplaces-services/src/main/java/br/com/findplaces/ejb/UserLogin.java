package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.exceptions.CouldNotFindUserException;
import br.com.findplaces.exceptions.CouldNotSaveUserException;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;

public interface UserLogin extends Serializable {

	public static String FACEBOOK_USER = "FACEBOOK_USER";
	
	public static Long FACEBOOK_USER_ID = 1L;

	UserTO findUserBySocialID(String id) throws CouldNotFindUserException;

	UserTO findUserById(Long id) throws CouldNotFindUserException;

	UserTO createUser(UserTO user) throws CouldNotSaveUserException;

	UserTO updateUser(UserTO user) throws CouldNotSaveUserException;

	UserTO login(UserTO user) throws CouldNotFindUserException;

	SellerTO saveSeller(SellerTO seller);

	SellerTO findSeller(String socialID) throws CouldNotFindUserException;

}
