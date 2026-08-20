# Custom Exception Handling in Java

A small Java project demonstrating how to create, throw, and catch a **custom exception**.

## Overview

This project shows the full lifecycle of a custom exception in Java:

1. **Define** a custom exception class by extending `Exception`
2. **Throw** it when a specific business rule is violated
3. **Catch** it using a `try`/`catch` block and handle it gracefully

The example models a simple bank account withdrawal, where attempting to withdraw more than the available balance triggers a custom `InsufficientFundsException`.

## Project Structure

```
.
├── InsufficientFundsException.java   # Custom exception class
├── BankAccount.java                  # Class that throws the exception
├── Main.java                         # Entry point that catches the exception
└── README.md
```

## How It Works

### 1. Custom Exception Class

`InsufficientFundsException` extends Java's built-in `Exception` class. It uses `super(message)` in its constructor to pass a custom error message up to the parent class, so it integrates properly with `getMessage()` and Java's default stack trace printing.

```java
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
```

### 2. Throwing the Exception

`BankAccount.withdraw()` checks whether the withdrawal amount exceeds the current balance, and throws the custom exception if it does.

```java
public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException(amount - balance);
    }
    balance -= amount;
}
```

### 3. Catching the Exception

`Main` wraps the withdrawal call in a `try`/`catch` block and handles the exception with a meaningful message.

```java
try {
    account.withdraw(150.0);
} catch (InsufficientFundsException e) {
    System.err.println("Caught custom exception: " + e.getMessage());
    System.err.println("Short by: $" + e.getAmount());
}
```

## Running the Project

1. Clone the repository
   ```
   git clone <repo-url>
   cd <repo-folder>
   ```
2. Compile the Java files
   ```
   javac *.java
   ```
3. Run the program
   ```
   java Main
   ```

### Expected Output

```
Caught custom exception: Insufficient funds: short by $50.0
Short by: $50.0
```

## Key Takeaways

- Custom exceptions should extend `Exception` (checked) or `RuntimeException` (unchecked), depending on whether callers should be forced to handle them.
- Calling `super(message)` in the constructor is the idiomatic way to set the exception's message, since it plugs into `Throwable`'s built-in message handling rather than reinventing it.
- A specific `catch` block (e.g. `catch (InsufficientFundsException e)`) only handles that exception type, keeping error handling precise instead of catching overly broad exceptions.

## Author
Hezekiah.


One funny thing i learnt is that every single thing we call an error because the code crashed or failed to run is actually not an Error some are 
Exceptions not an error but if this exception is caused by an external factor maybe a serious problems at the JVM/system level, then it is an error. 
If it caused by an internal factor maybe a logic error or signal a bug in your own logic then that is a runtime exception (Errors and Runtime Exceptions are both uncheck exceptions(the system wasn't expecting them))
Some are also Checked exceptions(The system was expecting it) for example User picks wrong file type, file not found, network failure, that throws a checked exceptions like FileNotFoundException or IOException