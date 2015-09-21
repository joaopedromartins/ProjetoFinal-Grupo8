package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;

@Stateless
public class JobInterviewFacade implements IJobInterviewFacade {

	@EJB
	private IProxyFactory factory;
	@EJB
	private IJobInterviewPersistenceService service;
	
	@Override
	public IJobInterviewProxy newInterview(Date interviewDate, IUserProxy userInterviewer,
			IJobApplicationProxy jobapplication) {
		IJobInterviewProxy newInterview = factory.jobInterview(interviewDate, userInterviewer, jobapplication);
		return service.newInterview(newInterview);
	}

}
