package ru.yandex.part1.Project1BuhAuto;

public class MonthData {
    String name_item;
    boolean is_expense;
    float price;
    int count;

    public MonthData(String name_item, boolean is_expense, float price, int count) {
        this.name_item = name_item;
        this.is_expense = is_expense;
        this.price = price;
        this.count = count;
    }
}
