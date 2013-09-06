package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.SellerConfigurations;
import br.com.findplaces.jpa.dao.interfaces.UserDAO;
import br.com.findplaces.model.to.SellerTO;

@Stateless(name="SellerConfigurationsEJB", mappedName = "SellerConfigurationsImpl")
public class SellerConfigurationsImpl implements SellerConfigurations {

	private static final long serialVersionUID = 6479710749466072878L;

	@EJB
	private UserDAO userDAO;
	
	@Override
	public void saveConfigurations(SellerTO seller) {
		
	}

}
