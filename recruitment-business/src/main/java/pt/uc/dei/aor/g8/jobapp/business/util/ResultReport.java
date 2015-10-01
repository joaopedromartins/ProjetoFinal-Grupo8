package pt.uc.dei.aor.g8.jobapp.business.util;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class ResultReport {
	
	private Date date;
	private int quantity;
	private String string;
	
	public ResultReport() {
	}
	public ResultReport(Date date, int quantity) {
		this.date = date;
		this.quantity = quantity;
	}
	public ResultReport(String string, int quantity) {
		this.string = string;
		this.quantity = quantity;
	}
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	

}
