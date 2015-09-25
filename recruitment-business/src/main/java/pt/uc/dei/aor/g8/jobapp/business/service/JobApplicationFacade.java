package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.util.GmailMessage;

@Stateless
public class JobApplicationFacade implements IJobApplicationFacade {

	private static final Logger log = LoggerFactory.getLogger(JobApplicationFacade.class);
	@EJB
	private IProxyFactory factory;

	@EJB
	private IJobApplicationPersistenceService service;

	@EJB
	private INotificationFacade notification;

	@EJB
	private GmailMessage mail;

	public JobApplicationFacade() {
	}

	@Override
	public IJobApplicationProxy createNewJobApplication(String address, String city, String country, String phone,
			String diploma, String school, String letter, String cv, String source,
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
				school, letter, cv, source, candidate, position);

		IJobApplicationProxy returnJobApp = service.saveJobApplication(newJobApplication);

		if (returnJobApp!=null) {
			//Notify Position Manager on HR Application
			notification.createNotification("Job Application Submission",
					"Job Application Submission Details:\n" + 
							"\tPosition: \t"+ position.getTitle() + "\t(Code: " + position.getCode() + ")" +
							"\tCandidate: \t" + candidate.getFirstname() + " " + candidate.getLastname() ,
							"Message sent automaticaly.\nDo not reply to this address.",
							position.getManagerPosition() );

			//Notify Manager by email
			mail.sendEmail(candidate.getEmail(), 
					"jobappmailtest@gmail.com",  
					"Job Application Submission: " + position.getTitle(),
					"Dear " +  position.getManagerPosition().getFirstname() + ",\n" +
							"Job Application Submission Details:\n" + 
							"\tPosition: \t"+ position.getTitle() + "\t(Code: " + position.getCode() + ")" +
							"\tCandidate: \t" + candidate.getFirstname() + " " + candidate.getLastname() + "\n\n" +
							"Message sent automaticaly.\nDo not reply to this address."
					);

			//Notify Candidate by email
			mail.sendEmail(candidate.getEmail(), 
					"jobappmailtest@gmail.com", 
					"Job Application Submission: " + position.getTitle(),
					"Dear " +  candidate.getFirstname() + ",\n" +
							"Your application for the position "+ position.getTitle() + " has been received. " + 
							"We are presently in the process of reviewing each applicants resume. " + 
							"Due to the high level of interest in the position, we will not be able to interview every applicant. " +
							"A review of each application will be made to determine which of the applicants will be invited to come for an interview.\n" +
							"Objective criteria, based upon the duties of "  + 
							position.getTitle() + ", are being used for this review process.\n" +
							"We anticipate that we will be back in touch with you until " + 
							position.getSLA().toString() + " to inform you of the results of this process. " + 
							"We appreciate your patience, and hope you can understand our desire to ensure that every applicant receives full consideration." +
							"\n\nRegards,\n" + 
							position.getManagerPosition().getFirstname() + " " + position.getManagerPosition().getLastname() 
					);
		}
		return returnJobApp;
	}


	@Override
	public IJobApplicationProxy creatSpontaneousJobApplication(String address, String city, String country, String phone,
			String diploma, String school, String letter, String cv, String source,
			ICandidateProxy candidate) {

		//test if candidate is null
		if (candidate == null) {
			return null;
			//test if spontaneousJobb is not null (had spontaneous JobApp already)
		} else if (service.spontaneousJobApllicationByCandidate(candidate) != null) {
			return null;
		}

		IJobApplicationProxy newJobApplication = factory.spontaneousJobApplication(address, city, country, phone, diploma, school, letter, cv, source, candidate);

		IJobApplicationProxy returnJobApp = service.saveJobApplication(newJobApplication);

		if (returnJobApp!=null) {
			//Notify Candidate by email
			//TODO text of email
			mail.sendEmail(candidate.getEmail(), 
					"jobappmailtest@gmail.com", 
					"Spontaneous Job Application Submission",
					"Dear " +  candidate.getFirstname() + ",\nYour spontaneous application  has been received.\n\nRegards,\n");
		}
		return returnJobApp;
	}




	@Override
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy) {
		//test if jobApplicationProxy is null
		if (jobApplicationProxy == null) {
			return null;
			//test if candidate is null	
		} else if (jobApplicationProxy.getCandidateEntity() == null) {
			return null;
			//test if position is null	
		} else if (jobApplicationProxy.getPositionEntity() == null) {
			return null;
			//test is job application status is Open to allow change
			//TODO depois de submetida não deveria ser editada
		} else if (! (jobApplicationProxy.getSituation().equals(JobAppSituation.SUBMITTED))) {
			return null;
		}

		IJobApplicationProxy returnJobApp = service.editJobApplication(jobApplicationProxy);

		if (returnJobApp!=null) {
			//Notify Position Manager on HR Application
			notification.createNotification("Job Application Modification",
					"Job Application Submission Modification Details:\n" + 
							"\tPosition: \t"+ jobApplicationProxy.getPositionEntity().getTitle() + "\t(Code: " + 
							jobApplicationProxy.getPositionEntity().getCode() + ")\n" +
							"\tCandidate: \t" + jobApplicationProxy.getCandidateEntity().getFirstname() + " " + 
							jobApplicationProxy.getCandidateEntity().getLastname() ,
							"Message sent automaticaly.\nDo not reply to this address.",
							jobApplicationProxy.getPositionEntity().getManagerPosition() );

			//Notify Manager by email
			mail.sendEmail(jobApplicationProxy.getCandidateEntity().getEmail(), 
					"jobappmailtest@gmail.com",  
					"Job Application Submission Modification: " + jobApplicationProxy.getPositionEntity().getTitle(),
					"Dear " +  jobApplicationProxy.getPositionEntity().getManagerPosition().getFirstname() + ",\n" +
							"Job Application Submission Details:\n" + 
							"\tPosition: \t"+ jobApplicationProxy.getPositionEntity().getTitle() + "\t(Code: " + jobApplicationProxy.getPositionEntity().getCode() + ")\n" +
							"\tCandidate: \t" + jobApplicationProxy.getCandidateEntity().getFirstname() + " " + jobApplicationProxy.getCandidateEntity().getLastname() + "\n\n" +
							"Message sent automaticaly.\nDo not reply to this address."
					);

			//Notify Candidate by email
			mail.sendEmail(jobApplicationProxy.getCandidateEntity().getEmail(), 
					"jobappmailtest@gmail.com", 
					"Job Application Submission: " + jobApplicationProxy.getPositionEntity().getTitle(),
					"Dear " +  jobApplicationProxy.getCandidateEntity().getFirstname() + ",\n" +
							"Your application for the position "+ jobApplicationProxy.getPositionEntity().getTitle() + " has been modified. " + 
							"We are presently in the process of reviewing each applicants resume. " + 
							"Due to the high level of interest in the position, we will not be able to interview every applicant. " +
							"A review of each application will be made to determine which of the applicants will be invited to come for an interview.\n" +
							"Objective criteria, based upon the duties of "  + 
							jobApplicationProxy.getPositionEntity().getTitle() +
							", are being used for this review process.\n" +
							"We anticipate that we will be back in touch with you until " + 
							jobApplicationProxy.getPositionEntity().getSLA().toString() +
							" to inform you of the results of this process. " + 
							"We appreciate your patience, and hope you can understand our desire to ensure that every applicant receives full consideration." +
							"\n\nRegards,\n" + 
							jobApplicationProxy.getPositionEntity().getManagerPosition().getFirstname() + " " + 
							jobApplicationProxy.getPositionEntity().getManagerPosition().getLastname() 
					);
		}

		return returnJobApp;
	}

	@Override
	public List<IJobApplicationProxy> listOfAll() {
		return service.findAllJobApplication();
	}

	@Override
	public IJobApplicationProxy findId(long id) {

		return service.findById(id);
	}

	@Override
	public List<IJobApplicationProxy> listOfJobApplicationByUsername(String username) {
		return service.listOfAllCandidateJobApplication(username);
	}

	@Override
	public List<IJobApplicationProxy> listOfJobApplicationByCandidate(ICandidateProxy candidate) {		
		try {
			return service.listOfJobApplicationByCandidate(candidate);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}
}
