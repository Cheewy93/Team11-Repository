package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Topic database table.
 * 
 */
@Entity
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int topicId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String text;

	private int userId;

	//bi-directional many-to-one association to Response
	@OneToMany(mappedBy="topic")
	private List<Response> responses;

	public Topic() {
	}

	public int getTopicId() {
		return this.topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Response> getResponses() {
		return this.responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Response addRespons(Response respons) {
		getResponses().add(respons);
		respons.setTopic(this);

		return respons;
	}

	public Response removeRespons(Response respons) {
		getResponses().remove(respons);
		respons.setTopic(null);

		return respons;
	}

}