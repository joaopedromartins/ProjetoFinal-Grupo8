package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

@Named
@RequestScoped
public class RegisterUserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private RoleType roles;

	@EJB
	private IUserFacade userFacade;


	public RegisterUserBean() {
		// TODO Auto-generated constructor stub
	}

	public void newUser(){
		String messagebusiness= userFacade.createUserWithOutPassword(username, lastName, firstName, email, roles);
		if (messagebusiness.equals("sucess")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Employer, " +firstName +" " + lastName +", registered successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messagebusiness,
					"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
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
	
	public List<RoleType> getPossibleRoles (){
		return Arrays.asList(RoleType.values());	
	}
	public RoleType getRoles() {
		return roles;
	}
	public void setRoles(RoleType roles) {
		this.roles = roles;
	}




}
