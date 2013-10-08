package br.com.findplaces.jpa.entity.geographic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.BaseEntity;

@NamedQueries({
	@NamedQuery(name="FindRegionByName", query="SELECT r FROM Region r where r.name = :name"),
	@NamedQuery(name="FindRegionByAlias", query="SELECT r FROM Region r where r.alias = :alias")
})
@Entity
@Table(name="TB_REGION")
public class Region extends BaseEntity implements Serializable {
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	private static final long serialVersionUID = 952781593910418384L;
	
	public static final String findRegionByName = "FindRegionByName";
	
	public static final String findRegionByAlias = "FindRegionByAlias";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	@Column
	private String alias;
	
	@OneToMany(mappedBy="region", targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> cities;

	
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
