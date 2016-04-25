package beans;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import manager.DBManager;
import manager.JPAUtil;
import model.Book;
import model.Bookselling;
import model.Impression;
import model.Information;

@ManagedBean(name="salesBean")
@RequestScoped
public class SalesManagedBean {
	@ManagedProperty(value="#{bookManagedBean}")
	private BookManagedBean bmb;
	private Book book;
	

	Bookselling bookselling=new Bookselling();
	private String date;

	EntityManager em = JPAUtil.getEntityManager();
	
	public String addInformation(){
		bookselling.setBook(book);
		DateFormat formatter ; 
		Date d ; 
		   formatter = new SimpleDateFormat("dd-MM-yy");
		   try {
			d = formatter.parse(date);
			bookselling.setDate(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
		
		
		
		boolean ok = new DBManager().saveBookSelling(em, bookselling);
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
	
	public String setSelectedBook(Book b){
		book=b;
		return "/pages/books/book-salesInfo";
	}

	public Bookselling getBookselling() {
		return bookselling;
	}

	public void setBookselling(Bookselling bookselling) {
		this.bookselling = bookselling;
	}

	public BookManagedBean getBmb() {
		return bmb;
	}

	public void setBmb(BookManagedBean bmb) {
		this.bmb = bmb;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
