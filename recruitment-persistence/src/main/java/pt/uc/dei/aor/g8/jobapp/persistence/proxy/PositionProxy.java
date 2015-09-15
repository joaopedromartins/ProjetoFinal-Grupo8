								package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;

@Stateless
public class PositionProxy implements IPositionProxy, IEntityAware<PositionEntity> {

	private PositionEntity entity;

	public PositionProxy() {
		// TODO Auto-generated constructor stub
	}

	public PositionProxy(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, String userPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<String> script) {

		//TODO mudar o null do user e do script
		this.entity = new PositionEntity(openDate,closeDate,code,title,localization,status,numberOfposition,sLA, null,
				company,technicalArea,descriptionPosition, jobAdvertisingChanelConverterProxyToEntity(jobAdvertisingChanel),null); 

	}

	public PositionProxy(PositionEntity position){
		if (position==null){
			this.entity=new PositionEntity();
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
	public String getStringLocalization() {
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
	public List<Localization> getLocalization() {
		return entity.getLocalization();
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
	public Date getSLA() {
		return entity.getSLA();
	}

	@Override
	public void setSLA(Date sLA) {
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
	public TechnicalArea getTechnicalArea() {
		return entity.getTechnicalArea();
	}

	@Override
	public void setTechnicalArea(TechnicalArea technicalArea) {
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
	public List<IJobAdvertisingChanelProxy> getJobAdvertisingChanel() {
		List<IJobAdvertisingChanelProxy> proxy= new ArrayList<>();

		List<JobAdvertisingChanelEntity> entityChanel = entity.getJobAdvertisingChanel();

		for ( JobAdvertisingChanelEntity j: entityChanel){
			proxy.add(new JobAdvertisingChanelProxy(j));
		}
		
		return proxy;
	}


	@Override
	public void setJobAdvertisingChanel(List<IJobAdvertisingChanelProxy> jobAdvertisingChanel) {
		entity.setJobAdvertisingChanel(jobAdvertisingChanelConverterProxyToEntity(jobAdvertisingChanel));
	}



	@SuppressWarnings( "unchecked" )
	private List<JobAdvertisingChanelEntity> jobAdvertisingChanelConverterProxyToEntity (List<IJobAdvertisingChanelProxy> proxy){
		List<JobAdvertisingChanelEntity> entityChanel = new ArrayList<>();

		for(IJobAdvertisingChanelProxy jP : proxy){
			entityChanel.add(((IEntityAware<JobAdvertisingChanelEntity>)jP).getEntity());
		}

		return entityChanel;
	}

	@Override
	public IUserProxy getUserPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserPosition(IUserProxy userPosition) {
		// TODO Auto-generated method stub

	}



}
