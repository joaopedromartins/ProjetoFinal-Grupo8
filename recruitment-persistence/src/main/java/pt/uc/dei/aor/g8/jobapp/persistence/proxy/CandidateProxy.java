package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.math.BigInteger;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;

@Stateless
public class CandidateProxy implements ICandidateProxy, IEntityAware<CandidateEntity> {

	private CandidateEntity entity;

	public CandidateProxy() {
		
	}

	public CandidateProxy(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		this.entity = new CandidateEntity(username, password, lastname, firstname, email, mobile);
	}

	public CandidateProxy (CandidateEntity candidate){
		if (candidate==null){
			this.entity=new CandidateEntity();
		} else {
			this.entity=candidate;
		}
	}


	@Override
	public CandidateEntity getEntity() {
		return entity;
	}

	
	@Override
	public long getId() {
		return entity.getId();
	}

	@Override
	public String getUsername() {
		return entity.getUsername();
	}
	@Override
	public void setUsername(String username) {
		entity.setUsername(username);
		
	}

	@Override
	public String getPassword() {
		return entity.getPassword();
	}
	@Override
	public void setPassword(String password) {
		entity.setPassword(password);
	}

	@Override
	public String getLastname() {
		return entity.getLastname();
	}
	@Override
	public void setLastname(String lastname) {
		entity.setLastname(lastname);
	}

	@Override
	public String getFirstname() {
		return entity.getFirstname();
	}
	@Override
	public void setFirstname(String firstname) {
		entity.setFirstname(firstname);
	}

	@Override
	public String getEmail() {
		return entity.getEmail();
	}
	@Override
	public void setEmail(String email) {
		entity.setEmail(email);
	}

	@Override
	public BigInteger getMobile() {
		return entity.getMobile();
	}

	@Override
	public void setMobile(BigInteger mobile) {
		entity.setMobile(mobile);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return entity.equals(((IEntityAware<CandidateEntity>)o).getEntity());
	}
	
	@Override
	public int hashCode() {
		return entity.hashCode();
	}
	
	@Override
	public String toString() {
		return entity.toString();
	}

	
}
