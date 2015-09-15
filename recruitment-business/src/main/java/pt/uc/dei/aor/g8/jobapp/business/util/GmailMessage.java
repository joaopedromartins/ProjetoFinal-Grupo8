package pt.uc.dei.aor.g8.jobapp.business.util;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Stateless
@LocalBean
public class GmailMessage {
	@Resource(mappedName="java:jboss/mail/Gmail")
	private Session gmailSession;

	/**
	 * Default constructor. 
	 */
	public GmailMessage() {
	}

	@Asynchronous
	public void sendEmail(String to, String from, String subject, String content) {

		//log.info("Sending Email from " + from + " to " + to + " : " + subject);

		try {

			Message message = new MimeMessage(gmailSession);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			//log.debug("Email was sent");

		} catch (MessagingException e) {
			//log.error("Error while sending email : " + e.getMessage());
		}
	}

}