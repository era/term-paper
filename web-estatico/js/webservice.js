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
			} else {
				alert("Opss, alguma coisa aconteceu :(. Tente de novo, ok?");
			}
		}
	});
};

findplaces.webservice.user.loginUserWithEmail = function(user){
	user.type = "EMAIL";
	$.ajax({
		url: findplaces.webservice.url + 'user/email',
		data: user, //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'GET',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			if(resultJSON.code == 0){
				findplaces.webservice.user.loginSuccess(resultJSON.user,resultJSON.token);
			} else {
				alert("Opss, alguma coisa aconteceu :(. Tente de novo, ok?");
			}
		}
	});
}

findplaces.webservice.user.createUserByFacebook = function(id,token){
	var user = {};
	user.id = id;
	user.token = token;
	user.type = "FB";
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
			} else {
				alert("Opss, alguma coisa aconteceu :(. Tente de novo, ok?");
			}
		}
	});
}

findplaces.webservice.user.loginWithFacebook = function(id, token){
	var user = {};
	user.token = token;
	user.type = "FB";
	$.ajax({
		url: findplaces.webservice.url + 'user/'+id,
		data: user, //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'GET',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			if(resultJSON.code == 0){
				findplaces.webservice.user.loginSuccess(resultJSON.user,resultJSON.token);
			} else {
				findplaces.webservice.user.createUserByFacebook(id,token);
			}
		}
	});

	//tenta logar
	//se não conseguir, tenta inserir, se não fala que rolou problema
};

findplaces.webservice.user.loginSuccess = function(user, token){
	findplaces.webservice.user.setToken(token,user.id);
	//$("#menuLoginTopo").html(user.name); FIXME
	$.openURLContent('#content', 'home');
}


findplaces.webservice.user.setToken = function(token,user){
	$('#tokenLoginUser').val(token);
	$('#userID').val(user);
}