package br.com.findplaces.responses.webservices;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.model.to.CountPlaceViewedTO;
import br.com.findplaces.webservices.requests.BaseJSONObject;

@XmlRootElement
public class ViewsFromPlaceResponse extends BaseJSONObject implements
		Serializable {

	private static final long serialVersionUID = -3574925166430791238L;
	
	private List<CountPlaceViewedTO> views;

	public List<CountPlaceViewedTO> getViews() {
		return views;
	}

	public void setViews(List<CountPlaceViewedTO> views) {
		this.views = views;
	}

}
