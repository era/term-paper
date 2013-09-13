package br.com.findplaces.ejb;

import java.io.Serializable;
import java.util.List;

import br.com.findplaces.model.geographic.to.CityTO;
import br.com.findplaces.model.geographic.to.NeighborhoodTO;
import br.com.findplaces.model.geographic.to.StreetTO;
import br.com.findplaces.model.to.PlaceTO;


public interface PlaceConfigurations extends Serializable {
	
	PlaceTO findPlaceById(Long id);
	
	CityTO findCityByName(String name);
	
	StreetTO findStreetByName(String name);
	
	NeighborhoodTO findNeighborhoodByName(String name);	
	
	PlaceTO createPlace(PlaceTO place);

	List<PlaceTO> findPlaceByLatLogDistance(Double lat, Double log, Double distance);
	

}
