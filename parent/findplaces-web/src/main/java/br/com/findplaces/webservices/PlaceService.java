package br.com.findplaces.webservices;

import java.io.Serializable;
import java.util.ArrayList;
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

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.ejb.SellerConfigurations;
import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.exceptions.CouldNotFindUserException;
import br.com.findplaces.exceptions.TokenInvalidException;
import br.com.findplaces.model.to.FacilitiesTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.responses.webservices.PlaceResponse;
import br.com.findplaces.utils.FacebookUtils;
import br.com.findplaces.webservices.enumerator.StatusCode;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;
import br.com.findplaces.webservices.requests.BaseJSONObject;
import br.com.findplaces.webservices.requests.FilterSearchRequest;
import br.com.findplaces.webservices.requests.PlaceRequest;

@Path("/place")
@Stateless
public class PlaceService implements Serializable {

	private static final long serialVersionUID = -1278778592971168795L;

	@EJB
	private PlaceConfigurations place;

	@EJB
	private SellerConfigurations seller;
	
	@EJB
	private UserLogin userEJB;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse getPlace(@QueryParam(value = "token") String token,
			@QueryParam(value = "type") String type,
			@PathParam(value = "id") String id) {
		PlaceResponse response = new PlaceResponse();
		try {
			isValidToken(token, id);
			Long ide = Long.parseLong(id);
			PlaceTO to = getPlaceConfiguration().findPlaceById(ide);
			List<PlaceTO> list = new ArrayList<PlaceTO>();
			list.add(to);
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
			@QueryParam(value = "log") String longitude,
			@QueryParam(value = "distance") String distance)
			throws NotAuthorizedException {
		if (token == null && socialid == null) {
			return searchByLatLong(latitude, longitude, distance);
		}
		isValidToken(token, socialid);

		List<PlaceTO> places = getPlaceConfiguration()
				.findPlaceByLatLogDistance(Double.parseDouble(latitude),
						Double.parseDouble(longitude),
						Double.parseDouble(distance));
		PlaceResponse response = new PlaceResponse();

		response.setPlaces(places);
		setSuccessResponse(response);

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
	public PlaceResponse searchByFilter(
			@QueryParam(value = "token") String token,
			@QueryParam(value = "filter") FilterSearchRequest filter) throws NotAuthorizedException {

		String socialid = null;
		String latitude = null;
		String longitude = null;
		String distance = null;

		isValidToken(token, socialid);

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

}
