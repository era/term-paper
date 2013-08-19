package br.com.findplaces.geocoding;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;

/**
 * Classe para geocodificação do endereço de filtro
 * @author coradini
 *
 */
public class GeocodeAddress {
	
	public static final String DEFAULT_LANGUAGE ="pt-br";

	/**
	 * Metodo para retorno da geocodificação via google do endereço solicitado
	 * @param address - String endereço local
	 * @param language - Linguagem local
	 * @return
	 * @throws Exception
	 */
	public GeocodeResponse getLocation(String address, String language)
			throws Exception {
		Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
				.setAddress(address)
				.setLanguage(language)
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		if (geocoderResponse.getStatus().equals(GeocoderStatus.OK)) {
			return geocoderResponse;
		} else {
			throw new Exception();
		}
	}
	
	/**
	 * Metodo para retorno da geocodificação via google do endereço soliticado	 * 
	 * @param address - String endereço local
	 * @param language - DEFAULT - PTBR
	 * @return
	 * @throws Exception
	 */
	public GeocodeResponse getLocation(String address)
			throws Exception {
		return getLocation(address, DEFAULT_LANGUAGE);
	}

}
