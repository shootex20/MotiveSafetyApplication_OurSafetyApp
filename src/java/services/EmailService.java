package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmailService {
    
    public EmailService(){
    
    }
    
    // Send a template email
    public void sendMail(String to, String subject, String template, HashMap<String, String> tags) throws Exception {
        // {{firstname}} -> Anne
        // {{date}} -> Oct. 28
        String body = "";
        try {
            // read whole template into a single variable (body)
            BufferedReader br = new BufferedReader(new FileReader(new File(template)));

            String line = br.readLine();
            while (line != null) {
                body += line;
                line = br.readLine();
            }

            // replace all {{variable}} with the actual values
            for (String key : tags.keySet()) {
                body = body.replace("{{" + key + "}}", tags.get(key));
            }

        } catch (Exception e) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, e);
        }

        sendMail(to, subject, body, true);
    }

    // Send a simple email
    public void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException, NamingException {
        Context env = (Context) new InitialContext().lookup("java:comp/env");
        String username = (String) env.lookup("webmail-username");
        String password = (String) env.lookup("webmail-password");

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);

        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // address the message
        Address fromAddress = new InternetAddress(username);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // send the message
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    
    public void sendMailWithAttachments(String to, String subject, String body, String filePath, boolean bodyIsHTML) throws MessagingException, NamingException {
        Context env = (Context) new InitialContext().lookup("java:comp/env");
        String username = (String) env.lookup("webmail-username");
        String password = (String) env.lookup("webmail-password");

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);

        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        
                //3) create MimeBodyPart object and set your message text     
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("Hi there, please view the attached file to learn what you should know during the work.");  

        //4) create new MimeBodyPart object and set DataHandler object to this object      
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

        DataSource source = new FileDataSource(filePath);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filePath);  

         //5) create Multipart object and add MimeBodyPart objects to this object      
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
        
        
         message.setContent(multipart );  
        
        
        
        
        // address the message
        Address fromAddress = new InternetAddress(username);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);


        // send the message
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();    
    }
}