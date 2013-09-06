package br.com.findplaces.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.com.findplaces.facebook.utils.Converter;
import br.com.findplaces.helpers.LoginHelper;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.model.to.UserTypeTO;
import br.com.findplaces.usermodule.ejb.UserLogin;
import br.com.findplaces.usermodule.exceptions.CouldNotFindUserException;
import br.com.findplaces.usermodule.exceptions.CouldNotSaveUserException;
import br.com.findplaces.usermodule.exceptions.MessageProducer;

import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

@ManagedBean(name = "loginMB")
@SessionScoped
@Deprecated
public class LoginMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginMB.class);
	
//	@EJB(mappedName = "java:global/UserModule-1.0.0.0-SNAPSHOT/UserLoginEJB!br.com.findplaces.usermodule.ejb.UserLogin")
	private UserLogin userLogin;

	private HttpServletRequest request;

	private DefaultFacebookClient facebook;

	private UserTO user;
	
	private String confirmPassword;
	
	private List<String> errors;

	public LoginMB() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) context.getRequest();
	}

	public String singupFacebook() throws CouldNotSaveUserException, NamingException, JMSException {
		UserTO user = null;
		try {
			
			facebook = new DefaultFacebookClient(request.getParameter("token"));
			user = Converter.converter(facebook.fetchObject(request.getParameter("userID"), User.class)); 
			this.setUser(userLogin.findUserBySocialID(user.getSocialID()));
			
		} catch (CouldNotFindUserException e) {
			UserTypeTO type = new UserTypeTO();
			type.setId(UserLogin.FACEBOOK_USER_ID);
			type.setName(UserLogin.FACEBOOK_USER);
			user.setType(type);
			this.user = userLogin.createUser(user);
			String message = request.getParameter("token")+","+request.getParameter("userID");
			MessageProducer messageProducer = new MessageProducer();
			messageProducer.sendMessage(message, MessageProducer.QUEUE_SAVE_LIKES);
			
		}
		
		return "";
			
	}
	
	public void singup(){
		try{
			errors = LoginHelper.validateSingupForm(user, confirmPassword);
			if(errors.isEmpty()){
				userLogin.createUser(user);
			}
		}catch(CouldNotSaveUserException e){
			logger.error(e);
			errors.add(LoginHelper.COULD_NOT_SAVE_ERROR);
		}
	}

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
