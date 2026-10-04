interface Notifier {
    void send(String message);
}

// Marker interface
interface Urgent {
}

class UrgentNotifier implements Notifier, Urgent {
    private Notifier notifier;

    UrgentNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

public class Notification_sender {
    public static void main(String[] args) {

        // Lambdas
        Notifier email = (msg) ->
            System.out.println("Email: " + msg);

        Notifier sms = (msg) ->
            System.out.println("SMS: " + msg);

        // Mark email as urgent
        Notifier urgentEmail = new UrgentNotifier(email);

        // Array
        Notifier[] senders = {urgentEmail, sms};

        String message = "Important college notice";

        // Broadcast
        for (Notifier sender : senders) {

            sender.send(message);

            // If sender is urgent, send again
            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}