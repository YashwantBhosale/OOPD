abstract class Notification {
    String message;

    Notification(String m) {
        this.message = m;
    }

    abstract void notifyUser();
}

class SMSNotification extends Notification {
    SMSNotification(String m) {
        super(m);
    }

    @Override
    public void notifyUser() {
        System.out.println("SMS Notification sent: " + message);
    }
}

class PushNotification extends Notification {
    PushNotification(String m) {
        super(m);
    }

    @Override
    public void notifyUser() {
        System.out.println("Push Notification sent: " + message);
    }
}

class EmailNotification extends Notification {
    EmailNotification(String m) {
        super(m);
    }

    @Override
    public void notifyUser() {
        System.out.println("Email Notification sent: " + message);
    }
}

class NotificationFactory {
    public Notification sendNotification(String type, String msg) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification(msg);
        } else if (type.equalsIgnoreCase("Push")) {
            return new PushNotification(msg);
        } else if (type.equalsIgnoreCase("Email")) {
            return new EmailNotification(msg);
        } else{
			System.err.println("Invalid notification type!");
			return null;
		}
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification notif1 = factory.sendNotification("SMS", "Your OTP is 123456");
        notif1.notifyUser();

        Notification notif2 = factory.sendNotification("Push", "New message received");
        notif2.notifyUser();

        Notification notif3 = factory.sendNotification("Email", "Welcome to our service!");
        notif3.notifyUser();
    }
}

