package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.StatusPosition;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;

@Entity
@Table(name = "Position")
@NamedQueries({
	@NamedQuery(name = "Position.listOfAllPosition", query = "SELECT p FROM PositionEntity p"),
	@NamedQuery(name = "Position.listOfAllOpenPosition", query = "SELECT p FROM PositionEntity p where p.status like 'OPEN' "),
	@NamedQuery(name = "Position.lastPositionOfListPosition", query = "SELECT pE From PositionEntity pE WHERE pE.id = (SELECT MAX (p.id) FROM PositionEntity p) "),
	@NamedQuery(name = "Position.listOfAllPositionManager", query ="SELECT p FROM PositionEntity p WHERE p.managerPosition=:manager" ),
	@NamedQuery(name = "Position.listOfAllOpenPositionBetweenDates", query = "SELECT p FROM PositionEntity p WHERE p.status like 'OPEN' AND p.openDate >= :startDate AND p.openDate < :endDate "),
})
public class PositionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static final String LIST_OF_ALL_POSITION = "Position.listOfAllPosition";
	public static final String LIST_OF_ALL_OPEN_POSITION = "Position.listOfAllOpenPosition";
	public static final String LAST_POSITION_OF_LIST_POSITION = "Position.lastPositionOfListPosition";
	public static final String LIST_OF_ALL_POSITION_MANAGER = "Position.listOfAllPositionManager";
	public static final String LIST_OF_ALL_OPEN_POSITION_BETWEEN_DATES = "Position.listOfAllOpenPositionBetweenDates";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column (nullable=false)
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
	private Set<Localization> localization;

	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	protected StatusPosition status;

	@Column
	private int numberOfposition;

	@Temporal(TemporalType.DATE)
	@Column
	private Date SLA;

	@ManyToOne
	private UserEntity managerPosition;
	
	@ManyToOne
	private UserEntity adminPosition;

	@Column
	private String company;

	@Enumerated(EnumType.STRING)
	@Column
	private TechnicalArea technicalArea;

	@Column
	private String descriptionPosition;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<JobAdvertisingChanelEntity> jobAdvertisingChanel;

	@ManyToMany
	private List<ScriptEntity> script;



	public PositionEntity() {
		// TODO Auto-generated constructor stub
	}

	public PositionEntity(Date openDate, String code, String title, List<Localization> localization,
			StatusPosition status, int numberOfposition, Date sLA, UserEntity managerPosition,UserEntity adminPosition, String company, 
			TechnicalArea technicalArea, String descriptionPosition, List<JobAdvertisingChanelEntity> jobAdvertisingChanel,
			List<ScriptEntity> script) {
		this.openDate = openDate;
		this.code = code;
		this.title = title;
		this.localization = new HashSet<>();
		this.localization.addAll(localization);
		this.status = status;
		this.numberOfposition = numberOfposition;
		this.SLA = sLA;
		this.managerPosition = managerPosition;
		this.adminPosition = adminPosition;
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

	public Set<Localization> getLocalization() {
		return localization;
	}

	public void setLocalization(Set<Localization> localization) {
		this.localization = localization;
	}

	public StatusPosition getStatus() {
		return status;
	}

	public void setStatus(StatusPosition status) {
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
	
	public UserEntity getAdminPosition() {
		return adminPosition;
	}

	public void setAdminPosition(UserEntity adminPosition) {
		this.adminPosition = adminPosition;
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

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionEntity other = (PositionEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PositionEntity [code=" + code + ", title=" + title + "]";
	}
}
