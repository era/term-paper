package br.com.findplaces.mb;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.findplaces.facebook.utils.Converter;
import br.com.findplaces.model.to.UserTO;
import br.com.findplaces.usermodule.ejb.UserLogin;
import br.com.findplaces.usermodule.exceptions.CouldNotFindUserException;
import br.com.findplaces.usermodule.exceptions.CouldNotSaveUserException;

import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

@ManagedBean("loginMB")
@ViewScoped
public class LoginMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "UserLogin")
	private UserLogin userLogin;

	private HttpServletRequest request;

	private DefaultFacebookClient facebook;

	private UserTO user;

	public void init() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) context.getRequest();
		facebook = new DefaultFacebookClient(request.getParameter("token"));
	}

	public void SingupFacebook() throws CouldNotSaveUserException {
		try {
			UserTO user = Converter.converter(facebook.fetchObject("me", User.class));
			this.user = userLogin.findUserBySocialID(user.getSocialID());
		} catch (CouldNotFindUserException e) {
			this.user = userLogin.createUser(user);
		}
			
	}

}
