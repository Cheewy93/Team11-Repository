package beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

/**
 * Session Bean implementation class UserSessionBean
 */
@Stateless
@LocalBean
public class UserSessionBean {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
    public UserSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void register(String username, String pass, Date birthDate, String firstname, String lastname, String email, String number) {
    	System.out.println("Stigao do SB");
    	
    	
    	try {
			User u = new User();
			u.setBirthDate(birthDate);
			u.setEmail(email);
			u.setName(firstname);
			u.setLastName(lastname);
			u.setPhoneNumber(number);
			u.setUsername(username);
			u.setPassword(pass);
			u.setRoleId(2);
			em.persist(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    }

}
