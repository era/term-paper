package br.com.findplaces.responses.webservices;

import java.io.Serializable;
import java.util.Map;

import br.com.findplaces.webservices.requests.BaseJSONObject;

public class FindLikesForUsersResponse extends BaseJSONObject implements
		Serializable {

	private static final long serialVersionUID = 3632841731316796843L;
	
	private Map<String,Double> likesFromUsers;

	public Map<String,Double> getLikesFromUsers() {
		return likesFromUsers;
	}

	public void setLikesFromUsers(Map<String,Double> likesFromUsers) {
		this.likesFromUsers = likesFromUsers;
	}

}
