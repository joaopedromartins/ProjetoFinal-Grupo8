package pt.uc.dei.aor.g8.jobapp.business.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobAdversitingChanelFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;


@Startup
@Singleton
public class InitialBean {

	@EJB
	private IJobAdversitingChanelFacade chanelFacade;
	@EJB
	private IUserFacade userFacade;
	
	@EJB
	private EncryptPassword passwordEncrypt;

	@PostConstruct
	public void initialize() {
		chanelFacade.addChanel("Critical Software website");
		chanelFacade.addChanel("Linkedin");
		chanelFacade.addChanel("Glassdoor");
		chanelFacade.addChanel("Facebook");
		List <RoleType> roles= new ArrayList<>();
		roles.add(RoleType.ADMINISTRATOR);

		String password = passwordEncrypt.encriptarPass("admin");
		userFacade.createUser("admin", password, "lastname", "firstname", "admin@gmail.com", roles );
		
	}

	

}
