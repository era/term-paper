package br.com.findplaces.jpa.entity.geographic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.findplaces.jpa.entity.BaseEntity;


@NamedQueries({
	@NamedQuery(name="FindStreetByName", query="SELECT s FROM Street s where s.streetName = :name")
})
@Entity
@Table(name="TB_STREET")
public class Street extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7150118755881112499L;
	
	public static final String findStreetByName = "FindStreetByName";
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name="neighborhood_id")
	private Neighborhood hood;
	
	@Column
	private String streetName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Neighborhood getHood() {
		return hood;
	}

	public void setHood(Neighborhood hood) {
		this.hood = hood;
	}

}
