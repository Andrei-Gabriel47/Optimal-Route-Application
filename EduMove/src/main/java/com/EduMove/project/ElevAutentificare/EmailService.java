package com.EduMove.project.ElevAutentificare;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Properties;

@Service
public class EmailService {
    public void sendEmail(String to, String subject, String body) {
        final String username = "Andrey_Gaby03@yahoo.com";
        final String password = "ctnsclpqwkdjprth";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "587");// Portul pentru TLS

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email trimis cu succes!");

        } catch (MessagingException e) {
            System.err.println("Eroare la trimiterea emailului: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}