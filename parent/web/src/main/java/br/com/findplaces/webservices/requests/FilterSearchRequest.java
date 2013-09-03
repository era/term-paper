package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class FilterSearchRequest implements Serializable {

	private static final long serialVersionUID = -5508737983115479710L;
	
	
	public static FilterSearchRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, FilterSearchRequest.class);
	}
	//TODO What fields will be "searchable" here?

}
