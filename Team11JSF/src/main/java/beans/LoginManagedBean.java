package beans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import manager.DBManager;
import manager.JPAUtil;
import model.User;

@ManagedBean
@SessionScoped
public class LoginManagedBean {

	private String username;
	private String password;
	private User currentUser;
	private boolean loggedIn;
	EntityManager em = JPAUtil.getEntityManager();

	public String login(){
		currentUser = new DBManager().getLoggedUser(em, username, password);
		if (currentUser == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Korisnicko ime i lozinka se ne poklapaju!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			loggedIn = true;
			return "/pages/index?faces-redirect=true";
		}
		return "";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		loggedIn = false;
		return "/pages/site?faces-redirect=true";
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
