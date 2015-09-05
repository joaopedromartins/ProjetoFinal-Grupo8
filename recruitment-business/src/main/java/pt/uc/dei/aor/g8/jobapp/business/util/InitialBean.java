package pt.uc.dei.aor.g8.jobapp.business.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.codec.binary.Base64;

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

	@PostConstruct
	public void initialize() {
		chanelFacade.addChanel("Critical Software website");
		chanelFacade.addChanel("Linkedin");
		chanelFacade.addChanel("Glassdoor");
		chanelFacade.addChanel("Facebook");
		List <RoleType> roles= new ArrayList<>();
		roles.add(RoleType.ADMINISTRATOR);

		
		userFacade.createUser("admin", encriptarPass("admin"), "lastname", "firstname", "admin@gmail.com", roles );
		
		
	}

	private String encriptarPass(String pass)  {

		MessageDigest algorithm;
		byte messageDigest[];
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			messageDigest = algorithm.digest(pass.getBytes("UTF-8"));
			String senha= Base64.encodeBase64String(messageDigest);
			return senha;
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return null;
	}

}
