package br.com.findplaces.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.findplaces.model.to.SellerTO;

public class UserServiceHelper {
	
	private static final String COUNTRY_IS_EMPTY = "countryIsEmpty";
	public static final String CITY_EMPTY_ERROR = "cityIsEmpty";

	public static List<String> validateCreateNewSeller(SellerTO seller){
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(seller.getCity())){
			errors.add(CITY_EMPTY_ERROR);
		}
		if(StringUtils.isEmpty(seller.getCountry())){
			errors.add(COUNTRY_IS_EMPTY);
		}
		
		return errors;
	}
}
