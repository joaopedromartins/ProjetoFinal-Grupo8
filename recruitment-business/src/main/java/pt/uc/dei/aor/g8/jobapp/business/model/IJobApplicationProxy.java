package pt.uc.dei.aor.g8.jobapp.business.model;

import java.math.BigInteger;

public interface IJobApplicationProxy {

	public ICandidateProxy getCandidateEntity() ;
	public IPositionProxy getPositionEntity() ;
	
	public String getAddress();
	public void setAddress(String address);
	public String getCity() ;
	public void setCity(String city);
	public String getCountry() ;
	public void setCountry(String country) ;
	public BigInteger getPhone();
	public void setPhone(BigInteger phone) ;
	public String getDiploma();
	public void setDiploma(String diploma);
	public String getSchool() ;
	public void setSchool(String school);
	public String getLetter() ;
	public void setLetter(String letter) ;
	public String getCv() ;
	public void setCv(String cv);
	public IJobAdvertisingChanelProxy getSource() ;
	public void setSource(IJobAdvertisingChanelProxy source) ;
	public long getId() ;
	public long getStatus() ;
}
