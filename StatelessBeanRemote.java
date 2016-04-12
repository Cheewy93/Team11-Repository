package beans;

import java.util.Date;

import javax.ejb.Remote;

import model.Book;
import model.Impression;

@Remote
public interface StatelessBeanRemote {
	public boolean saveBook(Book b);
	public boolean register(String username, String password, String name, String lastName, String email, String phoneNumber, Date birthDate);
	public boolean addImpressions(Impression impression, Book book);
}
