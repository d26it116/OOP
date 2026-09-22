class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

class MyThread extends Thread {
    Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class Counter_Race {
    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);
        Thread t3 = new MyThread(counter);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Counter = " + counter.count);
        System.out.println("Expected Counter = " + (3 * 10000));
    }
}