package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class SiteManagedBean {

	String selectedId;
	
	public void menuClicked(ActionEvent event) {
		selectedId = event.getComponent().getId();

	}
	
	public String redirect() {
		switch (selectedId) {
		case "newsLink":
			return "/pages/news/news-view?faces-redirect=true";
		case "booksLink":
			return "/pages/books/books-view?faces-redirect=true";
		case "addLink":
			return "/pages/books/books-create?faces-redirect=true";
		case "addUserLink":
			return "/pages/user/user-create?faces-redirect=true";
		default:
			return "/pages/profile-page?faces-redirect=true";
		}
	}
}
