package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IPositionFacade;
import java.io.Serializable;



@Named
@SessionScoped
public class PositionBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	private IPositionFacade positionFacade;
		
	private Date openDate=new Date();
	private Date closeDate;	
	private String code;
	private String title;
	private List<Localization> localization;
	private Status status;
	private int numberOfposition=1;
	private Date SLA;
	private String userPosition;
	private String company;
	private TechnicalArea technicalArea;
	private String descriptionPosition;
	private List<IJobAdvertisingChanelProxy> jobAdvertisingChanel;
	private List<String> script;
	
	private List<IPositionProxy> listPosition;
	private IPositionProxy positionProxy;

	public PositionBean() {
		
	}
	
	public List<IPositionProxy> listOfAllPosition(){
		
		return this.listPosition=positionFacade.listOfAllPosition();
	}
	
	public List<IPositionProxy> getListPosition() {
		return listPosition;
	}

	public void setListPosition(List<IPositionProxy> listOfAllPosition) {
		this.listPosition = listOfAllPosition;
	}
	
	
	public IPositionProxy getPositionProxy() {
		return positionProxy;
	}

	public void setPositionProxy(IPositionProxy positionProxy) {
		this.positionProxy = positionProxy;
	}
	
	public void editPosition(){
		IPositionProxy proxy2;
		
		proxy2=positionFacade.editPosition(positionProxy);
		if(proxy2!=null){
			
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Position updated successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error updated position.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);	
		}
	}

	public void creatNewPosition (){
		IPositionProxy proxy;
		proxy=positionFacade.creatNewPosition(openDate, closeDate, code, title, localization, status, numberOfposition, SLA, userPosition, company, technicalArea, descriptionPosition, jobAdvertisingChanel, script);
	
		if(proxy!=null){
			closeDate=null;
			code=null;
			title=null;
			localization.clear();
			status=null;
			numberOfposition=1;
			SLA=null;
			userPosition=null;
			company=null;
			technicalArea=null;
			descriptionPosition=null;
			jobAdvertisingChanel=null;
			script=null;
			
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
	

	public List<IJobAdvertisingChanelProxy> getJobAdvertisingChanel() {
		return jobAdvertisingChanel;
	}


	public void setJobAdvertisingChanel(List<IJobAdvertisingChanelProxy> jobAdvertisingChanel) {
		this.jobAdvertisingChanel = new ArrayList<>();
		this.jobAdvertisingChanel.addAll(jobAdvertisingChanel);
	}

	public int getNumberOfposition() {
		return numberOfposition;
	}

	public void setNumberOfposition(int numberOfposition) {
		this.numberOfposition = numberOfposition;
	}

	public Date getSLA() {
		return SLA;
	}

	public void setSLA(Date sLA) {
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

	public TechnicalArea getTechnicalArea() {
		return technicalArea;
	}
	
	public List<TechnicalArea> getPossibleTecnicalArea(){
		return Arrays.asList(TechnicalArea.values());
	}

	public void setTechnicalArea(TechnicalArea technicalArea) {
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
