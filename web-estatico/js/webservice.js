var findplaces = findplaces || {};

findplaces.webservice = {};

findplaces.webservice.url =  "http://localhost/findplaces-web/rest/";  //"http://www.findplaces.com.br:9080";

findplaces.webservice.user = {};

findplaces.webservice.user.createUserByEmail = function(user){
	$.ajax({
		url: findplaces.webservice.url + 'user',
		data: "user="+JSON.stringify(user), //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'POST',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			if(resultJSON.code == 0){
				findplaces.webservice.user.loginSuccess(resultJSON.user,resultJSON.token);
			}
		}
	});
};

findplaces.webservice.user.loginSuccess = function(user, token){
	findplaces.webservice.user.setToken(token,user.id);
	$("#menuLoginTopo").html(user.name);
	$.openURLContent('#content', 'home');
}


findplaces.webservice.user.setToken = function(token,user){
	$('#tokenLoginUser').val(token);
	$('#userID').val(user);
}