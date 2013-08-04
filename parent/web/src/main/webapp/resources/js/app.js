var findplaces = findplaces || {};

findplaces.home = findplaces.home || {};

findplaces.home.init = function(){
	
	var map = findplaces.maps.createMap(-22.925046,-47.037854,13);

	L.marker([-22.925046, -47.037854]).addTo(map)
	    .bindPopup('Unip Swift. <br> Um tcc bem maneiro ;).')
	    .openPopup();
};