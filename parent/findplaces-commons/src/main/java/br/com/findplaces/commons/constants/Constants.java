package br.com.findplaces.commons.constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {
	
	private static Constants constant;
	
	private Properties prop;
	
	public static String CONNECTION_FACTORY;
	
	public static String USER_SAVE_LIKES_QUEUE;
	
	private Constants() throws FileNotFoundException, IOException{
		/*String path = System.getProperty("findPlacesProperties");
		prop.load(new FileInputStream(path));
		CONNECTION_FACTORY = prop.getProperty("connection.factory");
		USER_SAVE_LIKES_QUEUE = prop.getProperty("user.queue.save.likes");*/
		
	}
	
	public static Constants getInstance(){
		if(constant==null){
			try {
				constant = new Constants();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return constant;
	}
	
	public String pathToImageFolder(){
		return "/home/normaluser/"; //prop.getProperty("photos.folder");
	}

}
