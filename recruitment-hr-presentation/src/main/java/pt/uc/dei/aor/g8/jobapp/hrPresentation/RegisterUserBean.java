package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

@Named
@RequestScoped
public class RegisterUserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private List<RoleType> roles;

	@EJB
	private IUserFacade userFacade;


	public RegisterUserBean() {
		// TODO Auto-generated constructor stub
	}

	public void newUser(){
		IUserProxy newUser= userFacade.createUser(username, password, lastName, firstName, email, roles);
		if (newUser != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User registered successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "E-mail already registered",
					"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<RoleType> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleType> roles) {
		this.roles = roles;
	}




}
