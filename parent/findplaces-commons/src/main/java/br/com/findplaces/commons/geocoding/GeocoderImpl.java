package br.com.findplaces.commons.geocoding;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.gson.Gson;

public class GeocoderImpl {

	private final static String LANGUAGE_DEFAULT = "pt-BR";	

	public static Gson geoCodeByAddress(String address) {

		Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage(LANGUAGE_DEFAULT).getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		
		return new Gson();
	}

}
