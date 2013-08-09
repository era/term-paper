package br.com.findplaces.facebook.utils;

import com.restfb.types.User;

import br.com.findplaces.model.to.UserTO;

public class Converter {
	
	private Converter(){}
	
	public static UserTO converter(User user){
		UserTO userTO = new UserTO();
		userTO.setName(user.getName());
		userTO.setEmail(user.getEmail());
		userTO.setSocialID(user.getId());
		return userTO;
	}

}
