package br.com.findplaces.utils;

import br.com.findplaces.model.to.UserTO;

import com.restfb.types.User;

public class Converter {
	
	private Converter(){}
	
	public static UserTO converter(User user){
		UserTO userTO = new UserTO();
		userTO.setName(user.getName());
		userTO.setEmail(user.getEmail());
		userTO.setSocialID(user.getId());
		userTO.setAge(user.getBirthday());
		userTO.setRelationship(user.getRelationshipStatus());
		userTO.setStudyAt(user.getEducation() != null && !user.getEducation().isEmpty() ?
				user.getEducation().get(user.getEducation().size() - 1).getSchool().getName() : ""); //TODO This will fuckup the data mining
		return userTO;
	}

}
