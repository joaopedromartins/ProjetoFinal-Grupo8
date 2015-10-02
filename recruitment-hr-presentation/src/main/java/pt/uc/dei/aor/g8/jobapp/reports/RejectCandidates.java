package pt.uc.dei.aor.g8.jobapp.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.time.DateUtils;

import pt.uc.dei.aor.g8.jobapp.business.service.IReportsFacade;
import pt.uc.dei.aor.g8.jobapp.business.util.ConvertStringToDate;
import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

@Named
@ViewScoped
public class RejectCandidates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IReportsFacade reportsFacade;
	@EJB
	private ConvertStringToDate converter;
	private Date startDate;
	private Date endDate;
	private List<ResultReport> rejectCandidates;
	private String from;
	private String to;
	
	
	
	public RejectCandidates() {
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<ResultReport> getRejectCandidates() {
		return rejectCandidates;
	}
	public void setRejectCandidates(List<ResultReport> rejectCandidates) {
		this.rejectCandidates = rejectCandidates;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
		this.startDate = converter.converterStringToDate(from +"-01");
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
		this.endDate = converter.converterStringToDate(to + "-01");
	}
	
	public void listOfRejectedCandidatesBetweenDates (){
		this.rejectCandidates =  reportsFacade.listOfRejectedCandidatesBetweenDates(startDate, DateUtils.addMonths(endDate, 1));
	}
	

	
	

}
