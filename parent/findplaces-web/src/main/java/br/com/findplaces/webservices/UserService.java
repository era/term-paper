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
import br.com.findplaces.exceptions.CouldNotFindUserException;
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
	@Path("/{id}") //FIXME
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse getUser(@QueryParam(value = "token") String token,
			@QueryParam(value = "type") String type,
			@QueryParam(value = "password") String password,
			@QueryParam(value = "email") String email,
			@PathParam(value = "id") String id) {
		UserResponse response = new UserResponse();
		UserTO userTO = null;
		try {
			if(UserLogin.FACEBOOK_USER.equals(type)){
				userTO = getUserFromFacebook(token, id);
			} else if(UserLogin.EMAIL_USER.equals(type) && password != null && !password.isEmpty()) {
				userTO = userLogin.findUserByEmailAndPassword(email, password);
				response.setToken(userLogin.generateTokenForUser(userTO));
			} else if(UserLogin.EMAIL_USER.equals(type)) {
				response.setToken(userLogin.isValidToken(token, Long.valueOf(id)));
				userTO = userLogin.findUserById(Long.valueOf(id));
			}
			userTO.setPassword(null); //FIXME
			response.setUser(userTO);
			setSuccessResponse(response);
			
		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}

		return response;
	}


	private UserTO getUserFromFacebook(String token, String id)
			throws NotAuthorizedException, CouldNotFindUserException {
		Validator.isValidToken(token, id);
		UserTO userTO = getUserLogin().findUserBySocialID(id);
		return userTO;
	}


	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public UserResponse insertUser(
			@FormParam(value = "user") UserServiceRequest request) {
		UserResponse response = new UserResponse();
		UserTO user =  null;
		try {
			if(request.getUserFacebookID() !=null && !request.getUserFacebookID().isEmpty()) {
				user = getUserFromFacebook(request);
			} else {
				user = createUserWithEmailAndPassword(request);
				response.setToken(userLogin.generateTokenForUser(user));
			}
			
			UserTO createdUser = getUserLogin().createUser(user);
			createdUser.setPassword(null); //FIXME
			
			response.setUser(createdUser);
			setSuccessResponse(response);

		} catch (NotAuthorizedException e) {
			setErrorResponse(response, StatusCode.NOT_ALLOWED);
		} catch (Exception e) {
			setErrorResponse(response, StatusCode.ERROR);
		}
		return response;
	}


	private UserTO createUserWithEmailAndPassword(UserServiceRequest request) {
		UserTO user;
		user = new UserTO();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setName(request.getName());
		
		UserTypeTO userType = new UserTypeTO();
		userType.setId(UserTypeTO.USER_EMAIL);
		
		user.setType(userType);
		return user;
	}


	private UserTO getUserFromFacebook(UserServiceRequest request)
			throws NotAuthorizedException {
		UserTO user;
		Validator.isValidToken(request.getToken(), request.getUserFacebookID());
		user = FacebookUtils.getUser(request.getToken());
		user.setLikes(FacebookUtils.getLikesFromUser(request.getToken(), user));
		UserTypeTO type = new UserTypeTO();
		type.setId(UserTypeTO.USER_FB_ID);
		user.setType(type);
		return user;
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