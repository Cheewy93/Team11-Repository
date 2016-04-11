package beans;

import javax.ejb.Remote;

import model.User;

@Remote
public interface StatefulBeanRemote {
	public boolean login(String username, String password);
	public User getCurrentUser();
}
