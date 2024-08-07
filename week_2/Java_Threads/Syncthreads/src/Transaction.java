public class Transaction implements Runnable {
    private final BankAccount account;
    private final int amount;
    private final boolean isDeposit;

    public Transaction(BankAccount account, int amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
