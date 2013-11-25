package br.com.findplaces.webservices;

import java.io.File;
import java.io.Serializable;

import javax.activation.MimetypesFileTypeMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.findplaces.ejb.ImageConfigurations;
import br.com.findplaces.model.to.PhotoTO;
import br.com.findplaces.responses.webservices.ImageResponse;
import br.com.findplaces.utils.Validator;
import br.com.findplaces.webservices.enumerator.StatusCode;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;
import br.com.findplaces.webservices.requests.BaseJSONObject;
import br.com.findplaces.webservices.requests.ImageServiceRequest;

@Path("/image")
@Stateless
public class ImageService implements Serializable {

	private static final long serialVersionUID = 36362838870786307L;
	
	@EJB
	private ImageConfigurations imgEJB;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON })
	public ImageResponse saveImage(@FormParam(value="image")ImageServiceRequest request) throws Exception{
		
		ImageResponse response = new ImageResponse();
		
		try {
			Validator.isValidToken(request.getToken(), request.getUserID());
			isCorrectFormat(request);
			
			PhotoTO photoTO = new PhotoTO();
			photoTO.setFile(request.getBase64IMG());
			imgEJB.savePhoto(photoTO, request.getFormat());
			response.setImageID(imgEJB.savePhoto(photoTO, request.getFormat()).getId());
			
			setSuccessResponse(response);
		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} 

		return response;
	}

	private void isCorrectFormat(ImageServiceRequest request) throws Exception { //TODO REFACT NAME
		if(!"jpg".equals(request.getFormat()) && !"png".equals(request.getFormat())){
			throw new Exception();
		}
	}

	@GET
	@Path("/{id}")
	@Produces("image/*")
	public Response getImage(@PathParam(value = "id") Long imageID) {

		PhotoTO photo = imgEJB.findPhotoById(imageID);
		
		if(photo==null){
			throw new WebApplicationException(404);
		}

		File photoOnDisk = new File(photo.getUrl());

		if (!photoOnDisk.exists()) {
			throw new WebApplicationException(404);
		}

		String mt = new MimetypesFileTypeMap().getContentType(photoOnDisk);

		return Response.ok(photoOnDisk, mt).build();
	}
	
	private void setSuccessResponse(BaseJSONObject response) {
		response.setCode(StatusCode.SUCCESS.getCode());
		response.setMessage(StatusCode.SUCCESS.getMessage());
	}

	private void setErrorResponse(BaseJSONObject response, StatusCode error) {
		response.setCode(error.getCode());
		response.setMessage(error.getMessage());
	}
	
	

}
