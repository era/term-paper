package br.com.findplaces.utils;

import br.com.findplaces.webservices.exceptions.NotAuthorizedException;

public class Validator {
	
	public static void isValidToken(String token, String id)
			throws NotAuthorizedException {
		if (!FacebookUtils.isValidToken(token, id)) {
			throw new NotAuthorizedException();
		}
	}

}
