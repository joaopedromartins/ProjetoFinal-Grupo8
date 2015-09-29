package pt.uc.dei.aor.g8.jobapp.business.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.Days;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.service.INotificationFacade;

@Singleton
public class PeriodicTiming {

	@EJB
	private IPositionPersistenceService positionService;
	@EJB
	private INotificationFacade notification;
	@Inject
	private GmailMessage mail;



	@PostConstruct
	@Schedule(hour="7", minute="30", second="*", persistent=false)
	public void run() {
		List<IPositionProxy> position = positionService.listOfAllOpenPosition();
		Date past;
		int days;
		for(IPositionProxy p: position){
			past=p.getSLA();
			days = Days.daysBetween(new DateTime(past), new DateTime()).getDays();
			if(days < 2){
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				notification.createNotification("SLA deadline is close", "The SLA of position, " 
						+ p.getTitle()+ "( " +p.getCode()+ " ), are " +dateFormat.format(p.getSLA())+
						".\n The Manager of this position are " + p.getManagerPosition().getFullName()+".",
						"", p.getAdminPosition());
				mail.sendEmail(p.getAdminPosition().getEmail(), "jobappmailtest@gmail.com", "SLA deadline is close", "The SLA of position, " 
						+ p.getTitle()+ "( " +p.getCode()+ " ), are " +dateFormat.format(p.getSLA())+
						".\n The Manager of this position are " + p.getManagerPosition().getFullName()+".");
			}
		}
	}


}
