import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public DataQueue(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method for adding data to the queue
    public synchronized void produce(int data) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Queue is full. Producer is waiting.");
            wait(); // Wait until there's space in the queue
        }
        queue.offer(data);
        System.out.println("Produced: " + data);
        notifyAll(); // Notify consumers that data is available
    }

    // Synchronized method for removing data from the queue
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer is waiting.");
            wait(); // Wait until data is available in the queue
        }
        int data = queue.poll();
        System.out.println("Consumed: " + data);
        notifyAll(); // Notify producers that space is available
        return data;
    }
}
