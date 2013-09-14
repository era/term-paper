package br.com.findplaces.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

import br.com.findplaces.model.to.SellerTO;

@Deprecated
public interface SellerConfigurations extends Serializable {
	
	void saveConfigurations(SellerTO seller);
	

	SellerTO findBySocialId(String socialid);

}
