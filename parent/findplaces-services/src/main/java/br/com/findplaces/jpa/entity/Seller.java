package br.com.findplaces.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=Seller.FIND_SELLER_BY_SOCIAL_ID, query="SELECT s FROM Seller s where s.user.socialID = :socialID"),
	@NamedQuery(name=Seller.FIND_SELLER_BY_USER_ID, query="SELECT s FROM Seller s where s.user.id = :id")
})
@Entity
@Table(name="TB_SELLER")
public class Seller extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_SELLER_BY_SOCIAL_ID = "Seller.findSellerBySocialID";
	
	public static final String FIND_SELLER_BY_USER_ID = "Seller.findSellerByUserId";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User user;
	
	@Column
	private String name;
	
	@Column
	private String latitude;
	
	@Column
	private String longitude;
	
	@Column
	private String website;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String country;

	
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
