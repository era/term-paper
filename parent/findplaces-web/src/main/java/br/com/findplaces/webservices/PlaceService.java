package br.com.findplaces.webservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.findplaces.ejb.DataMiningEJB;
import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.ejb.SellerConfigurations;
import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.exceptions.CouldNotFindUserException;
import br.com.findplaces.exceptions.TokenInvalidException;
import br.com.findplaces.jpa.entity.datamining.PlaceViewed;
import br.com.findplaces.model.to.FacilitiesTO;
import br.com.findplaces.model.to.FilterSearchRequest;
import br.com.findplaces.model.to.PlaceRequest;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.responses.webservices.PlaceResponse;
import br.com.findplaces.util.ConverterTO;
import br.com.findplaces.utils.FacebookUtils;
import br.com.findplaces.webservices.enumerator.StatusCode;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;
import br.com.findplaces.webservices.requests.BaseJSONObject;

@Path("/place")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
public class PlaceService implements Serializable {

	private static final long serialVersionUID = -1278778592971168795L;

	@EJB
	private PlaceConfigurations place;

	@EJB
	private SellerConfigurations seller;
	
	@EJB
	private UserLogin userEJB;
	
	@EJB
	private DataMiningEJB dataminingEJB;
	
	@POST
	@Path("/coment")
	public PlaceResponse coment(@QueryParam(value= "token") String token,
			@QueryParam(value="socialID") String socialID,
			@QueryParam(value="comentID")Long comentID){
		return null;
	}
	
	@GET
	@Path("/sugest")
	public PlaceResponse sugestPlace(@QueryParam(value="socialID") String socialID,
			@QueryParam(value="token") String token){
		return null;
	}


	@GET
	@Path("/{id}")
	public PlaceResponse getPlace(@QueryParam(value = "token") String token,
			@QueryParam(value = "socialID") String socialID,
			@PathParam(value = "id") Long id) {
		PlaceResponse response = new PlaceResponse();
		UserTO user = null;
		PlaceViewed viewed = new PlaceViewed();
		try {
			if(socialID != null){
				isValidToken(token, socialID);
				user = userEJB.findUserBySocialID(socialID);
				viewed.setUser(ConverterTO.converter(user)); //FIXME should not use User here
			}
			PlaceTO placeTO = getPlaceConfiguration().findPlaceById(id);
			
			viewed.setPlace(ConverterTO.converter(placeTO)); //FIXME should not use Place here
			viewed.setDate(new Date());
			
			dataminingEJB.savePlaceViewed(viewed);
			
			List<PlaceTO> list = new ArrayList<PlaceTO>();
			list.add(placeTO);
			response.setPlaces(list);
			setSuccessResponse(response);
		} catch (Exception e) {
			setErrorResponse(response);
		}

		return response;
	}

	@GET
	@Path("/search/bylatlong")
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByLatLong(
			@QueryParam(value = "token") String token,
			@QueryParam(value = "socialid") String socialid,
			@QueryParam(value = "lat") String latitude,
			@QueryParam(value = "lng") String longitude,
			@QueryParam(value = "distance") String distance)
			throws NotAuthorizedException {
		if (token != null && socialid != null) {
			isValidToken(token, socialid);
		}
		
		PlaceResponse response = searchByLatLong(latitude, longitude, distance);;

		return response;
	}

	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByLatLong(String latitude, String longitude,
			String distance) throws NotAuthorizedException {

		List<PlaceTO> places = getPlaceConfiguration()
				.findPlaceByLatLogDistance(Double.parseDouble(latitude),
						Double.parseDouble(longitude),
						Double.parseDouble(distance));
		PlaceResponse response = new PlaceResponse();

		response.setPlaces(places);
		setSuccessResponse(response);

		return response;
	}

