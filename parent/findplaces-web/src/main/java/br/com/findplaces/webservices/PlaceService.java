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
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import br.com.findplaces.ejb.PlaceConfiguration;
import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.responses.webservices.PlaceResponse;
import br.com.findplaces.utils.FacebookUtils;
import br.com.findplaces.webservices.enumerator.StatusCode;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;
import br.com.findplaces.webservices.requests.BaseJSONObject;
import br.com.findplaces.webservices.requests.FilterSearchRequest;
import br.com.findplaces.webservices.requests.InsertPlaceRequest;

@Path("/place")
@Stateless
public class PlaceService implements Serializable {

	private static final long serialVersionUID = -1278778592971168795L;	

	@EJB
	private PlaceConfiguration place;
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// TODO EJB for Places
	
	
	@GET
	@Path("/placetest")
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse getPlace() {
		PlaceResponse response = new PlaceResponse();
		try {
			//isValidToken(token, id);
			place = getPlaceConfiguration();
			PlaceTO to = new PlaceTO();
			PlaceTO placeTO = place.createPlace(to);
			List<PlaceTO> places = new ArrayList<PlaceTO>();
			places.add(placeTO);
			response.setPlaces(places);
			
			setSuccessResponse(response);
		} catch (Exception e) {
			setErrorResponse(response);
		}
		
		return response;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse getUser(@QueryParam(value = "token") String token,
			@QueryParam(value = "type") String type,
			@PathParam(value = "id") String id) {
		PlaceResponse response = new PlaceResponse();
		try {
			//isValidToken(token, id);
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
	public PlaceResponse searchByLatLong(@QueryParam(value = "token") String token, @QueryParam(value = "lat") String latitude,
			@QueryParam(value = "long") String longitude) {

		return null;
	}

	@GET
	@Path("/search/byFilter")
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse searchByFilter(@QueryParam(value = "token") String token, @QueryParam(value = "filter") FilterSearchRequest filter) {

		return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse insertPlace(@FormParam(value = "place") String request, @Context HttpServletResponse servletResponse) {
		// PlaceTO address = request.fromString(json);
		String re = request;
		System.out.println(re);
		return new PlaceResponse();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public PlaceResponse updatePlace(@FormParam(value = "place") InsertPlaceRequest request) {
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
	
	private void isValidToken(String token, String id) throws NotAuthorizedException{
		if(!FacebookUtils.isValidToken(token, id)){
			throw new NotAuthorizedException();
		}
	}


	public PlaceConfiguration getPlaceConfiguration() {
		return place;
	}

	public void setPlaceConfiguration(PlaceConfiguration place) {
		this.place = place;
	}

}
