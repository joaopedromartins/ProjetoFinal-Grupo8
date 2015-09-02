package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;


@Startup
@Singleton
public class InitialBean {

	@EJB
	private IJobAdversitingChanelFacade chanelFacade;
	@EJB
	private IUserFacade userFacade;
	
	@PostConstruct
	public void initialize() {
	 chanelFacade.addChanel("Critical Software website");
	 chanelFacade.addChanel("Linkedin");
	 chanelFacade.addChanel("Glassdoor");
	 chanelFacade.addChanel("Facebook");
	 List <RoleType> roles= new ArrayList<>();
	 roles.add(RoleType.ADMINISTRATOR);
	 userFacade.createUser("admin", "admin", "lastname", "firstname", "admin@gmail.com", roles );
	}
}
