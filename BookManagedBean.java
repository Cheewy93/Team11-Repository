package beans;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import model.Book;
import model.Impression;

@ManagedBean
@RequestScoped
public class BookManagedBean {
	@ManagedProperty(value="#{loginManagedBean}")
	private LoginManagedBean lmb;
	@EJB
	StatelessBeanRemote sbr;
	@EJB
	StatefulBeanRemote sfbr;

	private Book book = new Book();
	private Impression impression;
	private List<Book> books;
	
	public BookManagedBean() {
		// TODO Auto-generated constructor stub
		books=sfbr.getAllBooks();
	}
	
	public String addBook() {
		System.out.println(lmb.getCurrentUser());
		book.setUser(lmb.getCurrentUser());
		boolean ok = sbr.saveBook(book);
		if (ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Uspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Neuspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	
	public String addImpressions(){
		System.out.println(lmb.getCurrentUser());
		book.setUser(lmb.getCurrentUser());
		 Date date = new Date();
		impression.setDate(date);
		impression.setUser(lmb.getCurrentUser());
		boolean ok = sbr.addImpressions(impression, book);
		if (ok) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Uspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Neuspesno!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
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
