package br.com.findplaces.webservices;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.findplaces.webservices.requests.FilterSearchRequest;
import br.com.findplaces.webservices.requests.InsertPlaceRequest;
import br.com.findplaces.webservices.responses.PlaceResponse;

@Path("/place")
@Stateless
public class PlaceService implements Serializable {

	private static final long serialVersionUID = -1278778592971168795L;
	
	//TODO EJB for Places
	
	@GET
	@Path("/search/bylatlong")
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse searchByLatLong(@QueryParam(value = "token") String token,
			@QueryParam(value = "lat") String latitude,
			@QueryParam(value = "long") String longitude){
		
		return null;
	}
	
	@GET
	@Path("/search/byFilter")
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse searchByFilter(@QueryParam(value = "token") String token,
			@QueryParam(value = "filter") FilterSearchRequest filter){
		
		return null;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse insertPlace(@FormParam(value="place") InsertPlaceRequest request ){
		return null;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON })
	public PlaceResponse updatePlace(@FormParam(value="place") InsertPlaceRequest request ){
		return null;
	}
	

}
