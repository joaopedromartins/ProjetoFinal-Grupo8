package pt.uc.dei.aor.g8.jobapp.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.service.IReportsFacade;
import pt.uc.dei.aor.g8.jobapp.business.util.ConvertStringToDate;
import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

@Named
@ViewScoped
public class AverageTimeForFirstInterview implements Serializable{

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
	private List<ResultReport> averageTimeForFirstInterview;
	private String from;
	private String to;
	
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date startDate) {
		this.start = startDate;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date endDate) {
		this.end = endDate;
	}
	
	public List<ResultReport> getAverageTimeForFirstInterview() {
		return averageTimeForFirstInterview;
	}
	public void setAverageTimeForFirstInterview(List<ResultReport> averageTimeForFirstInterview) {
		this.averageTimeForFirstInterview = averageTimeForFirstInterview;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
		this.start = converter.converterStringToDate(from+"-01");
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
		this.end = converter.converterStringToDate(to+"-01");
	}
	public void averageTimeForFirstInterviewBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.averageTimeForFirstInterview =  reportsFacade.averageTimeForFirstInterviewBetweenDates(start, end);
	}

}
