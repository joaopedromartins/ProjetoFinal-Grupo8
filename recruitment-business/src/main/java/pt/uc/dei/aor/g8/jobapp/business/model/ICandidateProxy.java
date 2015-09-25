package pt.uc.dei.aor.g8.jobapp.business.model;


public interface ICandidateProxy {
	public long getId();
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public String getLastname();
	public void setLastname(String lastname);
	public String getFirstname();
	public void setFirstname(String firstname);
	public String getEmail();
	public void setEmail(String email);
	public String getMobile();
	public void setMobile(String mobile);
	public String getLinkedinAddress();
	public void setLinkedinAddress(String linkedinAddress);
	public String getFullName();
}
