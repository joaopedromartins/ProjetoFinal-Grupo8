package pt.uc.dei.aor.g8.jobapp.business.util;

import javax.ejb.Stateless;

import org.apache.commons.lang3.RandomStringUtils;

@Stateless
public class AutoGeneratePasswor {
	
	public String autoGeneratePassword (){
		String autoGeneratePassword = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("PassWor random = " + autoGeneratePassword);
		return autoGeneratePassword;	
	}

}
