package br.com.findplaces.webservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.findplaces.ejb.PlaceConfigurations;
import br.com.findplaces.ejb.SellerConfigurations;
import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.PlaceTypeTO;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
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
			@QueryParam(value = "distance") String distance) throws NotAuthorizedException {
		if (token == null && socialid == null) {
			return searchByLatLong(latitude, longitude, distance);
		}
		isValidToken(token, socialid);
		
		List<PlaceTO> places = getPlaceConfiguration().findPlaceByLatLogDistance(
				Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(distance));
		PlaceResponse response = new PlaceResponse();
		
		response.setPlaces(places);
		setSuccessResponse(response);

		return response;
	}
	
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByLatLong(String latitude, String longitude,	String distance) throws NotAuthorizedException {	
		
		List<PlaceTO> places = getPlaceConfiguration().findPlaceByLatLogDistance(
				Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(distance));
		PlaceResponse response = new PlaceResponse();
		
		response.setPlaces(places);
		setSuccessResponse(response);

		return response;
	}

	@GET
	@Path("/search/byFilter")
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByFilter(@QueryParam(value = "token") String token,
			@QueryParam(value = "filter") FilterSearchRequest filter) {

		return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse insertPlace(@FormParam(value = "place") PlaceRequest request,
			@Context HttpServletResponse servletResponse) throws NotAuthorizedException {

		//Validação do Token e User SocialID
		PlaceRequest re = request;
		String socialId = re.getSocialId();		
		SellerTO sellerTO = getSellerConfigurations().findBySocialId(socialId);		
		UserTO userTO = sellerTO.getUserTO();
		isValidToken(re.getToken(), userTO.getSocialID());
		
		//PlaceType - Tipo de casa
		PlaceTypeTO typeTO = re.getPlacetype();
		typeTO.setId(re.getPlacetype().getId());
		
		//Busca MUB(Dados geograficos)
		NeighborhoodTO neighTo = re.getNeighborhood();
		neighTo = getPlaceConfiguration().findNeighborhoodByName(neighTo.getName());
		StreetTO streetTo = re.getStreet();
		streetTo = getPlaceConfiguration().findStreetByName(streetTo.getStreetName());
		CityTO cityTo = re.getCity();
		cityTo = getPlaceConfiguration().findCityByName(cityTo.getName());
		
		//Conversao das buscas para o PlaceTO a ser criado
		PlaceTO to = new PlaceTO();
		to.setAddress(re.getAddress());
		to.setCity(cityTo);
		to.setNeighborhood(neighTo);
		to.setStreet(streetTo);
		to.setDescription(re.getDescription());
		to.setType(re.getPlacetype());
		to.setLat(re.getLat());
		to.setLog(re.getLog());
		to.setSeller(sellerTO);
		
		//Criacao
		PlaceTO placeCreated = getPlaceConfiguration().createPlace(to);
		//Resposta
		PlaceResponse response = new PlaceResponse();
		List<PlaceTO> list = new ArrayList<PlaceTO>();
		list.add(placeCreated);
		response.setPlaces(list);
		setSuccessResponse(response);

		return response;
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
	
	

}
