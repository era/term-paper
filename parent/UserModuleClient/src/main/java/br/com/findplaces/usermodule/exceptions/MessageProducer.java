package br.com.findplaces.usermodule.exceptions;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageProducer {
	
	private ConnectionFactory factory;
	private Connection connection;
	private InitialContext initialContext;

	public MessageProducer() throws NamingException, JMSException{
		initialContext = new InitialContext();
		
		factory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
		
		connection = factory.createConnection();
	}
	
	public void sendMessage(String message, String queue) throws JMSException, NamingException{
		
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		TextMessage txt = session.createTextMessage("Message");
		javax.jms.MessageProducer producer = session.createProducer((Destination) initialContext.lookup(queue));
		
		txt.setText(message);

		producer.send(txt);
		
		producer.close();
		session.close();
		connection.stop();
		
	}
}
