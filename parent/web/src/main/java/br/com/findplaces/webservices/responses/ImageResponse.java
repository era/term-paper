package br.com.findplaces.webservices.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.findplaces.webservices.requests.BaseJSONObject;

@XmlRootElement
public class ImageResponse extends BaseJSONObject implements Serializable {

	private static final long serialVersionUID = 4421962723991301979L;
	
	private Integer imageID;

	public Integer getImageID() {
		return imageID;
	}

	public void setImageID(Integer imageID) {
		this.imageID = imageID;
	}

}
