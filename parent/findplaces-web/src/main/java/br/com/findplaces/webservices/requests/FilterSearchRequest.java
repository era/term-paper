package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.spatial.to.PlaceSpatialTO;
import br.com.findplaces.model.to.PlaceTypeTO;
import br.com.findplaces.model.to.SellerTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class FilterSearchRequest implements Serializable {

	private static final long serialVersionUID = -5508737983115479710L;
	
	
	public static FilterSearchRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, FilterSearchRequest.class);
	}
	
	private String address;

	private Integer bathroom;

	private Integer bedroom;

	private CityTO city;

	private String code;

	private Double complexPrice;

	private String description;

	private Integer garage;

	private Double lat;

	private Double log;

	private Double m2;

	private NeighborhoodTO neighborhood;

	private PlaceTypeTO placetype;

	private Double price;

	private Integer room;

	private SellerTO seller;

	private String socialid;

	private PlaceSpatialTO spatial;

	private StreetTO street;

	private Integer suite;
	
	private String token;

}
