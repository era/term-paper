package br.com.findplaces.jpa.entity.geographic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.BaseEntity;

@Entity
@Table(name="TB_NEIGHBORHOOD")
public class Neighborhood extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7150118755881112499L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String hoodName;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy="hood", targetEntity = Street.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Street> streets;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoodName() {
		return hoodName;
	}

	public void setHoodName(String hoodName) {
		this.hoodName = hoodName;
	}
	
	public List<Street> getStreets() {
		return streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	

}
