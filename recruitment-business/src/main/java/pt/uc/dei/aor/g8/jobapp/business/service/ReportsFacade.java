package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
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
				if(jA.getInterviews()== null && jA.getProposal()== null){
					stateSubmitted = stateSubmitted + 1;
				} else if (jA.getInterviews()!= null && jA.getProposal()== null){
					stateInterview = stateInterview + 1;
				} else if (jA.getProposal()!= null){
					stateProposal = stateProposal + 1;	
				}
			}
			rejectedCandidates.add(new ResultReport("Total rejected", total));
			rejectedCandidates.add(new ResultReport("On Submitted", stateSubmitted));
			rejectedCandidates.add(new ResultReport("On interview(s)", stateInterview));
			rejectedCandidates.add(new ResultReport("On proposal", stateProposal));
		}

		return rejectedCandidates;
	}


	@Override
	public List<ResultReport> listOfResultsInterviewsBetweenDates(Date start, Date end) {
		List<IJobApplicationProxy> appWidhInterview = appService.listOfAllAppWidhInterviewBetweenDates(start, end);
		List <ResultReport> resultsInterviews = new ArrayList<>();
		int rejected = 0;
		int newInterview = 0;
		int proposal = 0;
		int total = 0;
		for(IJobApplicationProxy jA: appWidhInterview){
			int numberInterviews = jA.getInterviews().size();
			total += numberInterviews;
			if (numberInterviews > 0) {
				if(jA.getProposal()!= null){ 
					proposal = proposal + 1;
				} else if (jA.getSituation() == JobAppSituation.REJECTED) {
					rejected = rejected + 1;
				}
				newInterview += numberInterviews-1;
			}
		}
		resultsInterviews.add(new ResultReport("Total interview(s)", total));
		if (proposal > 0) resultsInterviews.add(new ResultReport("Proposal", proposal));
		if (newInterview > 0) resultsInterviews.add(new ResultReport("New interview", newInterview));
		if (rejected > 0) resultsInterviews.add(new ResultReport("Rejected", rejected));

		return resultsInterviews;
	}



	@Override
	public List<ResultReport> averageTimeForFirstInterviewBetweenDates(Date start, Date end) {
		DateTime startDate = new DateTime(start);
		DateTime endDate = new DateTime(end);
		System.out.println("here");
		int months = Months.monthsBetween(startDate, endDate ).getMonths();
		List<ResultReport> averageTime = new ArrayList<>();

		for (int i = 0 ; i <= months ; i++){
			System.out.println(startDate.toDate()+" - "+startDate.plusMonths(i).toDate());

			List<IJobApplicationProxy> appWidhInterview = 
					appService.listOfAllAppWidhInterviewBetweenDates(startDate.plusMonths(i).toDate(),
							startDate.plusMonths(i+1).toDate());
			System.out.println(appWidhInterview);
			double average = 0;
			int counter = 0;

			for (IJobApplicationProxy app : appWidhInterview) {
				System.out.println(app.getJobAppDate());
				DateTime firstInterviewDate = getFirstInterviewDate(app.getInterviews());
				average += Days.daysBetween(new DateTime(app.getJobAppDate()), firstInterviewDate).getDays();
				counter++;
			}
			average /= counter;
			averageTime.add(new ResultReport(startDate.plusMonths(i).toDate(), (int) average));
		}
		return averageTime;
	}


	private DateTime getFirstInterviewDate(List<IJobInterviewProxy> interviews) {
		DateTime firstDate = new DateTime(interviews.get(0).getInterviewDate());
		for (IJobInterviewProxy i : interviews) {
			DateTime interviewDate = new DateTime(i.getInterviewDate());
			if (interviewDate.isBefore(firstDate)) firstDate = interviewDate;
		}
		return firstDate;
	}

	@Override
	public List<ResultReport> listOfpresentedProposalsBetweenDates(Date start, Date end) {
		List<IProposalProxy> proposals = proposalService.listOfAllProposalBetweenDates(start, end);
		List <ResultReport> presentedProposals = new ArrayList<>();
		int stateSubmitted = 0;
		int stateRejected = 0;
		int stateAccepted = 0;
		int total = 0;
		if(proposals.isEmpty()){
			presentedProposals.add(new ResultReport("Total proposal", 0));
		} else {
			for(IProposalProxy p: proposals){
				total = total + 1;
				if(p.getProposalStatus() == ProposalStatus.SUBMITTED ){
					stateSubmitted = stateSubmitted + 1;	
				} else if (p.getProposalStatus() == ProposalStatus.REJECTED){
					stateRejected = stateRejected + 1;		
				} else if (p.getProposalStatus() == ProposalStatus.ACCEPTED){
					stateAccepted = stateAccepted + 1;
				}
			}
			presentedProposals.add(new ResultReport("Total proposal", total));
			presentedProposals.add(new ResultReport("Submitted", stateSubmitted));
			presentedProposals.add(new ResultReport("Rejected", stateRejected));
			presentedProposals.add(new ResultReport("Accepted", stateAccepted));
		}
		return presentedProposals;
	}



}
