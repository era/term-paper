package br.com.findplaces.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TOWNHOUSE")
@SequenceGenerator(name = "facilities_seq", sequenceName = "facilities_id_seq")  
public class Facilities extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private boolean gatekeeper;
	
	@Column
	private boolean gym;
	
	@Column	
	private boolean townBarbecue;
	
	@Column
	private boolean gasTubing;
	
	@Column
	private boolean laundry;
	
	@Column
	private boolean townPool;
	
	@Column
	private boolean playground;
	
	@Column
	private boolean automaticDoor;
	
	@Column
	private boolean sportArea;
	
	@Column
	private boolean partyRoom;
	
	@Column
	private boolean sauna;
	
	@Column
	private boolean internet;
	
	@Column
	private boolean air;
	
	@Column	
	private boolean kitchenCabinet;
	
	@Column	
	private boolean bedroomCloset;
	
	@Column
	private boolean bathroomCloset;
	
	@Column
	private boolean bathtub;
	
	@Column
	private boolean bathBoxGlass;
	
	@Column
	private boolean barbecue;
	
	@Column
	private boolean gasShower;
	
	@Column
	private boolean roofing;
	
	@Column
	private boolean pool;
	
	@Column
	private boolean terrace;
	
	@Column
	private Double price;
		
	
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

	public boolean isGatekeeper() {
		return gatekeeper;
	}

	public void setGatekeeper(boolean gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean isTownBarbecue() {
		return townBarbecue;
	}

	public void setTownBarbecue(boolean townBarbecue) {
		this.townBarbecue = townBarbecue;
	}

	public boolean isGasTubing() {
		return gasTubing;
	}

	public void setGasTubing(boolean gasTubing) {
		this.gasTubing = gasTubing;
	}

	public boolean isLaundry() {
		return laundry;
	}

	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}

	public boolean isTownPool() {
		return townPool;
	}

	public void setTownPool(boolean townPool) {
		this.townPool = townPool;
	}

	public boolean isPlayground() {
		return playground;
	}

	public void setPlayground(boolean playground) {
		this.playground = playground;
	}

	public boolean isAutomaticDoor() {
		return automaticDoor;
	}

	public void setAutomaticDoor(boolean automaticDoor) {
		this.automaticDoor = automaticDoor;
	}

	public boolean isSportArea() {
		return sportArea;
	}

	public void setSportArea(boolean sportArea) {
		this.sportArea = sportArea;
	}

	public boolean isPartyRoom() {
		return partyRoom;
	}

	public void setPartyRoom(boolean partyRoom) {
		this.partyRoom = partyRoom;
	}

	public boolean isSauna() {
		return sauna;
	}

	public void setSauna(boolean sauna) {
		this.sauna = sauna;
	}

	public boolean isInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean isAir() {
		return air;
	}

	public void setAir(boolean air) {
		this.air = air;
	}

	public boolean isKitchenCabinet() {
		return kitchenCabinet;
	}

	public void setKitchenCabinet(boolean kitchenCabinet) {
		this.kitchenCabinet = kitchenCabinet;
	}

	public boolean isBedroomCloset() {
		return bedroomCloset;
	}

	public void setBedroomCloset(boolean bedroomCloset) {
		this.bedroomCloset = bedroomCloset;
	}

	public boolean isBathroomCloset() {
		return bathroomCloset;
	}

	public void setBathroomCloset(boolean bathroomCloset) {
		this.bathroomCloset = bathroomCloset;
	}

	public boolean isHidromassage() {
		return bathtub;
	}

	public void setHidromassage(boolean hidromassage) {
		this.bathtub = hidromassage;
	}

	public boolean isBathBoxGlass() {
		return bathBoxGlass;
	}

	public void setBathBoxGlass(boolean bathBoxGlass) {
		this.bathBoxGlass = bathBoxGlass;
	}

	public boolean isBarbecue() {
		return barbecue;
	}

	public void setBarbecue(boolean barbecue) {
		this.barbecue = barbecue;
	}

	public boolean isGasShower() {
		return gasShower;
	}

	public void setGasShower(boolean gasShower) {
		this.gasShower = gasShower;
	}

	public boolean isRoofing() {
		return roofing;
	}

	public void setRoofing(boolean roofing) {
		this.roofing = roofing;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isTerrace() {
		return terrace;
	}

	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
