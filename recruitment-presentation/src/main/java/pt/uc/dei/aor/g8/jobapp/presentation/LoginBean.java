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
	
	
	// Getters and Setters
	
	public ICandidateProxy getCandidate() {
		if (candidate == null) {
			String username = getUsername();
			if ( username != null ){	
				candidate = candidateFacade.findCandidateByUsername(username);
				return candidate;
			} else {
				logout();
				return null;
			}
		} else {
			return this.candidate;
		}
	}
	
	public String getUsername() {
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
	
	
	//methods
	
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
}

