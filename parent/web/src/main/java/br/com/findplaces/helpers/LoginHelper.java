package br.com.findplaces.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.findplaces.model.to.UserTO;

public class LoginHelper implements Serializable {

	public static final String PASSWORD_NOT_EQUAL_ERROR = "passwordNotEqual";

	public static final String PASSWORD_EMPTY_ERROR = "passwordEmpty";

	public static final String EMAIL_ERROR = "email";

	public static final String NAME_ERROR = "name";
	
	public static final String COULD_NOT_SAVE_ERROR = "couldNotSaveUser";
	
	
	private static final long serialVersionUID = 7027813194141891440L;
	
	public static List<String> validateSingupForm(UserTO user, String password){
		List<String> errors = new ArrayList<String>();
		
		if(StringUtils.isEmpty(user.getName())){
			errors.add(NAME_ERROR);
		}
		
		if(StringUtils.isEmpty(user.getEmail())){
			errors.add(EMAIL_ERROR);
		}
		
		if(StringUtils.isEmpty(user.getPassword())){
			errors.add(PASSWORD_EMPTY_ERROR);
		}
		
		if(user.getPassword()!= null && user.getPassword().equals(password) ){
			errors.add(PASSWORD_NOT_EQUAL_ERROR);
		}
		
		return errors;
	}

}
