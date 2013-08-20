package br.com.findplaces.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_REGION")
public class Region {
	
	private String name;
	
	private String code;
	

}
