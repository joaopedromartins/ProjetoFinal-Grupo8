package pt.uc.dei.aor.g8.jobapp.presentation;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;

import java.io.Serializable;
import java.math.BigInteger;



@Named
@SessionScoped
public class JobApplicationBean implements Serializable {
	private static final long serialVersionUID = 1L;


	@EJB
	private IJobApplicationFacade jobApplicationFacade;
	
	@EJB
	private ICandidateFacade candidateFacade;

	private String address;
	private String city;
	private String country;
	private BigInteger phone;
	private String diploma;
	private String school;
	private String letter; 
	private String cv;
	private String source;
	private String status;
	
	private ICandidateProxy candidateProxy;
	private IPositionProxy positionProxy;
	
	private String sessionUserLogged;

	//constructors
	public JobApplicationBean() {
	}

	//Getters e Setters

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public ICandidateProxy getCandidateProxy() {
		return candidateProxy;
	}
	public void setCandidateProxy(ICandidateProxy candidateProxy) {
		this.candidateProxy = candidateProxy;
	}

	public IPositionProxy getPositionProxy() {
		return positionProxy;
	}
	public void setPositionProxy(IPositionProxy positionProxy) {
		this.positionProxy = positionProxy;
	}
	
	public String getSessionUserLogged() {
		this.sessionUserLogged = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		return sessionUserLogged;
	}


	//methods
	
	
//	public ICandidateProxy findCandidateProxyByUsername(String username){
//		return candidateProxy = candidateFacade.findCandidateByUsername(username);
//	}
	

	public String applyPosition() {
		return "/pages/candidate/applyPosition?faces-redirect=true";
	}
	
	public String applyJobApplication() {
		// TODO
		// APAGAR sysout
		System.out.println( "\n     Username:       "+getSessionUserLogged());
		System.out.println( "\n     Position Title: "+positionProxy.getTitle() +"\n");
		//
		
		IJobApplicationProxy proxy;
		proxy=jobApplicationFacade.createNewJobApplication(
				 address,  city,  country, phone, diploma,
				 school,  letter,  cv, source, status, candidateProxy, positionProxy);
		if(proxy!=null){
			address=null;
			city=null;
			country=null;
			phone=null;
			diploma=null;
			school=null;
			letter=null; 
			cv=null;
			source=null;
			status=null;
						
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Position created successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			// TODO
			// vai para a pagina ver candidaturas
			//return "/pages/candidate/candidate";
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error creating position.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);	
		}
		
		//Volta à mesma pagina
		return "/pages/candidate/candidate";
	}
	
//	private void redirect(String path){
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
//        
//        try {
//            response.sendRedirect(request.getContextPath()+path);
//        } catch (IOException e) {
//            // Redirection error
//            e.printStackTrace();
//        }
//    }

	
}	
