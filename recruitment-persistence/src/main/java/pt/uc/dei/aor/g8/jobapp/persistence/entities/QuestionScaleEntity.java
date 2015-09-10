package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionScale")
public class QuestionScaleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private int minimum;
	
	@Column
	private int maximum;
	
	@Column
	private String minLabel;
	
	@Column
	private String maxLabel;

	
	
	public QuestionScaleEntity() {
		
	}
	
	public QuestionScaleEntity(int minimum, int maximum, String minLabel, String maxLabel) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
		this.minLabel = minLabel;
		this.maxLabel = maxLabel;
	}




	public int getMinimum() {
		return minimum;
	}


	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}


	public int getMaximum() {
		return maximum;
	}


	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


	public String getMinLabel() {
		return minLabel;
	}


	public void setMinLabel(String minLabel) {
		this.minLabel = minLabel;
	}


	public String getMaxLabel() {
		return maxLabel;
	}


	public void setMaxLabel(String maxLabel) {
		this.maxLabel = maxLabel;
	}



	
	
	
	
	

}
