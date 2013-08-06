package br.com.findplaces.model.to;

import java.io.Serializable;
import java.util.List;

public class UserTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String email;
	
	private Long id;
	
	private String socialID;
	
	private String password;

	private UserTypeTO type;
	
	private List<LikesTO> likes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocialID() {
		return socialID;
	}

	public void setSocialID(String socialID) {
		this.socialID = socialID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTypeTO getType() {
		return type;
	}

	public void setType(UserTypeTO type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<LikesTO> getLikes() {
		return likes;
	}

	public void setLikes(List<LikesTO> likes) {
		this.likes = likes;
	}
}
