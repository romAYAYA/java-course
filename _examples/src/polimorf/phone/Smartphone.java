package polimorf.phone;

public class Smartphone extends MobilePhone {
    private final String appName;

    public Smartphone(String number, String appName) {
        super(number);
        this.appName = appName;
    }

    @Override
    public void makeCall(String targetNumber) {
        System.out.println("Позвоним через приложение " + appName + " по номеру " + targetNumber);
        System.out.println("Привет!");
    }

    public final void sendEmail(String email, String messageText) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }
}