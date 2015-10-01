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
public class Applications implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IReportsFacade reportsFacade;
	@EJB
	private ConvertStringToDate converter;
	private Date startDateApp;
	private Date endDateApp;
	private List<ResultReport> app;
	private String from;
	private String to;
	
	public Date getStartDateApp() {
		return startDateApp;
	}
	public void setStartDateApp(Date startDateApp) {
		this.startDateApp = startDateApp;
	}
	public Date getEndDateApp() {
		return endDateApp;
	}
	public void setEndDateApp(Date endDateApp) {
		this.endDateApp = endDateApp;
	}
	public List<ResultReport> getApp() {
		return app;
	}
	public void setApp(List<ResultReport> app) {
		this.app = app;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
		this.startDateApp = converter.converterStringToDate(from +"-01");
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
		this.endDateApp = converter.converterStringToDate(to+"-01");
	}
	public void listOfAllAppBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap " +DateUtils.addMonths(endDateApp, 1) );
		
		this.app =  reportsFacade.listOfAllAppBetweenDates(startDateApp, DateUtils.addMonths(endDateApp, 1));
	}

}
