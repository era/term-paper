package br.com.findplaces.usermodule.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

import br.com.findplaces.model.to.ApartmentTO;
import br.com.findplaces.usermodule.exceptions.CouldNotFindAddressException;

@Remote
public interface Apartment extends Serializable {
	
	ApartmentTO findAdressByString(String address) throws CouldNotFindAddressException;	
	
	ApartmentTO saveApartment(ApartmentTO apart) throws CouldNotFindAddressException;	

}
