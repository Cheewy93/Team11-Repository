package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Book;
import model.Impression;
import model.User;

/**
 * Session Bean implementation class BookCommunication
 */
@Stateless
@LocalBean
public class BookStatelessBean implements BookStatelessBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	
    public BookStatelessBean() {
        // TODO Auto-generated constructor stub
    }
    
       
    public boolean addBook(String author, String title, String description, String picture, User userID) {
    	TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE :title like b.title and :author like b.author", Book.class);
    	q.setParameter("title", title);
    	q.setParameter("author", author);
    	Book test = q.getSingleResult();
    	
    	if (test != null) {
    		//TODO: MESSAGE TO USER, BOOK EXISTS!
    		return false;
    	}
    	
    	Book newBook = new Book();
    	newBook.setAuthor(author);
    	newBook.setDescription(description);
    	newBook.setTitle(title);
    	newBook.setPicture(picture);
    	newBook.setUser(userID);
    	
    	em.persist(newBook);
    	return true;
    }
    
    public boolean addImpressions(Impression impression, Book book) {
    	TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE :title like b.title and :author like b.author", Book.class);
    	q.setParameter("title", book.getTitle());
    	q.setParameter("author", book.getAuthor());
    	Book test = q.getSingleResult();
    	
    	if (test == null) {
    		//TODO: MESSAGE TO USER, BOOK DOES'T EXISTS!
    		return false;
    	}
    	
    	List<Impression> list = book.getImpressions();
    	list.add(impression);
    	book.setImpressions(list);
    	impression.setBook(book);
    	
    	em.persist(impression);
    	em.merge(book);
    	
    	return true;
    }

}
