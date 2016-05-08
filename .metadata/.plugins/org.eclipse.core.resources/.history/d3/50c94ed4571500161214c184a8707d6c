package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Information database table.
 * 
 */
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int informationId;

	private String text;

	private String title;

	public Information() {
	}

	public int getInformationId() {
		return this.informationId;
	}

	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}