// 2. A class that throws it
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        // In a case where the amount to be withdrawn is greater than the balance, the method throws an InsufficientFundsException 
        // with the amount that is short. This allows me (the caller) to catch the exception and handle it appropriately, such as notifying the user of insufficient funds.
    }
}
