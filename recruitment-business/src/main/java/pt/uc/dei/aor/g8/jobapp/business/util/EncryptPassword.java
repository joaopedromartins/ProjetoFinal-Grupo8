package pt.uc.dei.aor.g8.jobapp.business.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class EncryptPassword {
	
	public String encriptarPass(String pass)  {

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
