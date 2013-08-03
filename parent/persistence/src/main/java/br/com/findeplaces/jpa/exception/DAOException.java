package br.com.findeplaces.jpa.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DAOException(Exception e){
		setStackTrace(e.getStackTrace());
	}

}
