package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;

@Stateless
public class JobApplicationPersistenceService implements IJobApplicationPersistenceService {
	
	@PersistenceContext (unitName="recruitment")
	private EntityManager em;



	@Override
	public IJobApplicationProxy saveJobApplication(IJobApplicationProxy newJobApplication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllJobApplication(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllOpenJobApplication() {
		// TODO Auto-generated method stub
		return null;
	}

}
