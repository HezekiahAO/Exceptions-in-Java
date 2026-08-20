// 1. Create the custom exception — extend Exception (checked) 
// or RuntimeException (unchecked)
class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        super("Insufficient funds: short by $" + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}


// This is needed when
// Do you need an exception type that isn't represented by those in the Java platform?
// Would it help users if they could differentiate your exceptions from those thrown by classes written by other vendors?
// Does your code throw more than one related exception?
// If you use someone else's exceptions, will users have access to those exceptions? A similar question is, should your package be independent and self-contained?
