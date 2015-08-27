package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobAdvertisingChanelPersistenceService;


@Stateless
public class JobAdversitingChanelFacade implements IJobAdversitingChanelFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private IJobAdvertisingChanelPersistenceService service;
	
	
	public JobAdversitingChanelFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IJobAdvertisingChanelProxy addChanel(String chanelName) {
		IJobAdvertisingChanelProxy proxy = service.findNameChanel(chanelName);
		if ( proxy==null){
			IJobAdvertisingChanelProxy newChanel = factory.jobAdvertisingChanel(chanelName);
			return service.addChanel(newChanel);
		}
		return null;
		
	}

	@Override
	public List<IJobAdvertisingChanelProxy> listOfAllChanel() {
		
		return service.listOfAllChanel();
	}

}
