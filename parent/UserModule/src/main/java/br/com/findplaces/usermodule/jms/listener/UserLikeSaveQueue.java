package br.com.findplaces.usermodule.jms.listener;

import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import br.com.findeplaces.jpa.dao.impl.interfaces.UserDAO;
import br.com.findeplaces.jpa.entity.Likes;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/UserLikeSaveQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "0") })
public class UserLikeSaveQueue implements MessageListener {

	private static final String LIKES = "likes";
	
	private static final Logger logger = Logger.getLogger(UserLikeSaveQueue.class);
	
	@EJB
	private UserDAO userDAO;

	@Override
	public void onMessage(Message message) {
		try {
			List<Likes> likes = (List<Likes>) message.getObjectProperty(LIKES);
			userDAO.saveLikesFromUser(likes);
		} catch (JMSException e) {
			logger.error(e);
		}
	}

}
