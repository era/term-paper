package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;


public interface UserLogin extends Serializable {
	
	public static String FACEBOOK_USER = "FACEBOOK_USER";
	public static Long FACEBOOK_USER_ID = 1L;
	

	UserTO findUserBySocialID(String id) ;
	
	UserTO findUserById(Long id); 
	
	UserTO createUser(UserTO user)  ;
	
	UserTO updateUser(UserTO user)  ;
	
	UserTO login(UserTO user)  ;
	
	SellerTO saveSeller(SellerTO seller)  ;
	
	SellerTO findSeller(String socialID)  ;
	
}
