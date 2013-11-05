term-paper
==========

My group term paper for BS CS course.

#Members:
* Eduardo Botelho - @[EdKnight](https://github.com/EdKnight)
* Elias Granja - @[era](https://github.com/era) - http://www.eliasgranja.com 
* Mateus Coradini - @[mateuscoradini](https://github.com/mateuscoradini)
* Paulo Dianin - @[maxjuniorbr](https://github.com/maxjuniorbr) -  http://dianin.net.br/



#Frameworks:

Web: JAX-RS, Hibernate, EJB 3.0

ENDPOINTS - REST
==========

* Main URL: http://www.findplaces.com.br/findplaces-web/rest/
* Vocabulary:
	* URL PARAMS = QUERY STRING
	* FORM PARAMS: Parameters passed by post

##USER 

###Get user

	URL: http://www.findplaces.com.br/findplaces-web/rest/user/{id}
	Method: GET
	URL PARAMS:
		token: String with facebook token(must be a valid one).
		type: Type of the user, right now must be FB

**Attention** The id passed in the URL, must be the facebook id.

Response:
	
	{"message":"SUCCESS",
	"code":0, //Code != 0 is error	
	"user":
		{"name":"Elias Granja",
		"email":"mycoolemail@gmail.com",
		"id":1,
		"socialID":"1751315906",
		"type":
			{"id":1,
			"name":"FACEBOOK_USER"
		},"age":"21",
		"studyAt":"UNIP",
		"relationship":"In a Relationship",
		"likes":null
	},
	"token":null}

* Example of request:
	* curl -GET http://www.findplaces.com.br/findplaces-web/rest/user/1751315906?type=FB&token=CAAFNSdzc4IkBACwoLopMEB6DZADMW7UWNTUdHZCqkmicBxyAAdaXQkYA8YZAZAcZA3F6L4Q7xJ1A04d0EpeaMmgEoZCA3h8Kvb3MiuDFCvXMDYJxNFRVBupN8UHAsKul5UWnGvKyXJtXuZCfuK1Bc6krxfINyBSNYlZBJ3K4LD8oMCuP4xU0WY6GudbcNHwbg3GMUPZBRHrzxZCwZDZD
	
###Create user

	URL: http://www.findplaces.com.br/findplaces-web/rest/user/
	Method: POST
	FORM PARAMS:
		user = {
			token: String with facebook token.
			userFacebookID: String with the facebookID
			email: String with the email(doenst need to be the facebook one)
			name: Name of the user(is used in the website to display his name)
		}

Response:
	
	{"message":"SUCCESS",
	"code":0, //Code != 0 is error	
	"user":
		{"name":"Elias Granja",
		"email":"mycoolemail@gmail.com",
		"id":1,
		"socialID":"1751315906",
		"type":
			{"id":1,
			"name":"FACEBOOK_USER"
		},"age":"21",
		"studyAt":"UNIP",
		"relationship":"In a Relationship",
		"likes":null
	},
	"token":null}
	
###Create a seller profile
(This allow the user to offer places in the website)

	URL: http://www.findplaces.com.br/findplaces-web/rest/user/seller
	METHOD: PUT
	FORM PARAMS:
		user = {
			token: String with facebook token.
			userFacebookID: String with the facebookID.
		}

Response:

	{
    "message": "SUCCESS",
    "code": 0,
    "seller": {
        "id": 1,
        "userTO": {
            "name": "Elias Granja",
            "email": "myfancyEmail@gmail.com",
            "id": 1,
            "socialID": "1780315906",
            "password": null,
            "type": {
                "id": 1,
                "name": "FACEBOOK_USER"
            },
            "age": "21",
            "studyAt": "UNIP",
            "relationship": "In a Relationship",
            "likes": null
        },
        "name": null,
        "latitude": null,
        "longitude": null,
        "website": null,
        "city": null,
        "state": null,
        "country": null
    	}
	}
		
###Get Seller profile
	URL: http://www.findplaces.com.br/findplaces-web/rest/user/seller/{id}
	METHOD: GET
	URL PARAMS:
		token: String with facebook token(must be a valid one).
		type: Type of the user, right now must be FB
		
**Attention** The id passed in the URL, must be the facebook id.

Response:

	{
    "message": "SUCCESS",
    "code": 0,
    "seller": {
        "id": 1,
        "userTO": {
            "name": "Elias Granja",
            "email": "myfancyEmail@gmail.com",
            "id": 1,
            "socialID": "1780315906",
            "password": null,
            "type": {
                "id": 1,
                "name": "FACEBOOK_USER"
            },
            "age": "21",
            "studyAt": "UNIP",
            "relationship": "In a Relationship",
            "likes": null
        },
        "name": null,
        "latitude": null,
        "longitude": null,
        "website": null,
        "city": null,
        "state": null,
        "country": null
    	}
	}


##Places

###Insert user

	URL: http://www.findplaces.com.br/findplaces-web/rest/user/{id}
	Method: GET
	URL PARAMS:
		token: String with facebook token(must be a valid one).
		type: Type of the user, right now must be FB
