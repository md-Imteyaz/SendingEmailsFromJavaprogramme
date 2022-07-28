package com.SendEmail;

import java.net.InterfaceAddress;
import java.util.Properties;

import javax.websocket.Session;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;

@SpringBootApplication
public class SendEmailInJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailInJavaApplication.class, args);
		String to = "imroj212@gmail.com";
		String from = "sonoo1987@gmail.com";
		String host = "localhost";

		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InterfaceAddress());
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Ping");
			message.setText("Hello, this is example of sending email  ");

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}
}
