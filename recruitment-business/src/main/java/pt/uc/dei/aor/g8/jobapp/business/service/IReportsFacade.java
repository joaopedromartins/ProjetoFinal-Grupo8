package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.HashMap;

public interface IReportsFacade {

	public HashMap<Date,Integer> listOfAllAppSpontaneousBetweenDates(Date startDate, Date endDate);
	
	public HashMap<Date,Integer> listOfAllAppBetweenDates(Date startDate, Date endDate);
}
