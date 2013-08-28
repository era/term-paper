package br.com.findplaces.model.to;

import java.util.List;

public class ApartmentAddressTO {	
	
	private Long id;

	private List<ApartmentTO> listApartment;	
		
	private String complemento;
	
	private String number;
	
	private String street;
	
	private String city;
	
	private String region;
	
	private String country;
	
	
	public List<ApartmentTO> getListApartment() {
		return listApartment;
	}

	public void setListApartment(List<ApartmentTO> listApartment) {
		this.listApartment = listApartment;
	}

	

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
