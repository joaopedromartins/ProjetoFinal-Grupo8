package pt.uc.dei.aor.g8.jobapp.reports;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.service.IReportsFacade;

@Named
@ViewScoped
public class PresentedProposals implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IReportsFacade reportsFacade;

}
