package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "JobAdvertisingChanel")
@NamedQueries({
	@NamedQuery(name = "JobAdvertisingChanel.listOfAllChanels", query = "SELECT c FROM JobAdvertisingChanelEntity c"),
	@NamedQuery(name = "JobAdvertisingChanel.chanelName", query = "SELECT c FROM JobAdvertisingChanelEntity c WHERE c.chanelName=:chanelName"),
})

public class JobAdvertisingChanelEntity {

	public static final String LIST_OF_ALL_CHANELS = "JobAdvertisingChanel.listOfAllChanels";
	public static final String CHANEL_NAME = "JobAdvertisingChanel.chanelName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String chanelName;

	public JobAdvertisingChanelEntity () {
		// TODO Auto-generated constructor stub
	}


	public JobAdvertisingChanelEntity(String chanelName) {
		this.chanelName = chanelName;
	}


	public String getChanelName() {
		return chanelName;
	}


	public void setChanelName(String chanelName) {
		this.chanelName = chanelName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chanelName == null) ? 0 : chanelName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		JobAdvertisingChanelEntity other = (JobAdvertisingChanelEntity) obj;
		if (chanelName == null) {
			if (other.chanelName != null)
				return false;
		} else if (!chanelName.equals(other.chanelName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
