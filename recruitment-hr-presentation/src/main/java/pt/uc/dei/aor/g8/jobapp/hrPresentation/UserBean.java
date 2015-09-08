package pt.uc.dei.aor.g8.jobapp.hrPresentation;

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
import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isLogged;
	private String password;
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
		return "/login?faces-redirect=true";

	}


	public IUserProxy getCurrentUser(){
		if ( currentUser == null){
			this.username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
			if ( username != null ){
				this.isLogged = true;
				this.currentUser = findUserByUsername();
				System.out.println(currentUser);
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

	public List<RoleType> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleType> roles) {
		this.roles = roles;
	}










	/*	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
			String mail = securityBean.getPrincipalName();
			System.out.println("Mail: "+mail);
			current.setMail(mail);
			current = userInterface.findByEmail(mail);
			if (current != null) {
				isLogged = true;
				loggedUtil.addUser(current);
				request.getSession().setAttribute("user", current);
			} else {
				request.getSession().invalidate();
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

	// editar informacao
	public void editar() {
		try {
			userInterface.update(current);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User info updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {

		}
	}

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
	}



	public void register() {
		boolean success = userInterface.save(newUser);
		if (success) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User registered successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "E-mail already registered",
					"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		newUser = new UserEntity();
	}*/




}
