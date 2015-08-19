package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;

public interface IPositionProxy {

	public Date getOpenDate();
	public void setOpenDate(Date openDate);
	public Date getCloseDate();
	public void setCloseDate(Date closeDate);
	public String getCode();
	public void setCode(String code);
	public String getTitle();
	public void setTitle(String title);
	public String getLocalization();
	public void setLocalization(List<Localization> localization);
	public Status getStatus();
	public void setStatus(Status status);
	public int getNumberOfposition();
	public void setNumberOfposition(int numberOfposition);
	public String getSLA();
	public void setSLA(String sLA);
	/*public UserEntity getUserPosition();
	public void setUserPosition(UserEntity userPosition);*/
	public String getCompany();
	public void setCompany(String company);
	public String getTechnicalArea();
	public void setTechnicalArea(String technicalArea);
	public String getDescriptionPosition();
	public void setDescriptionPosition(String descriptionPosition);
	public List<String> getJobAdvertisingChanel();
	public void setJobAdvertisingChanel(List<String> jobAdvertisingChanel);
	/*public List<ScriptEntity> getScript();
	public void setScript(List<ScriptEntity> script);*/
}
