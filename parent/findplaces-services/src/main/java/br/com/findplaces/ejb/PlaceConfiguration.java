package br.com.findplaces.ejb;

import java.io.Serializable;

import javax.ejb.Remote;

import br.com.findplaces.model.to.PlaceTO;

@Remote
public interface PlaceConfiguration extends Serializable {
	
	PlaceTO findPlaceById(Long id);
	
	PlaceTO createPlace(PlaceTO place);

}
