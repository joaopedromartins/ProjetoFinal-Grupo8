package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IUserPersistenceService {

	public IUserProxy createUser(IUserProxy proxy);
	public IUserProxy findUserByUsername (String username);
	public IUserProxy findUserByEmail (String email);
	public List <IUserProxy> findManagers();
	public List <IUserProxy> findInterviewers();

}
