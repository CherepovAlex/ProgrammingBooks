package ru.yandex;
// Применение использования интерфейса
interface Notifier {
    void send(String message);
}

class EmailSender implements Notifier {
    @Override
    public void send(String message) {}
}

class SmsSender implements Notifier {
    @Override
    public void send(String message) {}
}

class Order{
    String number;
    String id(){
        return number = "number";
    }
}

// Композиция: поведение подменяемое стратегией
public class OrderService {
    private final Notifier notifier;
    OrderService(Notifier notifier) {
        this.notifier = notifier;
    }
    void placeOrder(Order o) {
        // инвариант: заказ валиден
        // предусловие: o != null
        notifier.send("Order placed: " + o.id());
        // постусловие: уведомление отправлено (проверяемо в тестах/логах)
    }
}
