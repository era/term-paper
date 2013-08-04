package br.com.findplaces.usermodule.exceptions;

public class CouldNotSaveUserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CouldNotSaveUserException(){}
	public CouldNotSaveUserException(Exception e){
		setStackTrace(e.getStackTrace());
	}

}
