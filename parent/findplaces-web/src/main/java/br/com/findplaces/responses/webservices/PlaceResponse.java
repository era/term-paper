package br.com.findplaces.responses.webservices;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.to.PlaceTO;
import br.com.findplaces.webservices.requests.BaseJSONObject;

@XmlRootElement
public class PlaceResponse extends BaseJSONObject implements Serializable {

	private static final long serialVersionUID = -7238840821358453006L;
	
	private List<PlaceTO> places;

	public List<PlaceTO> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceTO> places) {
		this.places = places;
	}

}
