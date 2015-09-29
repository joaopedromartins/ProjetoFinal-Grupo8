package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.StatusPosition;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IPositionFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;



@Named
@ViewScoped
public class PositionBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	private IPositionFacade positionFacade;
	@EJB
	private IUserFacade userFacade;
	@Inject
	private UserBean currentUser;
		
	private Date openDate=new Date();
	private Date closeDate;	
	private String code;
	private String title;
	private List<Localization> localization;
	private StatusPosition status;
	private int numberOfposition=1;
	private Date SLA;
	private IUserProxy managerPosition;
	private String company;
	private TechnicalArea technicalArea;
	private String descriptionPosition;
	private List<IJobAdvertisingChanelProxy> jobAdvertisingChanel;
	private List<IScriptProxy> scripts;
	
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
		proxy=positionFacade.creatNewPosition(openDate, title, localization, status, numberOfposition, SLA, managerPosition,currentUser.getCurrentUser(), company, technicalArea, descriptionPosition, jobAdvertisingChanel, scripts);
	
		if(proxy!=null){
			closeDate=null;
			code=null;
			title=null;
			localization.clear();
			status=null;
			numberOfposition=1;
			SLA=null;
			managerPosition=null;
			company=null;
			technicalArea=null;
			descriptionPosition=null;
			jobAdvertisingChanel=null;
			scripts=null;
			
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
		return Arrays.asList(Localization.values());
	}
	
	public List<Localization> getLocalization() {
		return localization;
	}

	public void setLocalization(List<Localization> localization) {
		this.localization = localization;
	}

	public List<StatusPosition> getPossibleStatus(){
		return Arrays.asList(StatusPosition.values());
	}
	
	public StatusPosition getStatus() {
		return status;
	}

	public void setStatus(StatusPosition status) {
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

	public IUserProxy getManagerPosition() {
		return managerPosition;
	}
	
	public List <IUserProxy> getPossibleManagers (){
		return userFacade.findManagers();
	}

	public void setManagerPosition(IUserProxy userPosition) {
		this.managerPosition = userPosition;
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

	public List<IScriptProxy> getScripts() {
		return scripts;
	}

	public void setScripts(List<IScriptProxy> script) {
		this.scripts = new ArrayList<>();
		this.scripts.addAll(script);
	}
	
	public List <IPositionProxy> listOfALLPositionManager (){
		this.listPosition = positionFacade.listOfAllPositionManager (currentUser.getCurrentUser());
		return listPosition;
	}
	
	
	
	

}
