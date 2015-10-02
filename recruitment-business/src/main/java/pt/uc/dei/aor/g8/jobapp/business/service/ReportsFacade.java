package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Months;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
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
		DateTime end = new DateTime(endDate);
		int months = Months.monthsBetween(start, end ).getMonths();
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
		}
		return spontaneousApp;
	}

	@Override
	public List<ResultReport> listOfAllAppBetweenDates(Date startDate, Date endDate) {
		DateTime start = new DateTime(startDate);
		DateTime end = new DateTime(endDate);
		int months = Months.monthsBetween(start, end ).getMonths();
		List<ResultReport> app = new ArrayList<>();
		Integer quantity;
		for (int i = 0 ; i < months ; i++){
			List <IJobApplicationProxy> proxy = appService.listOfAllAppBetweenDates(start.plusMonths(i).toDate(), start.plusMonths(i+1).toDate());
			if( proxy == null){
				quantity = 0;
			} else {
				quantity = proxy.size();
			}
			app.add(new ResultReport(start.plusMonths(i).toDate(), quantity));
		}
		return app;
	}

	@Override
	public List<ResultReport> listOfCandidateInPositionBetweenDates(Date start, Date end) {
		List<IPositionProxy> positions = positionService.listOfAllOpenPositionBetweenDates(start, end);
		List <ResultReport> candidatesInPosition = new ArrayList<>();
		if ( positions.isEmpty()){
			candidatesInPosition.add(new ResultReport("Don´t have open position", 0));		
		} else {
			for(IPositionProxy p: positions){
				List <IJobApplicationProxy> proxy = appService.listOfAllAppByPosition(p);
				if(proxy == null){
					candidatesInPosition.add(new ResultReport(p.getTitle(), 0));
				} else {
					candidatesInPosition.add(new ResultReport(p.getTitle(), proxy.size()));
				}
			}
		}
		return candidatesInPosition;
	}

	@Override
	public List<ResultReport> listOfRejectedCandidatesBetweenDates(Date startDate, Date endDate) {
		List<IJobApplicationProxy> appRejected = appService.listOfAllApplicationRejectedBetweenDates(startDate, endDate);
		List <ResultReport> rejectedCandidates = new ArrayList<>();
		int stateSubmitted = 0;
		int stateInterview = 0;
		int stateProposal = 0;
		int total = 0;
		if(appRejected.isEmpty()){
			rejectedCandidates.add(new ResultReport("Total rejected", 0));
		} else {
			for(IJobApplicationProxy jA: appRejected){
				total = total + 1;
				rejectedCandidates.add(new ResultReport("Total rejected", total));
				if(jA.getInterviews()== null && jA.getProposal()== null){
					stateSubmitted = stateSubmitted + 1;
					rejectedCandidates.add(new ResultReport("On Submitted", stateSubmitted));
				} else if (jA.getInterviews()!= null && jA.getProposal()== null){
					stateInterview = stateInterview + 1;
					rejectedCandidates.add(new ResultReport("On interview(s)", stateSubmitted));
				} else if (jA.getProposal()!= null){
					stateProposal = stateProposal + 1;
					rejectedCandidates.add(new ResultReport("On proposal", stateProposal));
				}
			}
		}
		return rejectedCandidates;
	}

}
