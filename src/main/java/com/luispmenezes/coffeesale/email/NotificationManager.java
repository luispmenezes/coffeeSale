package com.luispmenezes.coffeesale.email;

import com.luispmenezes.coffeesale.Main;
import com.luispmenezes.coffeesale.scrapper.GlobalConstants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NotificationManager {

    public static void sendMail(String subject, String body) throws IOException {
        Properties props = new Properties();
        InputStream inputStream = new FileInputStream(GlobalConstants.MAILER_PROPERTIES_PATH);
        props.load(inputStream);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Main.getProperty("bot.email.address"),Main.getProperty("bot.email.password"));
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("coffeesalebot@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("luismenezes92@gmail.com"));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
