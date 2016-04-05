package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Response database table.
 * 
 */
@Entity
@NamedQuery(name="Response.findAll", query="SELECT r FROM Response r")
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int responseId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String text;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="themeId")
	private Theme theme;

	public Response() {
	}

	public int getResponseId() {
		return this.responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}