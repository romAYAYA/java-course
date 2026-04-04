package polimorf.mail;

public class Drone implements MailClient {
    @Override
    public void send(String from, String to, String text) {
        System.out.println("Дрон отправил к " + to + " от " + from + " с электронным посланием: " + text);
    }

    @Override
    public void recieve() {
        System.out.println("Дрон принес ответное сообщение");
    }
}
