package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Book;
import model.User;

@Remote
public interface StatefulBeanRemote {
	public boolean login(String username, String password);
	public User getCurrentUser();
	public List<Book> getAllBooks();
}
