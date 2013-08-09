var findplaces = findplaces || {};

findplaces.constantes = findplaces.constantes || {};

findplaces.constantes.LOGIN_FB_URL = 'http://localhost:8080/web-1.0.0.0-SNAPSHOT/faces/views/login/facebook.xhtml';

findplaces.home = findplaces.home || {};

findplaces.facebook = findplaces.facebook || {};

findplaces.home.init = function(){
	
	var map = findplaces.maps.createMap(-22.925046,-47.037854,13);

	L.marker([-22.925046, -47.037854]).addTo(map)
	    .bindPopup('Unip Swift. <br> Um tcc bem maneiro ;).')
	    .openPopup();
};


findplaces.facebook.initLogin = function(){
	 FB.Event.subscribe('auth.authResponseChange', function(response) {
		    if (response.status === 'connected') {
		    	window.window.location = findplaces.constantes.LOGIN_FB_URL + "?token="+response.authResponse.accessToken
		    					+"&userID="+response.authResponse.userID;
		    }
	 });
};