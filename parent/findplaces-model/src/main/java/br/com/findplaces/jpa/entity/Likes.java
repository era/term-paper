package br.com.findeplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="FindLikesByUserSocialID", query="SELECT l FROM Likes l where l.user.socialID = :socialID"),
})
@Entity
@Table(name="TB_USER_LIKES")
public class Likes implements Serializable {
	
	private static final long serialVersionUID = 6555240534112708730L;
	
	public static final String findLikesByUserSocialID = "FindLikesByUserSocialID";
	
	@Id
	@OneToOne
	private User user;
	
	@Column
	private String name;
	
	@Id
	@Column
	private String socialID;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
