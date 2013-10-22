package br.com.findplaces.model.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coment")
public class ComentTO implements Serializable {

	private UserTO user;
	
	private ComentTO answer;
	
	private PlaceTO place;
	
	private String text;

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public ComentTO getAnswer() {
		return answer;
	}

	public void setAnswer(ComentTO answer) {
		this.answer = answer;
	}

	public PlaceTO getPlace() {
		return place;
	}

	public void setPlace(PlaceTO place) {
		this.place = place;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
