package com.ps.component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;



@Component("emailSender")
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	//@Autowired
	//private VelocityEngine velocityEngine;

	/*public void sendEmail(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,
			final String type) {

		sendEmail(toEmailAddresses, fromEmailAddress, subject, null, type);

	}*/

	

/*	public void sendEmailWithAttachment(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,
			 final String body) {

		sendEmail(toEmailAddresses, fromEmailAddress, subject, body);

	}*/

	public void sendEmail(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,
			 final String body) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				message.setTo(new InternetAddress(toEmailAddresses));
			
				message.setFrom(new InternetAddress(fromEmailAddress));
				
				//message.setSubject(subject);
				message.setText(body);
				message.setSubject(subject);
				/*String body = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, type, "UTF-8", null);*/
				//message.setText(body, true);

				

				

			}

		};
		
		this.mailSender.send(preparator);
	}


	
}