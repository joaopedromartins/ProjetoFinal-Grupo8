package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.Date;
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
import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

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
	@EJB
	private ResultReport result;

	public ReportsFacade() {
	}

	@Override
	public List<ResultReport> listOfAllAppSpontaneousBetweenDates(Date startDate, Date endDate) {
		DateTime start = new DateTime(startDate);

		System.out.println("facade" + start);

		DateTime end = new DateTime(endDate);

		System.out.println("facade" + end);

		int months = Months.monthsBetween(start, end ).getMonths();

		System.out.println("facade" + months);

		List<ResultReport> spontaneousApp = new ArrayList<>();
		Integer quantity;
		for (int i = 0 ; i <= months ; i++){
			List <IJobApplicationProxy> proxy = appService.listOfAllAppSpontaneousBetweenDates(start.plusMonths(i).toDate(), start.plusMonths(i+1).toDate());

			if( proxy == null){
				quantity = 0;
			} else {
				quantity = proxy.size();
			}
			spontaneousApp.add(new ResultReport(start.plusMonths(i).toDate(), quantity));
			System.out.println("key" + start.plusMonths(i).toDate() + "value" + quantity );
		}
		System.out.println("facade" + spontaneousApp);
		return spontaneousApp;
	}

	@Override
	public List<ResultReport> listOfAllAppBetweenDates(Date startDate, Date endDate) {
		DateTime start = new DateTime(startDate);
		DateTime end = new DateTime(endDate);
		int months = Months.monthsBetween(start, end ).getMonths();
		List<ResultReport> app = new ArrayList<>();
		Integer quantity;
		for (int i = 0 ; i <= months ; i++){
			List <IJobApplicationProxy> proxy = appService.listOfAllAppBetweenDates(start.plusMonths(i).toDate(), start.plusMonths(i+1).toDate());
			if( proxy == null){
				quantity = 0;
			} else {
				quantity = proxy.size();
			}
			app.add(new ResultReport(start.plusMonths(i).toDate(), quantity));
			System.out.println("key" + start.plusMonths(i).toDate() + "value" + quantity );
		}
		System.out.println("facade" + app);
		return app;
	}



}
