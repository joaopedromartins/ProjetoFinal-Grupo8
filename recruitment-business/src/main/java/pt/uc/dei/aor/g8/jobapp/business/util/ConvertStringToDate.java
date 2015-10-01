package pt.uc.dei.aor.g8.jobapp.business.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class ConvertStringToDate {
	
	public Date converterStringToDate (String date){
		DateFormat formatter;
		Date convertedDate;
		formatter = new SimpleDateFormat("dd MMMM yyyy");
		try {
			convertedDate = (Date)formatter.parse(date);
			return convertedDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
