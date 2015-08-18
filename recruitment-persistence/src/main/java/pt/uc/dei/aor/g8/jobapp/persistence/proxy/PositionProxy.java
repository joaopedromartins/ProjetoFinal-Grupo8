package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import pt.uc.dei.aor.g8.jobapp.business.model.IPosition;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;

public class PositionProxy implements IPosition {
	
	private PositionEntity entity;

	public PositionProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public PositionProxy(PositionEntity position){
		if (position==null){
			entity=new PositionEntity();
		} else {
			this.entity=position;
		}
	}
	
	

}
