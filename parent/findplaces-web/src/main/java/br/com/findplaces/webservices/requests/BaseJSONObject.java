package br.com.findplaces.webservices.requests;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseJSONObject {
	
	private String message;
	
	private Integer code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
