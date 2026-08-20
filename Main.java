// 3. Catch it
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);

        try {
            account.withdraw(150.0);
        } catch (InsufficientFundsException e) {
            System.err.println("Caught custom exception: " + e.getMessage());
            System.err.println("Short by: $" + e.getAmount());
        }
    }
}