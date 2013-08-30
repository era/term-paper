package br.com.findplaces.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.findplaces.controller.ApartmentRepository;
import br.com.findplaces.model.impl.Apartment;
import br.com.findplaces.service.impl.ApartmentService;

@Path("/apartment")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ApartmentREST {

	@Inject
	private Logger log;

	@Inject
	private Validator validator;

	@Inject
	private ApartmentRepository repository;

	@Inject
	ApartmentService registration;

	@GET
	@Path("/apartments")
	public Collection<Apartment> getApartments() {
		return null;

	}

	@GET
	@Path("/apartment/{isbn}")
	public Apartment getApartment(@PathParam("isbn") String id) {
		Long idt = Long.parseLong(id);
		Apartment member = repository.findById(idt);
		if (member == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return member;

	}

	@PUT
    @Path("/apartment/{isbn}")
    public Apartment addApartment(@PathParam("email") String email, @QueryParam("phone_number") String phoneNumber) {
    	 try {
    		 Apartment member = new Apartment();
    		 member.setName("mateus"+Math.random());
    		 member.setEmail(email);
    		 member.setPhoneNumber(phoneNumber);
             // Validates member using bean validation
             validateMember(member);

             registration.register(member);

             // Create an "ok" response
             //builder = Response.ok();
         } catch (ConstraintViolationException ce) {
             // Handle bean validation issues
           //  builder = createViolationResponse(ce.getConstraintViolations());
         } catch (ValidationException e) {
             // Handle the unique constrain violation
             Map<String, String> responseObj = new HashMap<String, String>();
             responseObj.put("email", "Email taken");
          //   builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
         } catch (Exception e) {
             // Handle generic exceptions
             Map<String, String> responseObj = new HashMap<String, String>();
             responseObj.put("error", e.getMessage());
           //  builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
         }

         return new Apartment();//builder.build();
    
    }

	public boolean emailAlreadyExists(String email) {
		Apartment member = null;
		try {
			member = repository.findByEmail(email);
		} catch (NoResultException e) {
			// ignore
		}
		return member != null;
	}

	private void validateMember(Apartment member) throws ConstraintViolationException, ValidationException {
		// Create a bean validator and check for issues.
		Set<ConstraintViolation<Apartment>> violations = validator.validate(member);

		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}

		// Check the uniqueness of the email address
		if (emailAlreadyExists(member.getEmail())) {
			throw new ValidationException("Unique Email Violation");
		}
	}

	@POST
	@Path("/apartment/{isbn}")
	public Apartment updateApartent(@PathParam("isbn") String id, String title) {
		return null;

	}

	@DELETE
	@Path("/apartment/{isbn}")
	public Apartment removeApartment(@PathParam("isbn") String id) {
		return null;

	}
}
