public class BankAccountTest {
    public static void main(String[] args) {
        // Create a shared BankAccount instance
        BankAccount account = new BankAccount(1000);

        // Create and start multiple Transaction threads
        Thread t1 = new Thread(new Transaction(account, 500, true), "Thread 1");
        Thread t2 = new Thread(new Transaction(account, 200, false), "Thread 2");
        Thread t3 = new Thread(new Transaction(account, 700, false), "Thread 3");
        Thread t4 = new Thread(new Transaction(account, 300, true), "Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Ensure the main thread waits for all transaction threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final account balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
