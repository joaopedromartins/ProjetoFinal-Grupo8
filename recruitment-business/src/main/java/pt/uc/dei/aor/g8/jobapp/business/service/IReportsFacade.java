package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

public interface IReportsFacade {

	public List<ResultReport> listOfAllAppSpontaneousBetweenDates(Date startDate, Date endDate);
	
	public List<ResultReport> listOfAllAppBetweenDates(Date startDate, Date endDate);

	public List<ResultReport> listOfCandidateInPositionBetweenDates(Date start, Date end);

	public List<ResultReport> listOfRejectedCandidatesBetweenDates(Date startDate, Date endDate);

	//public List<ResultReport> listOfResultsInterviewsBetweenDates(Date start, Date end);

	public List<ResultReport> listOfpresentedProposalsBetweenDates(Date start, Date end);

	public List<ResultReport> averageTimeForFirstInterviewBetweenDates(Date start, Date end);
}
