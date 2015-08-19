package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import pt.uc.dei.aor.g8.business.enumeration.Localization;


@FacesConverter(value="localizationConverter")
public class LocalizationConverterStringEnum extends EnumConverter {

	public LocalizationConverterStringEnum() {
		
		   super(Localization.class);
	}

}
