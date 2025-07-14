package exercise;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class BankAccount {

    private static double exchangeRate = 1.2;

    private long accountNumber;
    private String accountCurrency;
    private double balance;


    public void deposit(String currency, double amount) {
        var normalizedAmount = exchange(currency, amount);
        balance += normalizedAmount;
    }

    public void withdraw(String currency, double amount) {
        var normalizedAmount = exchange(currency, amount);

        if (balance - normalizedAmount >= 0) {
            balance -= normalizedAmount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    private double exchange(String currency, double amount) {
        double normalizedAmount;

        if (currency.equals(accountCurrency)) {
            normalizedAmount = amount;
        } else if (accountCurrency.equals("eur")) {
            normalizedAmount = amount / exchangeRate;
        } else {
            normalizedAmount = amount * exchangeRate;
        }

        return normalizedAmount;
    }
}
// END