package br.com.findplaces.webservices;

import java.io.Serializable;

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

import br.com.findplaces.ejb.UserLogin;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.UserTypeTO;
import br.com.findplaces.responses.webservices.SellerResponse;
import br.com.findplaces.responses.webservices.UserResponse;
import br.com.findplaces.utils.FacebookUtils;
import br.com.findplaces.utils.Validator;
import br.com.findplaces.webservices.enumerator.StatusCode;
import br.com.findplaces.webservices.exceptions.NotAuthorizedException;
import br.com.findplaces.webservices.requests.BaseJSONObject;
import br.com.findplaces.webservices.requests.UserServiceRequest;

@Path("/user")
@Stateless
public class UserService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserLogin userLogin;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse getUser(@QueryParam(value = "token") String token,
			@QueryParam(value = "type") String type,
			@PathParam(value = "id") String id) {
		UserResponse response = new UserResponse();
		try {
			Validator.isValidToken(token, id);
			UserTO userTO = getUserLogin().findUserBySocialID(id);
			response.setUser(userTO);
			setSuccessResponse(response);
		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}

		return response;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse insertUser(
			@FormParam(value = "user") UserServiceRequest request) {
		UserResponse response = new UserResponse();
		try {
			Validator.isValidToken(request.getToken(), request.getUserFacebookID());

			UserTO user = FacebookUtils.getUser(request.getToken());
			UserTypeTO type = new UserTypeTO();
			type.setId(UserTypeTO.USER_FB_ID);
			user.setType(type);

			UserTO createdUser = getUserLogin().createUser(user);
			response.setUser(createdUser);
			setSuccessResponse(response);

		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}
		return response;
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/seller")
	public SellerResponse changeUserToSeller(
			@FormParam(value = "user") UserServiceRequest request) {
		SellerResponse response = new SellerResponse();
		try {
			Validator.isValidToken(request.getToken(), request.getUserFacebookID());

			if (request.getSellerTO() == null
					|| request.getSellerTO().getUserTO() == null) {
				request.setSellerTO(new SellerTO());
				request.getSellerTO().setUserTO(
						userLogin.findUserBySocialID(request
								.getUserFacebookID()));
			}

			SellerTO sellerSaved = userLogin.saveSeller(request.getSellerTO());
			response.setSeller(sellerSaved);

			setSuccessResponse(response);

		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}
		return response;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/seller/{id}")
	public SellerResponse findSeller(@QueryParam(value = "token") String token,
			@QueryParam(value = "type") String type,
			@PathParam(value = "id") String id) {
		SellerResponse response = new SellerResponse();
		try {
			Validator.isValidToken(token, id);

			SellerTO findSeller = userLogin.findSeller(id);

			response.setSeller(findSeller);

			setSuccessResponse(response);

		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}
		return response;
	}

	private void setSuccessResponse(BaseJSONObject response) {
		response.setCode(StatusCode.SUCCESS.getCode());
		response.setMessage(StatusCode.SUCCESS.getMessage());
	}

	private void setErrorResponse(BaseJSONObject response, StatusCode error) {
		response.setCode(error.getCode());
		response.setMessage(error.getMessage());
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

}