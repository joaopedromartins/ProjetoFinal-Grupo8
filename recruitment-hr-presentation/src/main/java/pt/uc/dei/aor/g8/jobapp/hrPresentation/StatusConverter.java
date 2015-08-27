package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;


import pt.uc.dei.aor.g8.business.enumeration.Status;


@FacesConverter(value="statusConverter")
public class StatusConverter extends EnumConverter {

	public StatusConverter() {
		
		   super(Status.class);
	}

}
