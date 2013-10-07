package br.com.findplaces.responses.webservices;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.webservices.requests.BaseJSONObject;

@XmlRootElement
public class UserResponse extends BaseJSONObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UserTO user;
	
	private String token;

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
