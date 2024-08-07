public class ThreadStateLogger {

    public static void main(String[] args) {
        // Create an instance of the custom thread
        CustomThread thread = new CustomThread();
        
        // Log the state of the thread before starting
        System.out.println("State before starting: " + thread.getState());

        // Start the thread
        thread.start();

        // Log the state of the thread after starting
        System.out.println("State after starting: " + thread.getState());

        // Wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Log the state of the thread after completion
        System.out.println("State after completion: " + thread.getState());
    }

    // Define a custom thread class
    static class CustomThread extends Thread {
        @Override
        public void run() {
            // Log the state of the thread during execution
            System.out.println("State during execution: " + this.getState());

            // Perform a simple task (e.g., printing numbers)
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
                try {
                    // Sleep for a short time to simulate work
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
