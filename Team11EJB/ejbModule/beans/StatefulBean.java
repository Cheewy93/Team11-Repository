package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.User;

/**
 * Session Bean implementation class StatefulBean
 */
@Stateful
@LocalBean
public class StatefulBean implements StatefulBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	private User currentUser;
	
    /**
     * Default constructor. 
     */
    public StatefulBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean login(String username, String password){
    	try {
			TypedQuery<User> tq = em.createQuery("select u from User u where u.username= :username and u.password= :password", User.class);
			tq.setParameter("username", username);
			tq.setParameter("password", password);
			User u = tq.getSingleResult();
			if(u==null)
				return false;
			setCurrentUser(u);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
