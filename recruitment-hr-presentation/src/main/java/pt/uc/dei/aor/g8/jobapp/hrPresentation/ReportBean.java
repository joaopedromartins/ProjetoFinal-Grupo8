package pt.uc.dei.aor.g8.jobapp.hrPresentation;

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
	private Date startDate;
	private Date endDate;
	private List<ResultReport> spontaneousApp;
	private List<ResultReport> app;
	
	public ReportBean() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Date getLocalDate() {
		return new Date();
	}
	public List<ResultReport> getSpontaneousApp() {
		return spontaneousApp;
	}
	public void setSpontaneousApp(List<ResultReport> spontaneousApp) {
		this.spontaneousApp = spontaneousApp;
	}
	public List<ResultReport> getApp() {
		return app;
	}
	public void setApp(List<ResultReport> app) {
		this.app = app;
	}
	public void listOfAllAppSpontaneousBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.spontaneousApp =  reportsFacade.listOfAllAppSpontaneousBetweenDates(startDate, endDate);
	}
	
	public void listOfAllAppBetweenDates (){
		System.out.println("entre na função que vai buscar hashMap");
		this.app =  reportsFacade.listOfAllAppBetweenDates(startDate, endDate);
	}
	
	

}
