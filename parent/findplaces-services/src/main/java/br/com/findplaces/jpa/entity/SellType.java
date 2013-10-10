package br.com.findplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SELL_TYPE")
public class SellType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4716453815992785102L;
	
	@Column
	private String name;
	
	@Id
	@Column
	private Long id;

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

}
