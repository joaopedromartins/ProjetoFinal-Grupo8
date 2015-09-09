package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;

public interface IJobApplicationFacade {
	public IJobApplicationProxy createNewJobApplication(String username, String code, String lastname, String firstname, String email, BigInteger mobile);
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);
	public ICandidateProxy findCandidateByUsername(String username);
	public IPositionProxy findPositionByCode(String code);
}