package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import manager.DBManager;
import manager.JPAUtil;
import model.User;

@ManagedBean
@RequestScoped
public class UserManagedBean {

	private User user = new User();
	EntityManager em = JPAUtil.getEntityManager();
	
	public String addUser(){
		user.setRoleId(2);
		boolean ok = new DBManager().saveUser(em, user);
		if (ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Uspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Neuspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "/pages/site?faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
