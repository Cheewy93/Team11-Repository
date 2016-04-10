package beans;

import java.util.Date;

import javax.ejb.Remote;

import model.Book;

@Remote
public interface UserStatefullBeanRemote {

	 public boolean login(String username, String password);
	 
	 public boolean register(String username, String password, String name, String lastName, String email, String phoneNumber, Date birthDate);
	 
	 public boolean addBook(String author, String title, String description, String picture);
	 
	 public boolean addImpression(String text, Date date, Book book );
	
}
