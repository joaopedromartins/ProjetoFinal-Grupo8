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
public class SpontaneousApp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IReportsFacade reportsFacade;
	@EJB
	private ConvertStringToDate converter;
	
	private Date startDateSpontaneousApp;
	private Date endDateSpontaneousApp;
	private List<ResultReport> spontaneousApp;
	private String from;
	private String to;
	
	
	public Date getStartDateSpontaneousApp() {
		return startDateSpontaneousApp;
	}
	public void setStartDateSpontaneousApp(Date startDate) {
		this.startDateSpontaneousApp = startDate;
	}
	public Date getEndDateSpontaneousApp() {
		return endDateSpontaneousApp;
	}
	public void setEndDateSpontaneousApp(Date endDate) {
		this.endDateSpontaneousApp = endDate;
	}
	
	public List<ResultReport> getSpontaneousApp() {
		return spontaneousApp;
	}
	public void setSpontaneousApp(List<ResultReport> spontaneousApp) {
		this.spontaneousApp = spontaneousApp;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
		this.startDateSpontaneousApp = converter.converterStringToDate("01 "+from);
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
		this.endDateSpontaneousApp = converter.converterStringToDate("01 "+to);
	}
	public void listOfAllAppSpontaneousBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.spontaneousApp =  reportsFacade.listOfAllAppSpontaneousBetweenDates(startDateSpontaneousApp, endDateSpontaneousApp);
	}
}
