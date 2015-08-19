package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;

@Stateless
public class PositionProxy implements IPositionProxy, IEntityAware<PositionEntity> {

	private PositionEntity entity;

	public PositionProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public PositionProxy(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, String sLA, String userPosition,
			String company, String technicalArea, String descriptionPosition, List<String> jobAdvertisingChanel,
			List<String> script) {
		
		//TODO mudar o null do user e do script
		entity = new PositionEntity(openDate,closeDate,code,title,localization,status,numberOfposition,sLA, null,
				company,technicalArea,descriptionPosition, jobAdvertisingChanel,null); 
		
	}

	public PositionProxy(PositionEntity position){
		if (position==null){
			entity=new PositionEntity();
		} else {
			this.entity=position;
		}
	}

	@Override
	public PositionEntity getEntity() {
		return entity;
	}

	@Override
	public Date getOpenDate() {
		
		return entity.getOpenDate();
	}

	@Override
	public void setOpenDate(Date openDate) {
		entity.setOpenDate(openDate);	
	}

	@Override
	public Date getCloseDate() {
		return entity.getCloseDate();
	}

	@Override
	public void setCloseDate(Date closeDate) {
		entity.setCloseDate(closeDate);	
	}

	@Override
	public String getCode() {
		return entity.getCode();
	}

	@Override
	public void setCode(String code) {
		entity.setCode(code);
	}

	@Override
	public String getTitle() {
		return entity.getTitle();
	}

	@Override
	public void setTitle(String title) {
		entity.setTitle(title);
	}

	@Override
	public String getLocalization() {
		String localizations="";
		List<Localization> localization=entity.getLocalization();
		for (Localization l: localization){
			if(!localizations.equals("")){
				localizations=localizations + ", " + l.getDescription();
			} else {
				localizations = l.getDescription();
			}
		}
		return localizations; 
	}

	@Override
	public void setLocalization(List<Localization> localization) {
		entity.setLocalization(localization);
	}

	@Override
	public Status getStatus() {
		return entity.getStatus();
	}

	@Override
	public void setStatus(Status status) {
		entity.setStatus(status);
	}

	@Override
	public int getNumberOfposition() {
		return entity.getNumberOfposition();
	}

	@Override
	public void setNumberOfposition(int numberOfposition) {
		entity.setNumberOfposition(numberOfposition);
	}

	@Override
	public String getSLA() {
		return entity.getSLA();
	}

	@Override
	public void setSLA(String sLA) {
		entity.setSLA(sLA);
	}

	@Override
	public String getCompany() {
		return entity.getCompany();
	}

	@Override
	public void setCompany(String company) {
		entity.setCompany(company);
	}

	@Override
	public String getTechnicalArea() {
		return entity.getTechnicalArea();
	}

	@Override
	public void setTechnicalArea(String technicalArea) {
		entity.setTechnicalArea(technicalArea);
	}

	@Override
	public String getDescriptionPosition() {
		return entity.getDescriptionPosition();
	}

	@Override
	public void setDescriptionPosition(String descriptionPosition) {
		entity.setDescriptionPosition(descriptionPosition);
	}

	@Override
	public List<String> getJobAdvertisingChanel() {
		return entity.getJobAdvertisingChanel();
	}

	@Override
	public void setJobAdvertisingChanel(List<String> jobAdvertisingChanel) {
		entity.setJobAdvertisingChanel(jobAdvertisingChanel);
	}



}
