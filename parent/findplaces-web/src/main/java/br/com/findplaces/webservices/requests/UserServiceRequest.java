package br.com.findplaces.webservices.requests;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.to.SellerTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement
public class UserServiceRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	private String userFacebookID;

	private String email;
	
	private String password;
	
	private String name;
	
	private SellerTO sellerTO;
	
	public static UserServiceRequest fromString(String json){
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, UserServiceRequest.class);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserFacebookID() {
		return userFacebookID;
	}

	public void setUserFacebookID(String userFacebookID) {
		this.userFacebookID = userFacebookID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SellerTO getSellerTO() {
		return sellerTO;
	}

	public void setSellerTO(SellerTO sellerTO) {
		this.sellerTO = sellerTO;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
