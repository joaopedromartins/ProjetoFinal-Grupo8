package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;

@Stateless
public class PositionProxy implements IPositionProxy, IEntityAware<PositionEntity> {

	private PositionEntity entity;

	public PositionProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public PositionProxy(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, String sLA, String userPosition,
			String company, String technicalArea, String descriptionPosition, List<String> jobAdvertisingChanel,
			List<String> script) {
		
		//TODO mudar o null do user e do script
		entity = new PositionEntity(openDate,closeDate,code,title,localization,status,numberOfposition,sLA, null,
				company,technicalArea,descriptionPosition, jobAdvertisingChanel,null); 
		
	}

	public PositionProxy(PositionEntity position){
		if (position==null){
			entity=new PositionEntity();
		} else {
			this.entity=position;
		}
	}

	@Override
	public PositionEntity getEntity() {
		return entity;
	}



}
