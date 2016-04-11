package beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class RegisterBean {
	@EJB
	StatelessBeanRemote sbr;
	
	public Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String email;

	public String lastname;

	public String firstname;

	public String password;

	public String number;

	public String username;
	
	
	public void register() {
		sbr.register(username, password, firstname, lastname, email, number, birthDate);
	}
	
	public void registertest() {
		sbr.register("Test", "Test","Test", "Test", "Test", "00000", new Date());
	}
	

}
