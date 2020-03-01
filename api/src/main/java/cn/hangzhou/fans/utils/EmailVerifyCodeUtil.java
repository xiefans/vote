package cn.hangzhou.fans.utils;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailVerifyCodeUtil {
    public static String generateCode() {
        return String.valueOf((int) Math.random() / 9999);
    }

    public static void sendCode(String code, String toEmail) throws EmailVerifyCodeFailException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.163.com");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fansooxx@163.com", "ooxx1117");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("fansooxx@163.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("小油龙投票");
            message.setContent(code, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new EmailVerifyCodeFailException();
        }
    }
}
