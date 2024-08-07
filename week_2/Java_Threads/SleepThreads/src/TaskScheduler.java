public class TaskScheduler {

    public static void main(String[] args) {
        // Create task threads
        Task task1 = new Task("Task 1", 1000);
        Task task2 = new Task("Task 2", 2000);
        Task task3 = new Task("Task 3", 3000);

        // Start task threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for task threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks have completed.");
    }

    // Define a thread class named Task
    static class Task implements Runnable {
        private final String taskName;
        private final int duration;

        public Task(String taskName, int duration) {
            this.taskName = taskName;
            this.duration = duration;
        }

        @Override
        public void run() {
            // Perform a sequence of operations
            System.out.println(taskName + " started.");

            // Simulate task operation with sleep
            try {
                System.out.println(taskName + " sleeping for " + duration + "ms.");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Simulate yielding to allow other tasks to execute
            System.out.println(taskName + " yielding.");
            Thread.yield();

            // Simulate waiting for a dependent task (if applicable)
            // For this example, we'll just print a message
            System.out.println(taskName + " waiting for dependent task.");
            // In a real scenario, you might use join() to wait for another thread.

            System.out.println(taskName + " resumed and completed.");
        }
    }
}
