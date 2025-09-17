package exercise.Consultation12G_25_09_11;

public class Task5 {
    // Задание 3 Создание собственного исключения
    private double balance;

    public void withdrawUnchecked(double amount) {
        if (amount > balance) {
            throw new NegativeBalanceException("Not enough money. Balance: " + balance);
        }
        balance -= amount;
    }

    public void withdrawChecked(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Request more than balance on " + (amount - balance));
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        Task5 account = new Task5();
        account.balance = 500;

        // Для unchecked исключения - обработка опциональна, но хорошая практика
        try {
            account.withdrawUnchecked(600);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } catch (NegativeBalanceException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        // Для checked исключения - обработка обязательна
        try {
            account.withdrawChecked(600);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}

// собственное непроверяемое исключение (unchecked)
class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

// собственное проверяемое исключение (checked)
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}