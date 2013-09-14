package br.com.findplaces.exceptions;


public class CouldNotSaveUserException extends Exception {


	public CouldNotSaveUserException(Exception e) {
		setStackTrace(e.getStackTrace());
	}

	private static final long serialVersionUID = 2359171615813328049L;

}
