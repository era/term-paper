package br.com.findplaces.usermodule.exceptions;

public class CouldNotFindAddressException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public CouldNotFindAddressException(){}
	public CouldNotFindAddressException(Exception e){
		setStackTrace(e.getStackTrace());
	}


}
