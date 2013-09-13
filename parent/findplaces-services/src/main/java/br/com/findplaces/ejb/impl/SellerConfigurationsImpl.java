package br.com.findplaces.ejb.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.findplaces.ejb.SellerConfigurations;
import br.com.findplaces.jpa.dao.interfaces.SellerDAO;
import br.com.findplaces.jpa.entity.Seller;
import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.util.ConverterTO;

@Stateless(name="SellerConfigurationsEJB", mappedName = "SellerConfigurationsImpl")
public class SellerConfigurationsImpl implements SellerConfigurations {

	private static final long serialVersionUID = 6479710749466072878L;

	@EJB
	private SellerDAO sellerDAO;
	
	@Override
	public void saveConfigurations(SellerTO seller) {
		
	}

	@Override
	public SellerTO findBySocialId(String socialid) {
		
		Seller seller = sellerDAO.findSellerByUserSocialId(socialid);
		
		return ConverterTO.converter(seller);
	}

}
