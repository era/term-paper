package br.com.findplaces.usermodule.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.usermodule.exceptions.CouldNotFindUserException;
import br.com.findplaces.usermodule.exceptions.CouldNotSaveUserException;

@Remote
public interface UserLogin extends Serializable {

	UserTO findUserBySocialID(String id) throws CouldNotFindUserException;
	
	UserTO findUserById(Long id) throws CouldNotFindUserException;
	
	UserTO createUser(UserTO user) throws CouldNotSaveUserException;
	
	UserTO updateUser(UserTO user) throws CouldNotSaveUserException;
	
}
