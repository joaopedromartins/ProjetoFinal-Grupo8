package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;

public interface IJobAdversitingChanelFacade {
	
	public IJobAdvertisingChanelProxy addChanel(String chanelName);
	public List<IJobAdvertisingChanelProxy> listOfAllChanel();

}
