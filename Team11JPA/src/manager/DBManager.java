package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Book;
import model.Category;
import model.Impression;
import model.Information;
import model.Response;
import model.Topic;
import model.User;

public class DBManager {

	public User getLoggedUser(EntityManager em, String username, String password){
			TypedQuery<User> tq = em.createQuery("select u from User u where u.username= :username and u.password= :password", User.class);
			tq.setParameter("username", username);
			tq.setParameter("password", password);
			User loggedUser = tq.getSingleResult();
			return loggedUser;
    }
	
	// SAVE -------------------------------------------------------------------

		public boolean saveUser(EntityManager em, User user) {
			try {
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean saveBook(EntityManager em, Book book, List<Category> cat) {
			book.setCategories(cat);
			try {
				em.getTransaction().begin();
				em.persist(book);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		public boolean saveInformation(EntityManager em, Information info) {
			try {
				em.getTransaction().begin();
				em.persist(info);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean saveImpression(EntityManager em, Impression impression){
			try {
				em.getTransaction().begin();
				em.persist(impression);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean saveTopic(EntityManager em, Topic topic) throws ParseException {
			topic.setDate(new Date());
			try {
				em.getTransaction().begin();
				em.persist(topic);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean saveResponse(EntityManager em, Response response) throws ParseException {
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        String date = sdf.format(today);
	        Date datee = sdf.parse(date);
			response.setDate(datee);
			try {
				em.getTransaction().begin();
				em.persist(response);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
	// GET  ----------------------------------------------------------------

		public List<Book> getAllBooks(EntityManager em) {
			TypedQuery<Book> tq = em.createQuery("select b from Book b", Book.class);
			List<Book> books = tq.getResultList();
			return books;
		}

		public List<Category> getAllCategories(EntityManager em) {
			TypedQuery<Category> tq = em.createQuery("select c from Category c", Category.class);
			List<Category> categories = tq.getResultList();
			return categories;
		}

		public List<Book> getBooksForCategories(EntityManager em, List<String> selectedCategories) {
			List<Book> books = null;
			for(String c: selectedCategories){
				int id = Integer.parseInt(c);
				TypedQuery<Category> tq = em.createQuery("select c from Category c where c.categoryId = :id", Category.class);
				tq.setParameter("id", 1);
				Category cat = tq.getSingleResult();
				System.out.println(cat);
				TypedQuery<Book> tq1 = em.createQuery("select b from Book b where :cat in b.categories", Book.class);
				tq1.setParameter("cat", cat);
				books.addAll(tq1.getResultList());
			}
			return books;
		}
		
		public List<Impression> getImpressionsForBook(EntityManager em, Book b) {
			TypedQuery<Impression> tq = em.createQuery("select i from Impression i where i.book.bookId= :bookId", Impression.class);
			tq.setParameter("bookId", b.getBookId());
			List<Impression> res = tq.getResultList();
			return res;
		}
		
		public List<Topic> getAllTopics(EntityManager em) {
			TypedQuery<Topic> tq = em.createQuery("select t from Topic t", Topic.class);
			List<Topic> res = tq.getResultList();
			return res;
		}

		public List<Response> getAllResponses(EntityManager em) {
			TypedQuery<Response> tq = em.createQuery("select r from Response r", Response.class);
			List<Response> res = tq.getResultList();
			return res;
		}
		
		public void find(EntityManager em){
			Book b = em.find(Book.class, 12);
			List<Category> cats = b.getCategories();
			for(Category c : cats){
				System.out.println("m" + c.getName());
			}
			
		}
		
		public static void main(String[] args){
			EntityManager em = JPAUtil.getEntityManager();
			new DBManager().find(em);
		}
}
