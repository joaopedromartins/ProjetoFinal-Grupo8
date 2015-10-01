package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 2659606888995054385L;
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	
	@EJB
	private ICandidateFacade candidateFacade;
	
	private ICandidateProxy candidate;
	
	private String password;
	private String oldPassword;
	
	
	
	// Getters and Setters
		
	public ICandidateProxy getCandidate() {
		if( candidate == null){
			currentCandidate();
		} 
		return candidate;
	}
	public void setCandidate(ICandidateProxy candidate) {
		this.candidate = candidate;
	}

	public String getUsername() {
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	//methods
	
	public void currentCandidate() {
		if (candidate == null) {
			String username = getUsername();
			// TODO logger
			System.out.println("Get Candidate:");
			System.out.println("Username:" + username);
			if ( username != null ){	
				this.candidate = candidateFacade.findCandidateByUsername(username);
				// TODO logger
				System.out.println("Firstname:" + candidate.getFirstname());
				System.out.println("Lastname:" + candidate.getLastname());
				System.out.println("Username:" + candidate.getUsername());
				System.out.println("Email:" + candidate.getEmail());
				System.out.println("LinkedIn:" + candidate.getLinkedinAddress());
				
			} else {
				logout();
				this.candidate=null;
				
			}
		} 
			
	}
	
	
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.logout();
			request.getSession().invalidate();

		} catch (ServletException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Logout Failed", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/CriticalJobApplication/");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return "/index?faces-redirect=true";
	}

	
	
	public void changePassword(){
		// TODO add metodo changePassword(candidate,oldPassword,password)
		String messageFacade = candidateFacade.changePassword(candidate,oldPassword,password);
		
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
}

