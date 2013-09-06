package br.com.findplaces.webservices.requests;

import java.io.File;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class ImageServiceRequest implements Serializable {

	private static final long serialVersionUID = 1419938815450974203L;
	
	private String userID;
	
	private String token;
	
	private File file;
	
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
