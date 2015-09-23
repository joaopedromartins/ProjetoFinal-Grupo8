package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	private boolean isLogged;
	private String password;
	private String oldPassword;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private List<RoleType> roles;
	private IUserProxy currentUser;

	@EJB
	private IUserFacade userFacade;

	public UserBean() {
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			this.currentUser=null;
			this.isLogged = false;
			request.logout();
			request.getSession().invalidate();

		} catch (ServletException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Logout Failed", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/CriticalJobApplicationHR/");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return "/login?faces-redirect=true";
	}

	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(username, password);			
		}
		catch (ServletException e) {
			return "loginerror.xhtml?faces-redirect=true";
		}
		this.username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if ( username != null ){
			this.currentUser = findUserByUsername();
			this.email = currentUser.getEmail();
			this.isLogged = true;
			int numeroRoles=currentUser.getRoles().size();
			String page;
			if ( numeroRoles == 3){
				page = "/administrator/administrator?faces-redirect=true";
			} else if (numeroRoles==2){
				page = "/manager/manager?faces-redirect=true" ;
			} else {
				page = "/interviewer/interviewer?faces-redirect=true";
			}
			return page;
		}else {
			logout();
			return null;
		}
	}


	public IUserProxy getCurrentUser(){
		if ( currentUser == null){
			this.username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
			if ( username != null ){
				this.isLogged = true;
				this.currentUser = findUserByUsername();
				this.email = currentUser.getEmail();
				return currentUser;
			}else {
				logout();
				return null;
			}
		} else {
			return this.currentUser;

		}
	}



	public IUserProxy findUserByUsername (){
		return userFacade.findUserByUsername(username);	
	}



	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldpassword() {
		return oldPassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldPassword = oldpassword;
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

	public List<RoleType> getPossibleRoles() {
		return new ArrayList<RoleType>(EnumSet.allOf(RoleType.class));
	}

	public List<RoleType> getRolesUser() {
		return roles;
	}

	public void setRolesUser(List<RoleType> rolesUser) {
		this.roles = rolesUser;
	}



	public void editUser() {
		String newEmail = currentUser.getEmail();
		String newUsername = currentUser.getUsername();

		if ( username.equals(newUsername) && email.equals(newEmail)){
			userFacade.updateUser(currentUser);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		} else if ( !username.equals(newUsername) && email.equals(newEmail)){
			if(userFacade.findUserByUsername(newUsername) == null){
				userFacade.updateUser(currentUser);
				this.username = currentUser.getUsername();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"User updated successfully.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Username already exist!!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			}
		} else if (username.equals(newUsername) && !email.equals(newEmail)){
			if(userFacade.findUserByEmail(newEmail) == null){
				userFacade.updateUser(currentUser);
				this.email = currentUser.getEmail();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"User info updated successfully.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Email already exist!!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			}
		} else if (!username.equals(newUsername) && !email.equals(newEmail)){
			IUserProxy userEmail = userFacade.findUserByEmail(newEmail);
			IUserProxy userUsername = userFacade.findUserByUsername(newUsername);
			if(userEmail == null && userUsername == null ){
				userFacade.updateUser(currentUser);
				this.email = currentUser.getEmail();
				this.username = currentUser.getUsername();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"User updated successfully.", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;

			}else if (userEmail != null && userUsername == null){
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Username already exist!!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			}else if (userEmail == null && userUsername != null){
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Email already exist!!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;

			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Email and Username already exists!!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return;
			}
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error on upadate profile!!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}

	}

	public void changePassword(){
		String messageFacade = userFacade.changePassword(currentUser,oldPassword,password);
		
		if (messageFacade.equals("sucess")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Password changed with success.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageFacade, "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	
	public boolean isAdministrator() {
		return currentUser.getRoles().contains(RoleType.ADMINISTRATOR);
	}
	
	public boolean isManager() {
		return currentUser.getRoles().contains(RoleType.MANAGER);
	}
	public boolean isInterviewer() {
		return currentUser.getRoles().contains(RoleType.INTERVIEWER);
	}
	
	
	/*
	public void editarPass() {
		try {
			current.setPassword(password);
			userInterface.updatePassword(current);
			password = "";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Password updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {

		}
	}

	// apagar conta
	public String deleteAccount() {
		try {
			userInterface.delete(current);
			return endSession();

		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Could not delete user account", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}*/

}
