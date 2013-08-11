package br.com.findplaces.datamining.math;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.findplaces.datamining.data.Place;

public class DistanceCalculatorTest {

	@Test
	public void testDistanceBetweenTwoEqualsPoint() {
		Place place = new Place();
		place.setHouseVisited(1L);
		place.setUserID(42L);
		place.setLikeFromUser(5L);
		
		assertEquals(0L, (double) DistanceCalculator.distanceBetween(place, place),0.1);
	}

}
