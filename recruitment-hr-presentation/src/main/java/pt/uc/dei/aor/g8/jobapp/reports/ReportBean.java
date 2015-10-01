package pt.uc.dei.aor.g8.jobapp.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.service.IReportsFacade;
import pt.uc.dei.aor.g8.jobapp.business.util.ResultReport;

@Named
@ViewScoped
public class ReportBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IReportsFacade reportsFacade;
	private Date startDateSpontaneousApp;
	private Date endDateSpontaneousApp;
	private List<ResultReport> spontaneousApp;
	private Date startDateApp;
	private Date endDateApp;
	private List<ResultReport> app;
	
	public ReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public void listOfAllAppSpontaneousBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.spontaneousApp =  reportsFacade.listOfAllAppSpontaneousBetweenDates(startDateSpontaneousApp, endDateSpontaneousApp);
	}
	
	public void listOfAllAppBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.app =  reportsFacade.listOfAllAppBetweenDates(startDateApp, endDateApp);
	}
	
	

}
