package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class R10_THI01_J {

    class HandleRequest implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is processing.");
            try {
                Thread.sleep(1000); // Simulates processing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Proper interrupt handling
            }
            System.out.println(Thread.currentThread().getName() + " has finished.");
        }
    }

    class NetworkHandler {
        private final ExecutorService executor = Executors.newFixedThreadPool(3);

        void processRequests(int numberOfRequests) {
            for (int i = 0; i < numberOfRequests; i++) {
                executor.execute(new HandleRequest());
            }
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }

    public static void main(String[] args) {
        new R10_THI01_J().new NetworkHandler().processRequests(3);
    }
}
