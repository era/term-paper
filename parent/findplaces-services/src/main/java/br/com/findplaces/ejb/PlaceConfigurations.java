package br.com.findplaces.ejb;

import java.io.Serializable;

import br.com.findplaces.model.to.PlaceTO;


public interface PlaceConfigurations extends Serializable {
	
	PlaceTO findPlaceById(Long id);
	
	PlaceTO createPlace(PlaceTO place);

}
