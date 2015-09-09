package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;

@Stateless
public class JobApplicationFacade implements IJobApplicationFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private IJobApplicationPersistenceService service;

	public JobApplicationFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IJobApplicationProxy createNewJobApplication(String address, String city, String country, BigInteger phone,
			String diploma, String school, String letter, String cv, IJobAdvertisingChanelProxy source, String status) {
		
		IJobApplicationProxy newJobApplication = factory.jobApplication(
				  address, city, country, phone, diploma,
				  school, letter, cv, source, status);
		
		
		return service.saveJobApplication(newJobApplication);
	}

	@Override
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy) {
		// TODO Auto-generated method stub
		//return null;
		return service.editJobApplication(jobApplicationProxy);
	}
	
	
}
