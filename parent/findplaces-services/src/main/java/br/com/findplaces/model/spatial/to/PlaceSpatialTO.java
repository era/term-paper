package br.com.findplaces.model.spatial.to;

import java.io.Serializable;

import br.com.findplaces.model.to.PlaceTO;

import com.vividsolutions.jts.geom.Geometry;

public class PlaceSpatialTO implements Serializable{
	
	private Long id;
	
	private PlaceTO place;
	
	private Geometry geom;

}
