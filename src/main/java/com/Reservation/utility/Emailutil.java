package com.Reservation.utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Emailutil {
	
	@Autowired
	JavaMailSender sender;
	
	public void sendItineary(String toAddress, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper (message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary of flight");
			messageHelper.setText("Please find te attachment");
			messageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		}catch (MessagingException e) {
			e.printStackTrace();
		}
		

}
}