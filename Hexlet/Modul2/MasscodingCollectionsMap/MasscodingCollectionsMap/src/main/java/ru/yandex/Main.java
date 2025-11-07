package ru.yandex;

import java.util.HashMap;
import java.util.Map;

// Метод принимает на вход одно число - размер монеты
// Всего монет: 1, 2, 5, 10
// Метод возвращает строку - название монеты
public class Main {
    public static void main(String[] args) {
        Coin coin = new Coin();
//        coin.increase();
//        coin.increase();
//        coin.increase();
//        System.out.println(coin.getMoney());
//
//        Coin coin2 = new Coin();
//        coin2.increase();
//        System.out.println(coin2.getMoney());

        System.out.println(coin.spell(10));  // 10 рублей
        System.out.println(coin.spell(5));  // 5 рублей
        System.out.println(coin.spell(1));  // 1 рубль
        System.out.println(coin.spell(2));  // 2 рубля
        System.out.println(coin.spell(13));  // 13 рубля

    }
}

class Coin {
    int money = 0;
    Map<Integer, String> map;

    public Coin() {
        this.map = Map.of(10, "rubley",
                5, "rubley",
                1, "rubl",
                2, "rublya");
    }

    public int getMoney() {
        return this.money;
    }

    public String spell(int num) {
        return num + " " + map.getOrDefault(num, "is wrong number");
    }

    public void increase() {

    }
}
