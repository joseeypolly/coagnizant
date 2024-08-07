import java.util.Random;

public class Producer implements Runnable {
    private final DataQueue dataQueue;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int data = random.nextInt(100);
                dataQueue.produce(data);
                Thread.sleep(random.nextInt(1000)); // Simulate time taken to produce data
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
