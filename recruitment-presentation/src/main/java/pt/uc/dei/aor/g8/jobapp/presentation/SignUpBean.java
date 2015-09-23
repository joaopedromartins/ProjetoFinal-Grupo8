package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;

@Named
@RequestScoped
public class SignUpBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ICandidateFacade candidateFacade;

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private BigInteger mobile;



	//Getters and Setters
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
	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}


	//Methods

	public void register() {
		String messagebusiness=candidateFacade.createNewCandidate(username, password, lastname, firstname, email, mobile);
		if (messagebusiness.equals("sucess")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Candidate, " +firstname +" " + lastname +", created successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			username=null;
			password=null;
			firstname=null;
			lastname=null;
			email=null;
			mobile=null;
		} else {
			FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, messagebusiness,"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public String recover() {
		// TODO username/password recover
		// A pagina login vai ser alterada por forma a poder ser efectuado signup na mesma página e possibilitar recuperação da password
		// Falta reset da password e envio de email com username e a pass gerada aleatoriamente
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("recover email to "+email+" has been sent with sucess."));
		return "signup";
	}

}
