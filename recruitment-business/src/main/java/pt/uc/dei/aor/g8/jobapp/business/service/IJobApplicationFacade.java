package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;

public interface IJobApplicationFacade {
	
	public IJobApplicationProxy createNewJobApplication(
		 String address, String city, String country, BigInteger phone, String diploma,
		 String school, String letter, String cv, IJobAdvertisingChanelProxy source,
		 String status);
	
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);
}