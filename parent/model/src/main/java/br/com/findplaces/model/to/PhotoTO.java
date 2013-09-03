package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="photo")
public class PhotoTO implements Serializable {

	private static final long serialVersionUID = 1538360621929918773L;
	
	private String url;
	
	private String id;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

}
