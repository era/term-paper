var findplaces = findplaces || {};
findplaces.maps = findplaces.maps || {}; 

findplaces.maps.createMap = function(latitude,longitude,zoom){
	
	var map = L.map('map').setView([latitude, longitude], zoom);
	
	L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	    attribution: '&copy; Findplaces.com.br | &copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	}).addTo(map);
	
	return map;
	
};