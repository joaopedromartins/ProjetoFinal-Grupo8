package pt.uc.dei.aor.g8.jobapp.business.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Startup
@Singleton
public class InitialBean {

	@EJB
	private IJobAdversitingChanelFacade chanelFacade;
	
	@PostConstruct
	public void initialize() {
	 chanelFacade.addChanel("Critical Software website");
	 chanelFacade.addChanel("Linkedin");
	 chanelFacade.addChanel("Glassdoor");
	 chanelFacade.addChanel("Facebook");	
	}
}
