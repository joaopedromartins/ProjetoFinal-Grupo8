package pt.uc.dei.aor.g8.jobapp.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

//import org.apache.commons.lang3.time.DateUtils;

import pt.uc.dei.aor.g8.jobapp.business.service.IReportsFacade;
import pt.uc.dei.aor.g8.jobapp.business.util.ConvertStringToDate;
import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

@Named
@ViewScoped
public class ResultsInterviews implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IReportsFacade reportsFacade;
	@EJB
	private ConvertStringToDate converter;
	private Date start;
	private Date end;
	private List<ResultReport> resultsInterviews;
	private String from;
	private String to;
	
	public ResultsInterviews() {
	}
	
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public List<ResultReport> getResultsInterviews() {
		return resultsInterviews;
	}
	public void setResultsInterviews(List<ResultReport> resultsInterviews) {
		this.resultsInterviews = resultsInterviews;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
		this.start = converter.converterStringToDate(from +"-01");
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
		this.end = converter.converterStringToDate(to + "-01");
	}
	
	public void listOfResultsInterview(){
		//this.resultsInterviews =  reportsFacade.listOfResultsInterviewsBetweenDates(start, DateUtils.addMonths(end, 1));
	}

}
