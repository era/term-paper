package br.com.findplaces.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.findplaces.helpers.SellerHelper;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.usermodule.ejb.SellerConfigurations;

@ManagedBean(name = "loginMB")
@ViewScoped
public class SellerMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private SellerTO seller;
	
	private List<String> errors;
	
	@EJB(mappedName = "java:global/UserModule-1.0.0.0-SNAPSHOT/SellerConfigurationsEJB!br.com.findplaces.usermodule.ejb.SellerConfigurations")
	private SellerConfigurations sellerEJB;
	
	public void saveConfiguration(){
		errors = SellerHelper.validateForm(seller);
		
		if(errors.isEmpty()){
			sellerEJB.saveConfigurations(seller);
		}
	}

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
