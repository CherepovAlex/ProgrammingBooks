package ru.yandex.part1.Project1BuhAuto;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    HashMap<Integer, ArrayList<MonthData>> data = new HashMap<>();

    public void addMonth(int month, ArrayList<MonthData> monthData){
        data.put(month, monthData);
    }

    public double getTotalIncome(int month) {
        ArrayList<MonthData> monthData = data.get(month);
        if (monthData == null) return 0;

        double income = 0;
        for (MonthData item : monthData) {
            if (!item.is_expense) {
                income += item.price * item.count;
            }
        }
        return income;
    }

    public double getTotalExpense(int month) {
        ArrayList<MonthData> monthData = data.get(month);
        if (monthData == null) return 0;

        double expense = 0;
        for (MonthData item: monthData) {
            if (item.is_expense) {
                expense += item.price * item.count;
            }
        }
        return expense;
    }

    public MonthData getMostProfitableItem(int month) {
        ArrayList<MonthData> monthData = data.get(month);
        if (monthData == null) return null;

        MonthData mostProfitable = null;
        double maxProfit = 0;

        for (MonthData item : monthData) {
            if (!item.is_expense) {
                double profit = item.price * item.count;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    mostProfitable = item;
                }
            }
        }
        return mostProfitable;
    }

    public MonthData getBiggestExpense(int month) {
        ArrayList<MonthData> monthData = data.get(month);
        if (monthData == null) return null;

        MonthData biggestExpense = null;
        double maxExpense = 0;

        for (MonthData item : monthData) {
            if (item.is_expense) {
                double expense = item.price * item.count;
                if (expense > maxExpense) {
                    maxExpense = expense;
                    biggestExpense = item;
                }
            }
        }
        return biggestExpense;
    }
}
