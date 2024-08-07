import java.util.Random;

public class SensorSimulation {

    public static void main(String[] args) {
        // Number of sensors to simulate
        int numberOfSensors = 5;

        // Array to hold sensor threads
        Thread[] sensorThreads = new Thread[numberOfSensors];

        // Create and start sensor threads
        for (int i = 0; i < numberOfSensors; i++) {
            sensorThreads[i] = new Thread(new Sensor(i + 1));
            sensorThreads[i].start();
        }

        // Ensure the main thread waits for all sensor threads to complete
        for (Thread sensorThread : sensorThreads) {
            try {
                sensorThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // All sensor threads have completed
        System.out.println("All sensors have completed data collection.");
    }

    // Define a thread class named Sensor
    static class Sensor implements Runnable {
        private final int sensorId;
        private final Random random;

        public Sensor(int sensorId) {
            this.sensorId = sensorId;
            this.random = new Random();
        }

        @Override
        public void run() {
            // Simulate data collection by printing random data at regular intervals
            for (int i = 0; i < 5; i++) {
                int data = random.nextInt(100); // Generate random data
                System.out.println("Sensor " + sensorId + ": Collected data - " + data);
                try {
                    // Sleep for a short time to simulate data collection interval
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Sensor " + sensorId + ": Data collection complete.");
        }
    }
}
