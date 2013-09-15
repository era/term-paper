package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.model.to.UserTO;

public interface DataMiningEJB extends Serializable {
	
	PlaceTO sugestPlaceByUser(UserTO user);
	
	void saveResultFromTest(String algorithm, Integer liked, UserTO user);
	
}
