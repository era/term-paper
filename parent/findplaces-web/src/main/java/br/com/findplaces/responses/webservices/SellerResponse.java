package br.com.findplaces.responses.webservices;

import java.io.Serializable;

import br.com.findplaces.model.to.SellerTO;
import br.com.findplaces.webservices.requests.BaseJSONObject;

public class SellerResponse extends BaseJSONObject implements Serializable {

	private static final long serialVersionUID = 5633354494342015189L;
	
	private SellerTO seller;

	public SellerTO getSeller() {
		return seller;
	}

	public void setSeller(SellerTO seller) {
		this.seller = seller;
	}

}
