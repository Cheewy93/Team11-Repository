package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Bookselling database table.
 * 
 */
@Entity
@NamedQuery(name="Bookselling.findAll", query="SELECT b FROM Bookselling b")
public class Bookselling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int booksellingId;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String price;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookId")
	private Book book;

	public Bookselling() {
	}

	public int getBooksellingId() {
		return this.booksellingId;
	}

	public void setBooksellingId(int booksellingId) {
		this.booksellingId = booksellingId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}