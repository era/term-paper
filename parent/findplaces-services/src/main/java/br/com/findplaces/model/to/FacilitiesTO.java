package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement(name = "facilities")
public class FacilitiesTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
		
	private boolean gatekeeper;
	
	private boolean gym;
	
	private boolean townBarbecue;
	
	private boolean gasTubing;
	
	private boolean laundry;
	
	private boolean townPool;
	
	private boolean playground;
	
	private boolean automaticDoor;
	
	private boolean sportArea;
	
	private boolean partyRoom;
	
	private boolean sauna;
	
	private boolean internet;
	
	private boolean air;
	
	private boolean kitchenCabinet;
	
	private boolean bedroomCloset;
	
	private boolean bathroomCloset;
	
	private boolean hidromassage;
	
	private boolean bathBoxGlass;
	
	private boolean barbecue;
	
	private boolean gasShower;
	
	private boolean roofing;
	
	private boolean pool;
	
	private boolean terrace;
	
	private Double price;
	
	
	public static FacilitiesTO fromString(String json) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, FacilitiesTO.class);
	}
	
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
		return hidromassage;
	}

	public void setHidromassage(boolean hidromassage) {
		this.hidromassage = hidromassage;
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
