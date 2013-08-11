package br.com.findplaces.datamining.math;

import br.com.findplaces.datamining.data.Place;

public class DistanceCalculator {

	public static Double distanceBetween(Place first, Place second){
		return Math.sqrt(Math.pow((first.getHouseVisited() - second.getHouseVisited()), 2 )  +
				Math.pow((first.getLikeFromUser() - second.getLikeFromUser()), 2 ) +
				Math.pow((first.getUserID() - second.getUserID()), 2 ));
	}
	
}
