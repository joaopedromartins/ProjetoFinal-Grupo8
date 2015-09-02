package pt.uc.dei.aor.g8.jobapp.business.persistence;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IUserPersistenceService {

	public IUserProxy createUser(IUserProxy proxy);

}
