package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;

@Entity
@Table(name = "Position")
@NamedQuery(name = "Position.listOfAllPosition", query = "SELECT p FROM PositionEntity p")
public class PositionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static final String LIST_OF_ALL_POSITION = "Position.listOfAllPosition";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column
	private Date openDate;

	@Temporal(TemporalType.DATE)
	@Column
	private Date closeDate;

	@Column
	private String code;

	@Column
	private String title;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="localization" )
	@Enumerated(EnumType.STRING)
	private List<Localization> localization;

	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	protected Status status;

	@Column
	private int numberOfposition;

	@Temporal(TemporalType.DATE)
	@Column
	private Date SLA;

	@ManyToOne(fetch=FetchType.LAZY)
	private UserEntity managerPosition;

	@Column
	private String company;
	
	@Enumerated(EnumType.STRING)
	@Column
	private TechnicalArea technicalArea;

	@Column
	private String descriptionPosition;

	@ManyToMany
	private List<JobAdvertisingChanelEntity> jobAdvertisingChanel;

	@OneToMany
	private List<ScriptEntity> script;

	public PositionEntity() {
		// TODO Auto-generated constructor stub
	}

	public PositionEntity(Date openDate, Date closeDate, String code, String title, List<Localization> localization,
			Status status, int numberOfposition, Date sLA, UserEntity userPosition, String company, 
			TechnicalArea technicalArea, String descriptionPosition, List<JobAdvertisingChanelEntity> jobAdvertisingChanel,
			List<ScriptEntity> script) {
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.code = code;
		this.title = title;
		this.localization = localization;
		this.status = status;
		this.numberOfposition = numberOfposition;
		this.SLA = sLA;
		this.managerPosition = userPosition;
		this.company = company;
		this.technicalArea = technicalArea;
		this.descriptionPosition = descriptionPosition;
		
		this.jobAdvertisingChanel = new ArrayList<>();
		this.jobAdvertisingChanel.addAll(jobAdvertisingChanel);
		
		this.script = script;
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




	public UserEntity getManagerPosition() {
		return managerPosition;
	}



	public void setManagerPosition(UserEntity userPosition) {
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



	public void setTechnicalArea(TechnicalArea technicalArea) {
		this.technicalArea = technicalArea;
	}



	public String getDescriptionPosition() {
		return descriptionPosition;
	}




	public void setDescriptionPosition(String descriptionPosition) {
		this.descriptionPosition = descriptionPosition;
	}



	public List<JobAdvertisingChanelEntity> getJobAdvertisingChanel() {
		return jobAdvertisingChanel;
	}




	public void setJobAdvertisingChanel(List<JobAdvertisingChanelEntity> jobAdvertisingChanel) {
		this.jobAdvertisingChanel = new ArrayList<>();
		this.jobAdvertisingChanel.addAll(jobAdvertisingChanel);

	}




	public List<ScriptEntity> getScript() {
		return script;
	}



	public void setScript(List<ScriptEntity> script) {
		this.script = script;
	}


}
