package br.com.findplaces.mb;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean("homeMB")
@ViewScoped
public class HomeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String searchingFor;

	public String getSearchingFor() {
		return searchingFor;
	}

	public void setSearchingFor(String searchingFor) {
		this.searchingFor = searchingFor;
	}

}