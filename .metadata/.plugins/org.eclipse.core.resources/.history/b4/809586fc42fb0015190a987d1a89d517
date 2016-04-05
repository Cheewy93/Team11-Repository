package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int themeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String text;

	//bi-directional many-to-one association to Response
	@OneToMany(mappedBy="theme")
	private List<Response> responses;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public Theme() {
	}

	public int getThemeId() {
		return this.themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
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

	public List<Response> getResponses() {
		return this.responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Response addRespons(Response respons) {
		getResponses().add(respons);
		respons.setTheme(this);

		return respons;
	}

	public Response removeRespons(Response respons) {
		getResponses().remove(respons);
		respons.setTheme(null);

		return respons;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}