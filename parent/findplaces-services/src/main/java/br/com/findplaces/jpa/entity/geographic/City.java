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
	@NamedQuery(name="FindCityByName", query="SELECT c FROM City c where c.name = :name")
})
@Entity
@Table(name="TB_CITY")
public class City extends BaseEntity implements Serializable {
	
	public static final String findCityByName = "FindCityByName";
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	@OneToMany(mappedBy="city", targetEntity = Neighborhood.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Neighborhood> hoods;	

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

	public List<Neighborhood> getHoods() {
		return hoods;
	}

	public void setHoods(List<Neighborhood> hoods) {
		this.hoods = hoods;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
