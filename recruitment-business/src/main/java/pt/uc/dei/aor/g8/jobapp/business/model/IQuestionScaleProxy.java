package pt.uc.dei.aor.g8.jobapp.business.model;

public interface IQuestionScaleProxy {

	
	public int getMinimum();
	public void setMinimum(int minimum);


	public int getMaximum();
	public void setMaximum(int maximum);
	
	public String getMinLabel();
	public void setMinLabel(String minLabel);


	public String getMaxLabel();
	public void setMaxLabel(String maxLabel);
	
}
