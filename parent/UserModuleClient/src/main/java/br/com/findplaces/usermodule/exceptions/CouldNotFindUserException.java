package br.com.findplaces.usermodule.exceptions;

public class CouldNotFindUserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CouldNotFindUserException(){}
	public CouldNotFindUserException(Exception e){
		setStackTrace(e.getStackTrace());
	}

}
