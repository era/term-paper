package br.com.findplaces.model.to;

import java.io.Serializable;

public class LikesTO implements Serializable {

	private static final long serialVersionUID = 1356959928231291945L;
	
	private String name;
	
	private String socialID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialID() {
		return socialID;
	}

	public void setSocialID(String socialID) {
		this.socialID = socialID;
	}
	

}
