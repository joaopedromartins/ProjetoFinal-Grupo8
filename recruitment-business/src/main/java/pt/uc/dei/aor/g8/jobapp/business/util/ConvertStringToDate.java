package pt.uc.dei.aor.g8.jobapp.business.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class ConvertStringToDate {
	
	public Date converterStringToDate (String date){
		System.out.println( date );
		DateFormat formatter;
		Date convertedDate;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			convertedDate = (Date)formatter.parse(date);
			System.out.println( convertedDate );
			return convertedDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
