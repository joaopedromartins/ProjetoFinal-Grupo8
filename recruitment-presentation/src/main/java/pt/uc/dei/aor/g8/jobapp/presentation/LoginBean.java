package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2659606888995054385L;
	
	@EJB
	private ICandidateFacade candidateFacade;
	
	private ICandidateProxy user;
	
	public ICandidateProxy getUser() {
		if (user == null) {
			String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
			user = candidateFacade.findCandidateByUsername(username);
			return user;
		}
		else {
			return user;
		}
	}
	
	public String getUsername() {
		return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	}
}

