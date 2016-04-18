package beans;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import model.User;

@ManagedBean
@SessionScoped
public class LoginManagedBean {
	@EJB
	StatefulBeanRemote sbr;
	
	private String username;
	private String password;
	private User currentUser;
	private boolean loggedIn;

	public String login() throws NamingException {
		boolean ok = sbr.login(username, password);
		if (!ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Korisnicko ime i lozinka se ne poklapaju!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			currentUser = sbr.getCurrentUser();
			loggedIn = true;
			return "addBook?faces-redirect=true";
		}
		return "";
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
