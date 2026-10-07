class Buffer {
    int value;
    boolean available = false;

    synchronized void produce(int n) throws Exception {
        while (available)
            wait();

        value = n;
        available = true;

        System.out.println("Produced: " + n);
        notify();
    }

    synchronized void consume() throws Exception {
        while (!available)
            wait();

        System.out.println("Consumed: " + value);
        available = false;

        notify();
    }
}

public class Producer_consumer {
    public static void main(String[] args) {

        Buffer b = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++)
                    b.produce(i);
            } catch (Exception e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++)
                    b.consume();
            } catch (Exception e) {}
        });

        producer.start();
        consumer.start();
    }
}
    

