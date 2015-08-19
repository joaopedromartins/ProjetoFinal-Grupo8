package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IPositionFacade;


@Named
@RequestScoped
public class PositionBean {
	
	@EJB
	private IPositionFacade position;
		
	private Date openDate;
	private Date closeDate;	
	private String code;
	private String title;
	private List<Localization> localization;
	private Status status;
	private int numberOfposition;
	private String SLA;
	private String userPosition;
	private String company;
	private String technicalArea;
	private String descriptionPosition;
	private List<String> jobAdvertisingChanel;
	private List<String> script;
	
	public PositionBean() {
		
	}
	
	
	public void creatNewPosition (){
		IPositionProxy proxy;
		
		proxy=position.creatNewPosition(openDate, closeDate, code, title, localization, status, numberOfposition, SLA, userPosition, company, technicalArea, descriptionPosition, jobAdvertisingChanel, script);
	
		if(proxy!=null){	
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Position created successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);	
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error creating position.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);	
		}
		
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public List<Localization> getPossibleLocalization(){
		return new ArrayList<Localization>(EnumSet.allOf(Localization.class));
	}
	
	public List<Localization> getLocalization() {
		return localization;
	}

	public void setLocalization(List<Localization> localization) {
		this.localization = localization;
	}

	public List<Status> getPossibleStatus(){
		return Arrays.asList(Status.values());
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	public List<String> getJobAdvertisingChanel() {
		return jobAdvertisingChanel;
	}


	public void setJobAdvertisingChanel(String jobAdvertisingChanel) {
		this.jobAdvertisingChanel = new ArrayList<>();
		this.jobAdvertisingChanel.add(jobAdvertisingChanel);
	}

	public int getNumberOfposition() {
		return numberOfposition;
	}

	public void setNumberOfposition(int numberOfposition) {
		this.numberOfposition = numberOfposition;
	}

	public String getSLA() {
		return SLA;
	}

	public void setSLA(String sLA) {
		SLA = sLA;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTechnicalArea() {
		return technicalArea;
	}

	public void setTechnicalArea(String technicalArea) {
		this.technicalArea = technicalArea;
	}

	public String getDescriptionPosition() {
		return descriptionPosition;
	}

	public void setDescriptionPosition(String descriptionPosition) {
		this.descriptionPosition = descriptionPosition;
	}

	public List<String> getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = new ArrayList<>();
		this.script.add(script);
	}
	
	
	

}
