public class Counter {
    private int count = 0;
    private final Object lock = new Object();  // Use a dedicated object for locking
 
    public void doSomething() {
        synchronized (lock) {
            count++;
            // Perform other thread-safe operations
        }
    }
}
