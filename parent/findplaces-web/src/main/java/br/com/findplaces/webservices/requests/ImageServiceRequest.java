package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class ImageServiceRequest implements Serializable {

	private static final long serialVersionUID = 1419938815450974203L;
	
	private String userID;
	
	private String token;
	
	private String base64IMG;
	
	private String format;
	
	public static ImageServiceRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, ImageServiceRequest.class);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBase64IMG() {
		return base64IMG;
	}

	public void setBase64IMG(String base64IMG) {
		this.base64IMG = base64IMG;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
