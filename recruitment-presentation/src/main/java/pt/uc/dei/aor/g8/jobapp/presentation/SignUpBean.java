package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SignUpBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@EJB
	//private ICandidateFacade candidateFacade;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	
	
	
	//Getters ans Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String register() {
		return "signup";
	}
	
}
