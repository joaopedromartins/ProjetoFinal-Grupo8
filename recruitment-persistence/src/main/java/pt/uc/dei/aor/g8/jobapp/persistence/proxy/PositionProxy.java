								package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;



import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ScriptEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;

@Stateless
public class PositionProxy implements IPositionProxy, IEntityAware<PositionEntity> {

	private PositionEntity entity;

	public PositionProxy() {
		this(null);
	}

	public PositionProxy(Date openDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, IUserProxy managerPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<IScriptProxy> scripts) {

		//TODO mudar o null do script
		this.entity = new PositionEntity(openDate,code,title,localization,status,numberOfposition,sLA, userConverterProxyToEntity(managerPosition),
				company,technicalArea,descriptionPosition, jobAdvertisingChanelConverterProxyToEntity(jobAdvertisingChanel),scriptsConvertProxyToEntity(scripts)); 

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
		Set<Localization> localization=entity.getLocalization();
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
		return new ArrayList<>(entity.getLocalization());
	}



	@Override
	public void setLocalization(List<Localization> localization) {
		entity.setLocalization(new HashSet<>(localization));
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
	public IUserProxy getManagerPosition() {
		UserEntity entityUser = entity.getManagerPosition();
		IUserProxy proxy = new UserProxy(entityUser);
		return proxy;
	}

	@Override
	public void setManagerPosition(IUserProxy userPosition) {
		entity.setManagerPosition(userConverterProxyToEntity(userPosition));
	}
	
	@SuppressWarnings( "unchecked" )
	private UserEntity userConverterProxyToEntity ( IUserProxy proxy){
		UserEntity entityUser = ((IEntityAware<UserEntity>)proxy).getEntity();
		return entityUser;
	}
	
	@SuppressWarnings("unchecked")
	private List<ScriptEntity> scriptsConvertProxyToEntity(List<IScriptProxy> scripts) {
		List<ScriptEntity> entityScripts = new ArrayList<>();

		for(IScriptProxy sP : scripts){
			entityScripts.add(((IEntityAware<ScriptEntity>)sP).getEntity());
		}
		return entityScripts;
	}

	@Override
	public List<IScriptProxy> getScript() {
		List<IScriptProxy> proxy= new ArrayList<>();

		List<ScriptEntity> entityScript = entity.getScript();

		for ( ScriptEntity s: entityScript){
			proxy.add(new ScriptProxy(s));
		}
		
		return proxy;
	}

	@Override
	public void setScript(List<IScriptProxy> script) {
		entity.setScript(scriptsConvertProxyToEntity(script));
	}

	@Override
	public long getId() {
		return entity.getId();
	}




}
