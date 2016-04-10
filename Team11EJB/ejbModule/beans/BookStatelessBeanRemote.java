package beans;

import javax.ejb.Remote;

import model.Book;
import model.Impression;
import model.User;

@Remote
public interface BookStatelessBeanRemote {
	
	public boolean addBook(String author, String title, String description, String picture, User userID);
	
	public boolean addImpressions(Impression impression, Book book);

}
