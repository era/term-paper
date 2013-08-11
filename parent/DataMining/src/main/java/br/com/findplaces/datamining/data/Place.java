package br.com.findplaces.datamining.data;

import java.io.Serializable;

public class Place implements Serializable {

	private static final long serialVersionUID = -4950149591544478504L;
	
	private Long houseVisited;
	
	private Long likeFromUser;
	
	private Long userID;

	public Long getHouseVisited() {
		return houseVisited;
	}

	public void setHouseVisited(Long houseVisited) {
		this.houseVisited = houseVisited;
	}

	public Long getLikeFromUser() {
		return likeFromUser;
	}

	public void setLikeFromUser(Long likeFromUser) {
		this.likeFromUser = likeFromUser;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

}
