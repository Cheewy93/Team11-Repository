package beans;

import java.util.Date;
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
 * Session Bean implementation class Team11Stateless
 */
@Stateless
@LocalBean
public class StatelessBean implements StatelessBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public StatelessBean() {
        // TODO Auto-generated constructor stub
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
    
    public boolean register(String username, String password, String name, String lastName, String email, String phoneNumber, Date birthDate) {
    	User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setName(name);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPhoneNumber(phoneNumber);
		newUser.setBirthDate(birthDate);
		
		em.persist(newUser);
		return true;
    	
    }
    
 // SAVE -------------------------------------------------------------------
    
    public boolean saveBook(Book b){
    	try{
    		em.persist(b);
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }

}
