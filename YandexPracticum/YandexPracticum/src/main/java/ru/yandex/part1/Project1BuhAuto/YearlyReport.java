package ru.yandex.part1.Project1BuhAuto;

import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, YearData> data = new HashMap<>();

    public double getAverageIncome() {
        double total = 0;
        int count = 0;
        for (YearData yearData : data.values()) {
            total += yearData.income;
            count++;
        }
        return count > 0 ? total / count : 0;
    }

    public double getAverageExpense() {
        double total = 0;
        int count = 0;
        for (YearData yearData : data.values()) {
            total += yearData.expense;
            count++;
        }
        return count > 0 ? total / count : 0;
    }
}
