package br.com.findplaces.facebook.utils;

import br.com.findplaces.model.to.UserTO;

import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

public class FacebookUtils {

	
	public static boolean isValidToken(String token, UserTO user){

		return isValidToken(token, user.getSocialID());
		
	}

	public static boolean isValidToken(String token, String id) {
		DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
		User userFB = facebookClient.fetchObject("me", User.class);
		
		return userFB.getId().equals(id);
	}
	
	public static UserTO getUser(String token){
		DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
		User userFB = facebookClient.fetchObject("me", User.class);
		
		return Converter.converter(userFB);
	}
	
}
