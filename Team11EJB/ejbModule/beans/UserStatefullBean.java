package beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Book;
import model.Impression;
import model.User;

/**
 * Session Bean implementation class CommunicationWithInterface
 */
@Stateful
public class UserStatefullBean implements UserStatefullBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	@EJB
	BookStatelessBean bookComm;
	
	private User userID;
	
    public UserStatefullBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean login(String username, String password){
    	TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :username like u.username and u.password like :password", User.class);
    	query.setParameter("username", username);
    	query.setParameter("password", password);
    	User user = query.getSingleResult();
    	if(user != null){
    		userID = user;
    	
    		return true;
    	}
    	return false;
    }
    
    
    public boolean register(String username, String password, String name, String lastName, String email, String phoneNumber, Date birthDate) {
    	TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :username like u.username", User.class);
    	query.setParameter("username", username);
    	User test = query.getSingleResult();
    	if (test != null) {
    		//TODO: Message to user
    		return false;
    	}
    	
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
    
    public boolean addBook(String author, String title, String description, String picture) {
    		
    	return bookComm.addBook(author, title,description,picture,userID);
    }
    
    public boolean addImpression(String text, Date date, Book book ) {
    	Impression impression = new Impression();
    	impression.setText(text);
    	impression.setDate(date);
    	impression.setUser(userID);
    	
    	return bookComm.addImpressions(impression, book);
    }

}
