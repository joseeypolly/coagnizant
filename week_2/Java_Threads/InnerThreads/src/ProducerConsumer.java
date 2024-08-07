public class ProducerConsumer {
    public static void main(String[] args) {
        DataQueue dataQueue = new DataQueue(5); // Shared data queue with capacity 5

        // Create and start producer threads
        Thread producer1 = new Thread(new Producer(dataQueue), "Producer 1");
        Thread producer2 = new Thread(new Producer(dataQueue), "Producer 2");
        producer1.start();
        producer2.start();

        // Create and start consumer threads
        Thread consumer1 = new Thread(new Consumer(dataQueue), "Consumer 1");
        Thread consumer2 = new Thread(new Consumer(dataQueue), "Consumer 2");
        consumer1.start();
        consumer2.start();
    }
}
