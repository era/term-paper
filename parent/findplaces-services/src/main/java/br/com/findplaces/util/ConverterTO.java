package br.com.findplaces.util;

import br.com.findplaces.jpa.entity.Place;
import br.com.findplaces.jpa.entity.PlaceType;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.jpa.entity.User;
import br.com.findplaces.jpa.entity.UserType;
import br.com.findplaces.jpa.entity.geographic.City;
import br.com.findplaces.jpa.entity.geographic.Country;
import br.com.findplaces.jpa.entity.geographic.Neighborhood;
import br.com.findplaces.jpa.entity.geographic.Region;
import br.com.findplaces.jpa.entity.geographic.Street;
import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.CountryTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.RegionTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.PlaceTypeTO;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.UserTypeTO;

public class ConverterTO {

	private ConverterTO() {
	}

	public static UserTO converter(User user) {
		UserTO userTO = new UserTO();
		userTO.setId(user.getId());
		userTO.setName(user.getName());
		userTO.setEmail(user.getEmail());
		userTO.setPassword(user.getPassword());
		userTO.setSocialID(user.getSocialID());
		userTO.setType(converter(user.getType()));
		return userTO;
	}

	public static UserTypeTO converter(UserType userType) {
		UserTypeTO userTypeTO = new UserTypeTO();
		userTypeTO.setId(userType.getId());
		userTypeTO.setName(userType.getName());
		return userTypeTO;
	}

	public static User converter(UserTO userTO) {
		User user = new User();
		user.setName(userTO.getName());
		user.setId(userTO.getId());
		user.setEmail(userTO.getEmail());
		user.setPassword(userTO.getPassword());
		user.setSocialID(userTO.getSocialID());
		user.setType(converter(userTO.getType()));
		return user;
	}

	public static UserType converter(UserTypeTO userTypeTO) {
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

	public static Place converter(PlaceTO place) {
		Place entity = new Place();
		entity.setId(place.getId());
		entity.setAddress(place.getAddress());
		entity.setDescription(place.getDescription());
		entity.setCity(converter(place.getCity()));
		entity.setNeighborhood(converter(place.getNeighborhood()));
		entity.setStreet(converter(place.getStreet()));
		entity.setType(converter(place.getType()));
		return entity;
	}

	
	
	private static PlaceType converter(PlaceTypeTO type) {
		PlaceType entity = new PlaceType();
		entity.setId(type.getId());
		entity.setName(type.getName());
		return entity;
	}

	private static Country converter(CountryTO country) {
		Country entity = new Country();
		entity.setId(country.getId());
		entity.setName(country.getName());
		return entity;
	}
	
	private static Region converter(RegionTO region) {
		Region entity = new Region();
		entity.setId(region.getId());
		entity.setName(region.getName());
		entity.setCountry(converter(region.getCountry()));
		return entity;
	}

	private static City converter(CityTO city) {
		City entity = new City();
		entity.setId(city.getId());
		entity.setName(city.getName());
		entity.setRegion(converter(city.getRegion()));
		return entity;
	}
	
	private static Neighborhood converter(NeighborhoodTO neighborhood) {
		Neighborhood entity = new Neighborhood();
		entity.setId(neighborhood.getId());
		entity.setHoodName(neighborhood.getName());
		entity.setCity(converter(neighborhood.getCity()));
		return entity;
	}
	
	
	private static Street converter(StreetTO street) {
		Street entity = new Street();
		entity.setId(street.getId());
		entity.setStreetName(street.getStreetName());
		entity.setHood(converter(street.getHood()));
		return entity;
	}

	

	public static PlaceTO converter(Place place) {
		PlaceTO to = new PlaceTO();
		to.setAddress(place.getAddress());
		return to;
	}

	public static CountryTO converter(Country country) {
		CountryTO to = new CountryTO();
		to.setId(country.getId());
		to.setName(country.getName());
		return to;
	}

	public static RegionTO converter(Region region) {
		RegionTO to = new RegionTO();
		to.setId(region.getId());
		to.setName(region.getName());
		to.setCountry(converter(region.getCountry()));
		return to;
	}

	public static CityTO converter(City city) {
		CityTO to = new CityTO();
		to.setId(city.getId());
		to.setName(city.getName());
		to.setRegion(converter(city.getRegion()));
		return to;
	}

	public static NeighborhoodTO converter(Neighborhood neigh) {
		NeighborhoodTO to = new NeighborhoodTO();
		to.setId(neigh.getId());
		to.setName(neigh.getHoodName());
		to.setCity(converter(neigh.getCity()));
		return to;
	}

	public static StreetTO converter(Street street) {
		StreetTO to = new StreetTO();
		to.setId(street.getId());
		to.setStreetName(street.getStreetName());
		to.setHood(converter(street.getHood()));
		return to;
	}

}
