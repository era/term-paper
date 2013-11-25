package br.com.findplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER_LIKES")
@NamedQueries({ @NamedQuery(name = "FindLikesByUserSocialID", query = "SELECT l FROM Likes l where l.user.socialID = :socialID") })
public class Likes extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6555240534112708730L;

	public static final String findLikesByUserSocialID = "FindLikesByUserSocialID";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@OneToOne
	private User user;

	@Column
	private String name;

	@Id
	@Column
	private String socialID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
