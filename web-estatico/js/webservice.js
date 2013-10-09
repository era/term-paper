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
		url: findplaces.webservice.url + 'user/email', //fixme
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
	user.userFacebookID = id;
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

findplaces.webservice.user.loginWithFacebook = function(token, id){
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
				findplaces.webservice.user.loginSuccess(resultJSON.user,token);
			} else {
				findplaces.webservice.user.createUserByFacebook(id,token);
			}
		}
	});
};

findplaces.webservice.user.loginSuccess = function(user, token){
	findplaces.webservice.user.setToken(token,user.socialID);
	//$("#menuLoginTopo").html(user.name); FIXME
	//$.openURLContent('#content', 'home');
}


findplaces.webservice.user.setToken = function(token,user){
	$('#tokenLoginUser').val(token);
	$('#userID').val(user);
}

findplaces.webservice.user.seller = function(socialID,token){
	var user = {};
	user.userFacebookID = socialID;
	user.token = token;
	$.ajax({
		url: findplaces.webservice.url + 'user/seller',
		data: "user="+JSON.stringify(user), //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'PUT',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			//What to do here? o.o
		}
	});
};

findplaces.webservice.places = {};

findplaces.webservice.places.insert = function (place,callback){
	$.ajax({
		url: findplaces.webservice.url + 'place/',
		data: 'place='+JSON.stringify(place), //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'POST',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			callback(resultJSON);
		}
	});

	//{'token':'CAAFNSdzc4IkBANloQM9dSmmFheN9EkEA0CKJfpe2QuEaoxwgPvfEKHxEi99PLj5A2oX4eQdPha0yoyJ7JDQvA6VTWvUSwmZCD5eTepQSSdyqLqbJtc52T5TFg1kHI1CytVlbBcpi7lN8EAvNlwY93bHUne5S8R2i2RAezt8BZCvmxWI6P3E8oUf3cZCsZA2FzhpEvrfoWgZDZD', 'socialid':"1750315906", 'address': "rua do bosque",  'lat': "-22.913051",  'log': "-47.054745", 'city':{'name':'Monte Santo', 'region':{'alias':'MG'}}, 'street':{'name':'bla bla'}, 'country':{'name':'Brazil'}, 'neighborhood':{'name':'Centro'}, 'placetype':{'id':'1'}}
}

findplaces.webservice.places.get = function(id, callback, socialID, token){
	var place = {};
	place.socialID = socialID;
	place.token = token;
	$.ajax({
		url: findplaces.webservice.url + 'place/'+id,
		data: place, //{name:"+user.name+"}",//:user.name}},
		//dataType: "json",
		method: 'GET',
		success: function(result) {
			console.log(result); //FIXME to be more responsible by errors
			var resultJSON = eval(result);
			callback(resultJSON);
		}
	});
}

