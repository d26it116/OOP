import java.util.concurrent.*;

public class Thread_pool {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int id = i;

            pool.submit(() -> {
                System.out.println("Task " + id + " is running");

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();

        try {
            pool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }
}