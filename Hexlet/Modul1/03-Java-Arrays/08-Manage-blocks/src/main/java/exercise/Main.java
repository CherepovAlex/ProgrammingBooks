//Реализуйте публичный статический метод getTotalAmount(), который принимает на вход кошелёк с деньгами в виде
//массива строк и название валюты. Метод должен возвращать сумму денег указанной валюты.
//Параметры метода:
//Массив строк, содержащий купюры разных валют с различными номиналами. Каждая купюра в массиве представлена строкой,
// в которой первые три символа - это название валюты, а затем через пробел указан номинал купюры.
// Например, eur 10, usd 5
//Наименование валюты (строка из 3-х символов)
//Реализуйте данный метод используя управляющие инструкции.
//Подсказки
//Для преобразования строки в целое число используйте метод parseInt() класса Integer.
//Для извлечения подстроки из строки используйте метод substring(). Посмотрите, как он работает
package exercise;

public class Main {
    // BEGIN
    public static int getTotalAmount(String[] banknotes, String currency) {
        var sum = 0;
        for (var bill : banknotes) {
            var currentCurrency = bill.substring(0, 3);
            if (!currentCurrency.equals(currency)) {
                continue;
            }
            var denomination = Integer.parseInt(bill.substring(4));
            sum += denomination;
        }
        return sum;
    }
    // END
    public static void main(String[] args) {
        String[] banknotes1 = {"eur 10", "usd 1", "usd 10", "rub 50", "usd 5"};
        System.out.println(Main.getTotalAmount(banknotes1, "usd")); // 16
        String[] banknotes2 = {"eur 10", "usd 1", "eur 5", "rub 100", "eur 20", "eur 100", "rub 200"};
        System.out.println(Main.getTotalAmount(banknotes2, "eur")); // 135
        String[] banknotes3 = {"eur 10", "rub 50", "eur 5", "rub 10", "rub 10", "eur 100", "rub 200"};
        System.out.println(Main.getTotalAmount(banknotes3, "rub")); // 270
    }
}