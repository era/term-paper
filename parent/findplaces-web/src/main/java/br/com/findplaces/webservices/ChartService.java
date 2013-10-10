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

@Path("/chart")
@Stateless
public class ChartService implements Serializable {

	private static final long serialVersionUID = 7832024951228110070L;
	
	@EJB
	private DataMiningEJB dataMining;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/place/{id}")
	public void getViewsFromPlaceChart(@PathParam("id") Long id, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/place")
	public void getViewsFromNeighborhood(@QueryParam("name") String name, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/user/age")
	public void getAgeFromUsers(@QueryParam("id") Long id, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/user/likes")
	public void getLikes(@QueryParam("name") String name, @QueryParam("userID") String userID,
			@QueryParam("token") String token){
		
	}
	
	
}
