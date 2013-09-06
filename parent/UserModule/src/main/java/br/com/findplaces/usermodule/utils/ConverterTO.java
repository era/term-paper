package br.com.findplaces.usermodule.utils;

import br.com.findeplaces.jpa.entity.Seller;
import br.com.findeplaces.jpa.entity.User;
import br.com.findeplaces.jpa.entity.UserType;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.UserTypeTO;

public class ConverterTO {
	
	private ConverterTO(){}
	
	public static UserTO converter(User user){
		UserTO userTO = new UserTO();
		userTO.setId(user.getId());
		userTO.setName(user.getName());
		userTO.setEmail(user.getEmail());
		userTO.setPassword(user.getPassword());
		userTO.setSocialID(user.getSocialID());
		userTO.setType(converter(user.getType()));
		return userTO;
	}
	
	public static UserTypeTO converter(UserType userType){
		UserTypeTO userTypeTO = new UserTypeTO();
		userTypeTO.setId(userType.getId());
		userTypeTO.setName(userType.getName());
		return userTypeTO;
	}
	
	public static User converter(UserTO userTO){
		User user = new User();
		user.setName(userTO.getName());
		user.setId(userTO.getId());
		user.setEmail(userTO.getEmail());
		user.setPassword(userTO.getPassword());
		user.setSocialID(userTO.getSocialID());
		user.setType(converter(userTO.getType()));
		return user;
	}
	
	public static UserType converter(UserTypeTO userTypeTO){
		UserType userType = new UserType();
		userType.setId(userTypeTO.getId());
		userType.setName(userTypeTO.getName());
		return userType;
	}

	public static Seller converter(SellerTO sellerTO) {
		Seller seller = new Seller();
		seller.setCity(sellerTO.getCity());
		seller.setCountry(sellerTO.getCountry());
		seller.setId(sellerTO.getId());
		seller.setLatitude(sellerTO.getLatitude());
		seller.setLongitude(sellerTO.getLongitude());
		seller.setName(sellerTO.getName());
		seller.setState(sellerTO.getWebsite());
		seller.setUser(ConverterTO.converter(sellerTO.getUserTO()));
		seller.setWebsite(sellerTO.getWebsite());
		
		return seller;
	}

	public static SellerTO converter(Seller seller) {
		SellerTO sellerTO = new SellerTO();
		sellerTO.setCity(seller.getCity());
		sellerTO.setCountry(seller.getCountry());
		sellerTO.setId(seller.getId());
		sellerTO.setLatitude(seller.getLatitude());
		sellerTO.setLongitude(seller.getLongitude());
		sellerTO.setName(seller.getName());
		sellerTO.setState(seller.getWebsite());
		sellerTO.setUserTO(ConverterTO.converter(seller.getUser()));
		sellerTO.setWebsite(seller.getWebsite());
		return sellerTO;
	}

}
