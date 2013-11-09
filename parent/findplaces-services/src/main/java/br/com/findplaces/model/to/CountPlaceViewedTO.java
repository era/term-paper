package br.com.findplaces.model.to;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="count")
public class CountPlaceViewedTO implements Serializable, Viewed {

	private static final long serialVersionUID = -5388651249003082057L;
	
	private Date viewedDate;
	
	private Integer count;

	@Override
	public Date getViewedDate() {
		// TODO Auto-generated method stub
		return viewedDate;
	}

	@Override
	public void setViewedDate(Date date) {
		viewedDate = date;
	}

	@Override
	public Integer getViewedObject() {
		return count;
	}

	@Override
	public void setViewedObject(Object o) {
		count = (Integer) o;
	}

}

