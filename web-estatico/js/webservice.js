var findplaces = findplaces || {};

findplaces.webservice = {};

findplaces.webservice.url =  "http://localhost:8080/findplaces-web/rest/";  //"http://www.findplaces.com.br:9080";

findplaces.webservice.user = {};

findplaces.webservice.user.createUserByEmail = function(user){
	$.ajax({
		url: findplaces.webservice.url + 'user',
		data: {'user' : user},
		dataType: "json",
		method: 'POST',
		success: function(result) {
			console.log(result);
		}
	});
}