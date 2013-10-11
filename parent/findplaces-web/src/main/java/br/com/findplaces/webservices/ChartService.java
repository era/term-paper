package br.com.findplaces.webservices;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.findplaces.ejb.DataMiningEJB;
import br.com.findplaces.responses.webservices.FindAgeForUsersResponse;
import br.com.findplaces.responses.webservices.FindLikesForUsersResponse;
import br.com.findplaces.responses.webservices.ViewsFromPlaceResponse;
import br.com.findplaces.utils.Validator;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;

@Path("/chart")
@Stateless
public class ChartService implements Serializable {

	private static final long serialVersionUID = 7832024951228110070L;
	
	@EJB
	private DataMiningEJB dataMining;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/place/{id}")
	public ViewsFromPlaceResponse getViewsFromPlaceChart(@PathParam("id") Long id, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		ViewsFromPlaceResponse response = new ViewsFromPlaceResponse();
		try {
			Validator.isValidToken(token, userID);
			
			response.setViews(dataMining.getPlaceViews(id));
			response.setCode(0);
			response.setMessage("Everything was just fine");
		} catch (NotAuthorizedException e) {
			response.setCode(1);
			response.setMessage("Oppsss, seems you are not logged in");
		}
		
		return response;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/place")
	public ViewsFromPlaceResponse getViewsFromNeighborhood(@QueryParam("name") String name, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		
		ViewsFromPlaceResponse response = new ViewsFromPlaceResponse();
		try {
			Validator.isValidToken(token, userID);
			
			response.setViews(dataMining.getNeighboordViews(name));
			response.setCode(0);
			response.setMessage("Everything was just fine");
		} catch (NotAuthorizedException e) {
			response.setCode(1);
			response.setMessage("Oppsss, seems you are not logged in");
		}
		
		return response;
	}
		
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/user/age")
	public FindAgeForUsersResponse getAgeFromUsers(@QueryParam("placeID") Long id, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		FindAgeForUsersResponse response = new FindAgeForUsersResponse();
		try {
			Validator.isValidToken(token, userID);
			
			response.setAgeFromUsers(dataMining.getAgeFromUsers(id));
			response.setCode(0);
			response.setMessage("Everything was just fine");
		} catch (NotAuthorizedException e) {
			response.setCode(1);
			response.setMessage("Oppsss, seems you are not logged in");
		}
		
		return response;
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/user/likes")
	public FindLikesForUsersResponse getLikes(@QueryParam("placeID") Long placeID, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		FindLikesForUsersResponse response = new FindLikesForUsersResponse();
		try {
			Validator.isValidToken(token, userID);
			
			response.setLikesFromUsers(dataMining.getLikesFromUsers(placeID));
			response.setCode(0);
			response.setMessage("Everything was just fine");
		} catch (NotAuthorizedException e) {
			response.setCode(1);
			response.setMessage("Oppsss, seems you are not logged in");
		}
		
		return response;
		
	}
	
	
}
