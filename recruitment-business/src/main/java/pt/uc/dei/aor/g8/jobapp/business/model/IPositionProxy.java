package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;

public interface IPositionProxy {

	public Date getOpenDate();
	public void setOpenDate(Date openDate);
	
	public Date getCloseDate();
	public void setCloseDate(Date closeDate);
	
	public String getCode();
	public void setCode(String code);
	
	public String getTitle();
	public void setTitle(String title);
	
	public List<Localization> getLocalization();
	public String getStringLocalization();
	public void setLocalization(List<Localization> localization);
	
	public Status getStatus();
	public void setStatus(Status status);
	
	public int getNumberOfposition();
	public void setNumberOfposition(int numberOfposition);
	
	public Date getSLA();
	public void setSLA(Date sLA);
	
	public IUserProxy getManagerPosition();
	public void setManagerPosition(IUserProxy userPosition);
	
	public String getCompany();
	public void setCompany(String company);
	
	public TechnicalArea getTechnicalArea();
	public void setTechnicalArea(TechnicalArea technicalArea);
	
	public String getDescriptionPosition();
	public void setDescriptionPosition(String descriptionPosition);
	
	public List<IJobAdvertisingChanelProxy> getJobAdvertisingChanel();
	public void setJobAdvertisingChanel(List<IJobAdvertisingChanelProxy> jobAdvertisingChanel);
	
	public List<IScriptProxy> getScript();
	public void setScript(List<IScriptProxy> script);
	public long getId();
}
