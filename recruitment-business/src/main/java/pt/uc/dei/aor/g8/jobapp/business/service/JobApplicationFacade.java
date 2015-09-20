package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;

@Stateless
public class JobApplicationFacade implements IJobApplicationFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private IJobApplicationPersistenceService service;

	public JobApplicationFacade() {
	}

	@Override
	public IJobApplicationProxy createNewJobApplication(String address, String city, String country, BigInteger phone,
			String diploma, String school, String letter, String cv, String source, String status,
			ICandidateProxy candidate, IPositionProxy position) {
		
		//test if candidate is null
		if (candidate == null) {
			return null;
		//test if position is null	
		} else if (position == null) {
			return null;
		} else if (service.existsJobApplicationToPositionCodeAndUsername(position.getCode(), candidate.getUsername() )) {
			return null;
		}
		
		IJobApplicationProxy newJobApplication = factory.jobApplication(
				  address, city, country, phone, diploma,
				  school, letter, cv, source, status, candidate, position);
		
		
		return service.saveJobApplication(newJobApplication);
	}

	@Override
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy) {
		
		return service.editJobApplication(jobApplicationProxy);
	}

	@Override
	public List<IJobApplicationProxy> listOfAll() {
		return service.findAllJobApplication();
	}
	
	
}
