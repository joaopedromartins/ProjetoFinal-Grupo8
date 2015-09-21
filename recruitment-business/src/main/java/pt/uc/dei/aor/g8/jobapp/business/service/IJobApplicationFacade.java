package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;

public interface IJobApplicationFacade {
	
	public IJobApplicationProxy createNewJobApplication(
		 String address, String city, String country, BigInteger phone, String diploma,
		 String school, String letter, String cv, String source,
		 String status, ICandidateProxy candidate, IPositionProxy position) ;
	
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);
	
	public List <IJobApplicationProxy> listOfAll ();
	
	public List<IJobApplicationProxy> listOfJobApplicationByUsername(String username);
	
}