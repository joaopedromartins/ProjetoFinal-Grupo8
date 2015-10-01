package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.util.AutoGeneratePasswor;

@Named
@SessionScoped
public class SignUpBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ICandidateFacade candidateFacade;
	
	@EJB
	private AutoGeneratePasswor generateCode;

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String linkedinAddress;
	private String sendRegistrationCode;
	private String appliedRegistrationCode;

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
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLinkedinAddress() {
		return linkedinAddress;
	}
	public void setLinkedinAddress(String linkedinAddress) {
		this.linkedinAddress = linkedinAddress;
	}

	public String getSendRegistrationCode() {
		if (sendRegistrationCode==null) {
			this.sendRegistrationCode=generateCode.autoGeneratePassword();
		}
		
		return sendRegistrationCode;
	}
	public void setSendRegistrationCode(String sendRegistrationCode) {
		this.sendRegistrationCode = sendRegistrationCode;
	}


	public String getAppliedRegistrationCode() {
		return appliedRegistrationCode;
	}
	public void setAppliedRegistrationCode(String appliedRegistrationCode) {
		this.appliedRegistrationCode = appliedRegistrationCode;
	}


	//Methods

	public String register() {
		String messagebusiness;
		// TODO logger
		System.out.println("Send Registration Code: \t" + sendRegistrationCode);
		System.out.println("Applied Registration Code: \t" + appliedRegistrationCode);
		System.out.println("username: \t" + username);
		System.out.println("password: \t" + password);
		System.out.println("lastname: \t" + lastname);
		System.out.println("firstname: \t" + firstname);
		System.out.println("email: \t" + email);
		System.out.println("mobile: \t" + mobile);
		
				
		if ( sendRegistrationCode.equals(appliedRegistrationCode)) {
			messagebusiness=candidateFacade.createNewCandidate(username, password, lastname, firstname, email, mobile, linkedinAddress);
		} else {
			messagebusiness = "Validation Code Error.";
		}

		if (messagebusiness.equals("sucess")) {
			return signin();
		} else {
			FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, messagebusiness,"");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}

	public void recover() {
		String message = candidateFacade.sendRecoverMessageToEmail(email);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	}
	
	public void generateAndSendRegistrationCode() {
		
		this.sendRegistrationCode=generateCode.autoGeneratePassword();
		String message = candidateFacade.sendRegistrationCode(this.sendRegistrationCode, this.email);
		
		if (message.contains("Error:")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR, message,""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO, message,""));

			//Abre janela de popup
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.execute("PF('validation').show();");
			
		}
		
		
	}
	
	public String signin(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			// TODO logger
			System.out.println("\n\nSignIN ");
			System.out.println("username: \t" + username);
			System.out.println("password: \t" + password);
			request.login(username, password);
			
			return "/pages/candidate/company?faces-redirect=true";
		}
		catch (ServletException e) {
			return "/pages/loginerror?faces-redirect=true";
		}
	}
}
