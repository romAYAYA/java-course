package polimorf.mail;

public interface MailClient {
    void send(String from, String to, String text);
    void recieve();
}
