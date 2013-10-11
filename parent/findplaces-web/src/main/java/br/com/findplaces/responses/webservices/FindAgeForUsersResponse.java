package br.com.findplaces.responses.webservices;

import java.io.Serializable;
import java.util.Map;

import br.com.findplaces.webservices.requests.BaseJSONObject;

public class FindAgeForUsersResponse extends BaseJSONObject implements
		Serializable {

	private static final long serialVersionUID = 8249709565341828327L;
	
	private Map<Integer,Double> ageFromUsers;

	public Map<Integer,Double> getAgeFromUsers() {
		return ageFromUsers;
	}

	public void setAgeFromUsers(Map<Integer,Double> ageFromUsers) {
		this.ageFromUsers = ageFromUsers;
	}

}
