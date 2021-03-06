package Email;

import java.util.LinkedList;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    protected EmailMessage(String from,
                         LinkedList<String> to,
                         String subject,
                         String content,
                         String mimeType,
                         LinkedList<String> cc,
                         LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }

    public static class Builder {
        private String from;
        private LinkedList<String> to = new LinkedList<>();
        private String subject;
        private String content;

        public Builder addFrom(String from) {
            this.from = from;
            System.out.println(this.from);
            return this;
        }

        public Builder addTo(String to) {
            this.to.add(to);
            return this;
        }

        public Builder addSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder addContent(String content) {
            this.content = content;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(from, to, subject, content, "", new LinkedList<>(), new LinkedList<>());
        }

    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() {
        final String username = "informatyka.4b@gmail.com";
        final String password = "informatyka123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to.get(0)));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
