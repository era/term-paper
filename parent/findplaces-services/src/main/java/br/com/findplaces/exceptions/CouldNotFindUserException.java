package br.com.findplaces.exceptions;


public class CouldNotFindUserException extends Exception {

	public CouldNotFindUserException(Exception e) {
		setStackTrace(e.getStackTrace());
	}

	public CouldNotFindUserException() {
	}

	private static final long serialVersionUID = 1L;
	

}
