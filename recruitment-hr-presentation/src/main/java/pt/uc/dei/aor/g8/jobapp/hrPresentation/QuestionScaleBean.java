package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class QuestionScaleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int min;
	private int max;
	private String minLabel;
	private String maxLabel;
	
	

	public QuestionScaleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public QuestionScaleBean(int min, int max, String minLabel, String maxLabel) {
		super();
		this.min = min;
		this.max = max;
		this.minLabel = minLabel;
		this.maxLabel = maxLabel;
	}



	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
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
