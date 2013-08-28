package br.com.findplaces.usermodule.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.findplaces.jpa.dao.impl.interfaces.UserDAO;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.usermodule.ejb.SellerConfigurations;

@Stateless(name="SellerConfigurationsEJB", mappedName = "SellerConfigurationsImpl")
@Remote(SellerConfigurations.class)
public class SellerConfigurationsImpl implements SellerConfigurations {

	private static final long serialVersionUID = 6479710749466072878L;

	@EJB
	private UserDAO userDAO;
	
	@Override
	public void saveConfigurations(SellerTO seller) {
		
	}

}
