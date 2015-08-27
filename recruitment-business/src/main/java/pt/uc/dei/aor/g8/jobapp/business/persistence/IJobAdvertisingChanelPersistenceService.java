package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;

public interface IJobAdvertisingChanelPersistenceService {

	public IJobAdvertisingChanelProxy addChanel(IJobAdvertisingChanelProxy newChanel);
	public List<IJobAdvertisingChanelProxy> listOfAllChanel();
	public IJobAdvertisingChanelProxy findNameChanel (String nameChanel);
	
}
