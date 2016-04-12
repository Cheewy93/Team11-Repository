package beans;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import model.Book;

@ManagedBean
@RequestScoped
public class BookManagedBean {
	@ManagedProperty(value="#{loginManagedBean}")
	private LoginManagedBean lmb;
	@EJB
	StatelessBean sbr;
	List<Book> books = null;
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	private Book book = new Book();
	
	public BookManagedBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String addBook() {
		System.out.println(lmb.getCurrentUser());
		book.setUser(lmb.getCurrentUser());
		boolean ok = sbr.saveBook(book);
//		if (ok) {
//			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Uspesno!", null);
//			FacesContext.getCurrentInstance().addMessage(null, message);
//		} else {
//			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Neuspesno!", null);
//			FacesContext.getCurrentInstance().addMessage(null, message);
//		}
		return "";
	}

	public void getAllBooks() {
		books = sbr.getBooks();
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LoginManagedBean getLmb() {
		return lmb;
	}

	public void setLmb(LoginManagedBean lmb) {
		this.lmb = lmb;
	}
}
