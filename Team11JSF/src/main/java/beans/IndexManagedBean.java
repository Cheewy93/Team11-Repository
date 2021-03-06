package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import model.User;

@ManagedBean
@SessionScoped
public class IndexManagedBean {
	
	private int role_admin = User.role_admin;
	private int role_other = User.role_other;
	
	String selectedId;
	
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpServletRequest req = (HttpServletRequest) request;
	LoginManagedBean loggedUserSession = (LoginManagedBean) req.getSession()
			.getAttribute("loginManagedBean");

	private User loggedUser = loggedUserSession.getCurrentUser();
	
	public void menuClicked(ActionEvent event) {
		selectedId = event.getComponent().getId();

	}
	
	public String redirect() {
		switch (selectedId) {
		case "newsLink":
			return "/pages/news/news-view?faces-redirect=true";
		case "booksLink":
			return "/pages/books/books-view-logged?faces-redirect=true";
		case "addLink":
			return "/pages/books/books-create?faces-redirect=true";
		case "addNewsLink":
			return "/pages/news/news-create?faces-redirect=true";
		case "addImpressionLink":
			return "/pages/impression/impression-create?faces-redirect=true";
		case "forumLink":
			return "/pages/forum/forum-view?faces-redirect=true";
		default:
			return "/pages/profile-page?faces-redirect=true";
		}
	}

	public int getRole_admin() {
		return role_admin;
	}
	
	public void setRole_admin(int role_admin) {
		this.role_admin = role_admin;
	}
	public int getRole_other() {
		return role_other;
	}
	
	public void setRole_other(int role_other) {
		this.role_other = role_other;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

}
