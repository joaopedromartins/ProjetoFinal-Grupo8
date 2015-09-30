package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Months;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IProposalPresistenceService;

@Stateless
public class ReportsFacade implements IReportsFacade {
	
	@EJB
	private IJobApplicationPersistenceService appService;
	@EJB
	private IPositionPersistenceService positionService;
	@EJB
	private IProposalPresistenceService proposalService;
	@EJB
	private IJobInterviewPersistenceService interviewService;
	
	public ReportsFacade() {
	}

	@Override
	public HashMap<Date,Integer> listOfAllAppSpontaneousBetweenDates(Date startDate, Date endDate) {
		DateTime start = new DateTime(startDate);
		
				System.out.println("facade" + start);
		
		DateTime end = new DateTime(endDate);
		
				System.out.println("facade" + end);
		
		int months = Months.monthsBetween(start, end ).getMonths();
		
				System.out.println("facade" + months);
		
		HashMap<Date, Integer> spontaneousApp = new HashMap<>();
		Integer quantity;
		for (int i = 0 ; i < months ; i++){
			List <IJobApplicationProxy> proxy = appService.listOfAllAppSpontaneousBetweenDates(start.plusMonths(i).toDate(), start.plusMonths(i+1).toDate());
			
			if( proxy == null){
				quantity = 0;
			} else {
				quantity = proxy.size();
			}
			spontaneousApp.put(start.plusMonths(i).toDate(), quantity);
			System.out.println("key" + start.plusMonths(i).toDate() + "value" + quantity );
		}
		System.out.println("facade" + spontaneousApp);
		return spontaneousApp;
	}

	@Override
	public HashMap<Date,Integer> listOfAllAppBetweenDates(Date startDate, Date endDate) {
		DateTime start = new DateTime(startDate);
		DateTime end = new DateTime(endDate);
		int months = Months.monthsBetween(start, end ).getMonths();
		HashMap<Date, Integer> app = new HashMap<>();
		Integer quantity;
		for (int i = 0 ; i < months ; i++){
			quantity =  (appService.listOfAllAppSpontaneousBetweenDates(start.plusMonths(i).toDate(), start.plusMonths(i+1).toDate())).size();
			app.put(start.plusMonths(i).toDate(), quantity);
		}
		return app;
	}
	


}
