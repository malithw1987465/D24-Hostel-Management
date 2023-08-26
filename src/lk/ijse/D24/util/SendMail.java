package lk.ijse.D24.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    public static void outMail(String msg, String to, String subject) throws MessagingException, MessagingException {


        String from = "malithjayasundara2002@gmail.com";
        String host = "localhost";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("malithjayasundara2002@gmail.com", "yaehycadvqpuvasw");  // have to change some settings in SMTP
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress (from));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(msg);
        Transport.send(mimeMessage);

        System.out.println("Sent... " + to);
    }

    public static void outMail(String msg, ArrayList<String> to, String subject) throws MessagingException, MessagingException {
        for (String ele : to) {
            outMail(msg, ele, subject);
        }
    }

}
