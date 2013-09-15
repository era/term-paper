package br.com.findplaces.responses.webservices;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.webservices.requests.BaseJSONObject;

@XmlRootElement
public class ImageResponse extends BaseJSONObject implements Serializable {

	private static final long serialVersionUID = 4421962723991301979L;
	
	private Long imageID;

	public Long getImageID() {
		return imageID;
	}

	public void setImageID(Long imageID) {
		this.imageID = imageID;
	}

}
