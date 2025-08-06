package com.aameen.email_sending;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App 
{
    public static void main( String[] args )
    {
        String message = "Did you get the message ! , This message is from Email Project done in java using java mail";
        String subject = "Message Sending using java mail";
        String to = "aameen.se@gmail.com";
        String from = "shahzade888a@gmail.com";
        
        //sendEmail(message,subject,to,from);
        sendFile(message,subject,to,from);
    }

	private static void sendFile(String message, String subject, String to, String from) {
		// variables for host 
				String host ="smtp.gmail.com";
				
				// get system properties 
				Properties properties = System.getProperties();
				
				// important info
				//host set 
				
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				// get session object 
				 Session session = Session.getInstance(properties,new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return  new PasswordAuthentication("shahzade888a@gmail.com","qosj ozrk krzw ihsn");
					}
					});
				 
				 session.setDebug(true);
				 
				 // compose message 
				 
				 MimeMessage mimeMessage = new MimeMessage(session);
				 try {
				 mimeMessage.setFrom(from);
				 
				 mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				 
				 mimeMessage.setSubject(subject);
				 
				 
				 // sending the file 
				 
				String path ="C:\\Users\\AAMEEN\\Downloads\\pexels-photo-5007442.jpeg";
				 
				MimeMultipart mimeMulti = new MimeMultipart();
				
				// for text 
				
				MimeBodyPart mimeText = new MimeBodyPart();
				
				// for file 
				
				MimeBodyPart mimeFile = new MimeBodyPart();
				
				mimeText.setText(message);
				
				File file = new File(path);
				
				mimeFile.attachFile(file);
				
				
				mimeMulti.addBodyPart(mimeText);
				mimeMulti.addBodyPart(mimeFile);
				
				mimeMessage.setContent(mimeMulti);
				
				 Transport.send(mimeMessage);
				 System.out.println("Message sent successfully !");
				 
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
		
	}

	private static void sendEmail(String message, String subject, String to, String from) {
		
		// variables for host 
		String host ="smtp.gmail.com";
		
		// get system properties 
		Properties properties = System.getProperties();
		
		// important info
		//host set 
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		// get session object 
		 Session session = Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return  new PasswordAuthentication("shahzade888a@gmail.com","qosj ozrk krzw ihsn");
			}
			});
		 
		 session.setDebug(true);
		 
		 // compose message 
		 
		 MimeMessage mimeMessage = new MimeMessage(session);
		 try {
		 mimeMessage.setFrom(from);
		 
		 mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 
		 mimeMessage.setSubject(subject);
		 
		 mimeMessage.setText(message);
		 
		 Transport.send(mimeMessage);
		 System.out.println("Message sent successfully !");
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}
