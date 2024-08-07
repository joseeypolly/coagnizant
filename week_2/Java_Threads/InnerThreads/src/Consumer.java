import java.util.Random;

public class Consumer implements Runnable {
    private final DataQueue dataQueue;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int data = dataQueue.consume();
                // Process the data (simulated by a print statement)
                System.out.println("Processed data: " + data);
                Thread.sleep(random.nextInt(1000)); // Simulate time taken to process data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
