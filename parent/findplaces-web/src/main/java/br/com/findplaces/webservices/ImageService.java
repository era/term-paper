package br.com.findplaces.webservices;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.findplaces.responses.webservices.ImageResponse;
import br.com.findplaces.webservices.requests.ImageServiceRequest;

@Path("/image")
@Stateless
public class ImageService implements Serializable {

	private static final long serialVersionUID = 36362838870786307L;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON })
	public ImageResponse saveImage(@FormParam(value="image")ImageServiceRequest request){
		return null;
	}
	
	@GET
	@Path("/{id}")
	@Produces("image/*")
	public Response getImage(@PathParam(value="id")Integer imageID){
		/*File f = new File(image);

	     if (!f.exists()) {
	         throw new WebApplicationException(404);
	     }

	     String mt = new MimetypesFileTypeMap().getContentType(f);
	     return Response.ok(f, mt).build();*/
		return null;
	}
	
	

}
