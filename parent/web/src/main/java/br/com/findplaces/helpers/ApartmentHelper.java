package br.com.findplaces.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.findplaces.model.to.ApartmentTO;

public class ApartmentHelper implements Serializable {

	public static final String ADDRESS_EMPTY = "addressEmpty";	
	
	private static final long serialVersionUID = 7027813194141891440L;
	
	public static List<String> validadeAddres(ApartmentTO apart, String password){
		List<String> errors = new ArrayList<String>();
		
		if(StringUtils.isEmpty(apart.getAddress())){
			errors.add(ADDRESS_EMPTY);
		}
		
		return errors;
	}

}
