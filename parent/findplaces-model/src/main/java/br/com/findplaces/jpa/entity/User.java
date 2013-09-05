package br.com.findplaces.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="FindUserBySocialId", query="SELECT u FROM User u where u.socialID = :socialID"),
	@NamedQuery(name="LoginUserWithPassword", query="SELECT u FROM User u where u.email = :email and u.password = :password")
})
@Entity
@Table(name="TB_USER")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String findUserBySocialID = "FindUserBySocialId";
	
	public static final String findUserByLike = "FindUserByLike";
	
	public static final String loginUserWithPassword = "LoginUserWithPassword";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String socialID;
	
	@Column
	private String password;
	
	@OneToOne
	private UserType type;
	
	@OneToMany
	private List<Likes> likes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

}
