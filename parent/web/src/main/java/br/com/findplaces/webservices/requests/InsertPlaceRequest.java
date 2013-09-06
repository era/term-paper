package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.SellerTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class InsertPlaceRequest implements Serializable {
	
	private static final long serialVersionUID = 329237857291104899L;
	
	private PlaceTO place;
	
	private SellerTO seller;

	public PlaceTO getPlace() {
		return place;
	}

	public void setPlace(PlaceTO place) {
		this.place = place;
	}

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public static InsertPlaceRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, InsertPlaceRequest.class);
	}

}
