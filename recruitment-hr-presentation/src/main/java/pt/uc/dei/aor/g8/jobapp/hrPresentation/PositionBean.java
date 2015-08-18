package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;


@Named
@RequestScoped
public class PositionBean {
		
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
	private String script;
	
	public PositionBean() {
		
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
		return Arrays.asList(Localization.values());
	}
	
	public List<Localization> getLocalization() {
		return localization;
	}

	public void setLocalization(List<Localization> localization) {
		this.localization = localization;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setJobAdvertisingChanel(List<String> jobAdvertisingChanel) {
		this.jobAdvertisingChanel = jobAdvertisingChanel;
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

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
	
	

}
