package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="photo")
public class PhotoTO implements Serializable {

	private static final long serialVersionUID = 1538360621929918773L;
	
	@XmlTransient
	private String url;
	
	private Long id;
	
	@XmlTransient
	private String file;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	

}
