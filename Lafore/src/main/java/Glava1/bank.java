package Glava1;

public class bank {
}

class BankAccount {
    private double balance; // баланс счёта

    public BankAccount(double openingBalance) { // Конструктор
        balance = openingBalance;
    }

    public void deposit(double amount) {    // внесение средств
        balance = balance + amount;
    }

    public void withdraw(double amount) {   // снятие средств
        balance = balance - amount;
    }

    public void display() {     // вывод баланса
        System.out.println("balance=" + balance);
    }

    void method1() {
        BankAccount ba1 = new BankAccount(350.00);
        method2(ba1);
    }

    void method2(BankAccount acct) {
        // ссылки ba1 и acct относятся к одному объекту
    }
}

class carPart{
    String name;

    public carPart(String name) {
        this.name = name;
    }
}

class BankApp {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(100.00);  // создание счета

        System.out.print("Before transactions, ");
        ba1.display();      // вывод баланса

        ba1.deposit(74.35);     // внесение средств
        ba1.withdraw(20.00);    // снятие средств

        System.out.print("After transactions, ");
        ba1.display();      // вывод баланса

        int intVar1 = 27;
        int intVar2 = intVar1;

        if (intVar1 == intVar2) {
            System.out.println("They're equal");
        }

        carPart cp1 = new carPart("fender");
        carPart cp2 = cp1;
        if (cp1 == cp2) System.out.println("They're Identical");
        if(cp1.equals(cp2)) System.out.println("They're equal");
    }
}

