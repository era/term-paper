package br.com.findplaces.usermodule.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.usermodule.exceptions.CouldNotFindUserException;
import br.com.findplaces.usermodule.exceptions.CouldNotSaveUserException;

@Remote
public interface UserLogin extends Serializable {
	
	public static String FACEBOOK_USER = "FACEBOOK_USER";
	public static Long FACEBOOK_USER_ID = 1L;
	

	UserTO findUserBySocialID(String id) throws CouldNotFindUserException;
	
	UserTO findUserById(Long id) throws CouldNotFindUserException;
	
	UserTO createUser(UserTO user) throws CouldNotSaveUserException;
	
	UserTO updateUser(UserTO user) throws CouldNotSaveUserException;
	
	UserTO login(UserTO user) throws CouldNotFindUserException;
	
	SellerTO saveSeller(SellerTO seller) throws CouldNotSaveUserException;
	
	SellerTO findSeller(String socialID) throws CouldNotFindUserException;
	
}
