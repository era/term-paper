package br.com.findplaces.usermodule.jms.listener;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import br.com.findplaces.jpa.dao.impl.interfaces.UserDAO;
import br.com.findplaces.jpa.entity.Likes;
import br.com.findplaces.jpa.entity.User;

import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/UserLikeSaveQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1") })
public class UserLikeSaveQueue implements MessageListener {

	private static final Logger logger = Logger.getLogger(UserLikeSaveQueue.class);
	
	@EJB
	private UserDAO userDAO;

	@Override
	public void onMessage(Message message) {
		TextMessage txt = (TextMessage) message;
		String params[];
		try {
			params = txt.getText().split(",");
			String token = params[0];
			String userID = params[1];
			DefaultFacebookClient facebookClient = new DefaultFacebookClient(token);
			JsonObject result = facebookClient.fetchObject(userID, JsonObject.class, Parameter.with("fields","likes"));
			saveLikes(result, userDAO.findUserBySocialID(userID));
		} catch (JMSException e) {
			logger.error(e);
		}
	}
	
	public void saveLikes(JsonObject js, User user){
		List<Likes> likes = new ArrayList<Likes>();
		
		for(int i = 0; i < js.getJsonObject("likes").getJsonArray("data").length(); i++){
			JsonObject likeJSON = js.getJsonObject("likes").getJsonArray("data").getJsonObject(i);
			Likes like = new Likes();
			
			like.setName(likeJSON.getString("name"));
			like.setSocialID(likeJSON.getString("id"));
			like.setUser(user);
			
			likes.add(like);
		}
		
		userDAO.saveLikesFromUser(likes);
	}

}
