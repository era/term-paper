package br.com.findplaces.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.findplaces.model.to.LikesTO;
import br.com.findplaces.model.to.UserTO;

import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import com.restfb.types.User;

public class FacebookUtils {

	
	public static boolean isValidToken(String token, UserTO user){

		return isValidToken(token, user.getSocialID());
		
	}

	public static boolean isValidToken(String token, String id) {
		DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
		User userFB = facebookClient.fetchObject("me", User.class);
		
		return userFB.getId().equals(id);
	}
	
	public static UserTO getUser(String token){
		DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
		User userFB = facebookClient.fetchObject("me", User.class);
		
		return Converter.converter(userFB);
	}
	
	public static List<LikesTO> getLikesFromUser(String token,UserTO user){
		DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
		JsonObject result = facebookClient.fetchObject(user.getSocialID(), JsonObject.class, Parameter.with("fields","likes"));
		return converterLikes(result, user);
	}
	
	private static List<LikesTO> converterLikes(JsonObject js, UserTO user){
        List<LikesTO> likes = new ArrayList<LikesTO>();
        
        for(int i = 0; i < js.getJsonObject("likes").getJsonArray("data").length(); i++){
                JsonObject likeJSON = js.getJsonObject("likes").getJsonArray("data").getJsonObject(i);
                LikesTO like = new LikesTO();
                
                like.setName(likeJSON.getString("name"));
                like.setSocialID(likeJSON.getString("id"));
//                like.setUser(user);
                
                likes.add(like);
        }
        
        return likes;
        
	}
	
}