	@GET
	@Path("/search/byFilter")
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByFilter(@QueryParam(value = "filter") FilterSearchRequest filter) 
			throws NotAuthorizedException {

		if(filter.getSocialid() !=null && !filter.getSocialid().isEmpty()){
			isValidToken(filter.getToken(), filter.getSocialid());
		}
		
		
		getPlaceConfiguration().findByFilter(filter);

//		List<PlaceTO> places = getPlaceConfiguration().findByFilter(Double.parseDouble(latitude),
//						Double.parseDouble(longitude),
//						Double.parseDouble(distance));
		PlaceResponse response = new PlaceResponse();

		//response.setPlaces(places);
		setSuccessResponse(response);

		return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse insertPlace(
			@FormParam(value = "place") PlaceRequest request)
			throws NotAuthorizedException, TokenInvalidException, CouldNotFindUserException { //FIXME Shouldn't throw excpetion for the user.
		
		//FIXME This method is responsible for more than one thing.

		SellerTO sellerTO = request.getSocialid()!=null && !request.getSocialid().isEmpty() ? getSellerFromFacebook(request)
					: getSellerFromEmail(request);

		request.getPlacetype().setId(request.getPlacetype().getId());

		PlaceTO place = convertToPlaceTO(request, sellerTO);

		place = getPlaceConfiguration().createPlace(place);

		PlaceResponse response = new PlaceResponse();
		List<PlaceTO> list = new ArrayList<PlaceTO>();
		list.add(place);
		response.setPlaces(list);
		setSuccessResponse(response);

		return response;
	}

	private SellerTO getSellerFromEmail(PlaceRequest request) throws TokenInvalidException, CouldNotFindUserException {
		
		userEJB.isValidToken(request.getToken(), request.getUserID());
		
		
		return userEJB.findSeller(request.getUserID());
	}

	//FIXME This Shouldnt be in this class
	private PlaceTO convertToPlaceTO(PlaceRequest re, SellerTO sellerTO) {
		PlaceTO to = new PlaceTO();
		
		to.setSeller(sellerTO);
		to.setCity(re.getCity());
		to.setNeighborhood(re.getNeighborhood());
		to.setStreet(re.getStreet());
		to.setType(re.getPlacetype());
		
		
		to.setLat(re.getLat());
		to.setLog(re.getLog());		
		to.setAddress(re.getAddress());
		to.setBathroom(re.getBathroom());
		to.setBedroom(re.getBedroom());		
		to.setCode(re.getCode());
		to.setComplexPrice(re.getComplexPrice());
		to.setDescription(re.getDescription());
		to.setGarage(re.getGarage());
		to.setM2(re.getM2());
		to.setPrice(re.getPrice());
		to.setRoom(re.getRoom());
		
		ArrayList<Long> sellTypes = new ArrayList<Long>();
		
		for(Long sellType : re.getSellType()){
			sellTypes.add(sellType);
		}
		
		to.setSellType(sellTypes);
		
		to.setSuite(re.getSuite());
		to.setFacilities(new FacilitiesTO()); //TODO Refact to make this work
		return to;
	}

	private SellerTO getSellerFromFacebook(PlaceRequest re) throws NotAuthorizedException {
		SellerTO sellerTO = getSellerConfigurations().findBySocialId(re.getSocialid());
		isValidToken(re.getToken(), sellerTO.getUserTO().getSocialID());
		return sellerTO;
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse updatePlace(
			@FormParam(value = "place") PlaceRequest request) {
		return null;
	}

	private void setSuccessResponse(BaseJSONObject response) {
		response.setCode(StatusCode.SUCCESS.getCode());
		response.setMessage(StatusCode.SUCCESS.getMessage());
	}

	private void setErrorResponse(BaseJSONObject response) {
		response.setCode(StatusCode.ERROR.getCode());
		response.setMessage(StatusCode.ERROR.getMessage());
	}

	private void isValidToken(String token, String id)
			throws NotAuthorizedException {
		if (!FacebookUtils.isValidToken(token, id)) {
			throw new NotAuthorizedException();
		}
	}

	public PlaceConfigurations getPlaceConfiguration() {
		return place;
	}

	public void setPlaceConfiguration(PlaceConfigurations place) {
		this.place = place;
	}

	public SellerConfigurations getSellerConfigurations() {
		return seller;
	}

	public void setSellerConfigurations(SellerConfigurations seller) {
		this.seller = seller;
	}

	public UserLogin getUserEJB() {
		return userEJB;
	}

	public void setUserEJB(UserLogin userEJB) {
		this.userEJB = userEJB;
	}

	public DataMiningEJB getDataminingEJB() {
		return dataminingEJB;
	}

	public void setDataminingEJB(DataMiningEJB dataminingEJB) {
		this.dataminingEJB = dataminingEJB;
	}

}
