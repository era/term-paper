package br.com.findplaces.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.findplaces.helpers.ApartmentHelper;
import br.com.findplaces.model.to.ApartmentTO;
import br.com.findplaces.usermodule.ejb.Apartment;
import br.com.findplaces.usermodule.exceptions.CouldNotFindAddressException;

import com.restfb.DefaultFacebookClient;

@ManagedBean(name = "apartmentMB")
@ViewScoped
public class ApartmentMB {
		
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginMB.class);
	
	@EJB(mappedName = "java:global/UserModule-1.0.0.0-SNAPSHOT/UserLoginEJB!br.com.findplaces.usermodule.ejb.Apartment")
	private Apartment apertment;

	private HttpServletRequest request;

	private DefaultFacebookClient facebook;
	
	private ApartmentTO apartmentTO;
	
	private String confirmPassword;
	
	private List<String> errors;

	public ApartmentMB() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) context.getRequest();
	}
	
	public void saveConfiguration() throws CouldNotFindAddressException{
		//validação do endereço		
		errors = ApartmentHelper.validadeAddres(apartmentTO, apartmentTO.getAddress());
		if(errors.isEmpty()){
			apertment.saveApartment(apartmentTO);
		}
		
	}

}
