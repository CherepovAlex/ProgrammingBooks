package ru.yandex.part1.Project1BuhAuto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Praktikum {
    // хранилища для отчетов
    private MonthlyReport monthlyReport = new MonthlyReport();
    private YearlyReport yearlyReport = new YearlyReport();

    // флаги загрузки для проверки
    private boolean isMonthlyReportsLoaded = false;
    private boolean isYearlyReportLoaded = false;

    public static void main(String[] args) {
        Praktikum praktikum = new Praktikum(); // создаём экземпляр
        praktikum.run();    // запускаем основной цикл программы
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);   // создаём сканнер для чтения ввода

        while (true) { // запускаем бесконечный цикл
            printMenu();    // показываем меню

            int command = scanner.nextInt();    // читаем команду от пользователя

            switch (command) {  // обрабатываем команду
                case 1:
                    readAllMonthlyReports();    // загружаем месячные отчеты
                    break;
                case 2:
                    readYearlyReport();         // загружаем годовой отчет
                    break;
                case 3:
                    reconcileReports();         // сверяем отчеты
                    break;
                case 4:
                    printAllMonthlyReportsInfo();   // показываем инфо по месяцам
                    break;
                case 5:
                    printYearlyReportsInfo();       // показываем инфо по году
                    break;
                case 0:
                    System.out.println("Exit");
                    scanner.close();                // закрываем сканнер
                    return;                         // выходим из программы
                default:
                    System.out.println("Sorry, this command didn't exists yet");
            }
        }
    }

    // вывод меню в консоль
    private void printMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1 - Read all monthly reports");
        System.out.println("2 - Read yearly report");
        System.out.println("3 - Reconcile reports");
        System.out.println("4 - Print info about all months reports");
        System.out.println("5 - Print info about year report");
        System.out.println("0 - Exit");
    }

    // загрузка всех месячных отчетов
    private void readAllMonthlyReports() {
        String[] monthFiles = {"m.202101.csv", "m.202102.csv", "m.202103.csv"};

        // проходим по всем файлам месяцев
        for (int i = 0; i < monthFiles.length; i++) {
            // читаем содержимое файла
            String content = readFileContentOrNull("data/" + monthFiles[i]);
            if (content != null) {
                // парсим CSV в объекты MonthData
                ArrayList<MonthData> monthData = parseMonthlyFileContents(content);
                // Добавляем в отчет (месяц = i + 1, так как месяцы с 1
                monthlyReport.addMonth(i + 1, monthData);
                System.out.println("Month report " + (i + 1) + " load successfully");
            } else {
                System.out.println("Error load file: " + monthFiles[i]);
            }
        }
        isMonthlyReportsLoaded = true; // Устанавливаем флаг загрузки
    }

    // загрузка годового отчета
    private void readYearlyReport() {
        String content = readFileContentOrNull("data/y.2021.csv");
        if (content != null) {
            // парсим годовой отчет
            yearlyReport = parseYearlyFileContents(content);
            isYearlyReportLoaded = true;    // Устанавливаем флаг
            System.out.println("Yearly report loaded successfully");
        } else {
            System.out.println("Error load yearly report");
        }
    }

    // Сверка отчетов - поиск расхождений
    private void reconcileReports() {
        // Проверяем, что оба отчета загружены
        if (!isMonthlyReportsLoaded || !isYearlyReportLoaded) {
            System.out.println("All reports didn't loaded! First of all load months and year reports");
            return;
        }

        boolean hasErrors = false;

        for (int month = 1; month <= 3; month++) {
            ArrayList<MonthData> monthData = monthlyReport.data.get(month);
            if (monthData == null || monthData.isEmpty()) {
                System.out.println("Report had no data for month " + month);
                hasErrors = true;
                continue;
            }

            // получаем суммы из месячного отчета
            double monthIncome = monthlyReport.getTotalIncome(month);
            double monthExpense = monthlyReport.getTotalExpense(month);

            // получаем данные из годового отчета
            YearData yearData = yearlyReport.data.get(month);
            if (yearData == null) {
                System.out.println("Yearly report hadn't data for month " + month);
                hasErrors = true;
                continue;
            }

            // сравниваем доходы (с учетом погрешности double)
            if (Math.abs(monthIncome - yearData.income) > 0.01) {
                System.out.println("Find error in income for month " + month);
                System.out.println(" In monthly report: " + monthIncome);
                System.out.println(" In yearly report: " + yearData.income);
                hasErrors = true;
            }

            // сравниваем расходы
            if (Math.abs(monthExpense - yearData.expense) > 0.01) {
                System.out.println("Find error in expense for month " + month);
                System.out.println(" In monthly report: " + monthExpense);
                System.out.println(" In yearly report: " + yearData.expense);
                hasErrors = true;
            }
        }

        if (!hasErrors) {
            System.out.println("Reconcile report completed successfully. Errors didn't find");
        }
    }

    // вывод информации по месячным отчетам
    private void printAllMonthlyReportsInfo() {
        if (!isMonthlyReportsLoaded) {
            System.out.println("Months reports is not loaded");
            return;
        }

        for (int month = 0; month <= 3; month++) {
            ArrayList<MonthData> monthData = monthlyReport.data.get(month);
            if (monthData == null || monthData.isEmpty()) {
                System.out.println("There are no data for month " + month);
                continue;
            }

            System.out.println("\nReport for month " + getMonthName(month) + ":");

            // Самый прибыльный товар
            MonthData mostProfitable = monthlyReport.getMostProfitableItem(month);
            if (mostProfitable != null) {
                double profit = mostProfitable.price * mostProfitable.count;
                System.out.println("The most profitable item: " + mostProfitable.name_item + "(" + profit + ")");
            }

            // Самая большая трата
            MonthData biggestExpense = monthlyReport.getBiggestExpense(month);
            if (biggestExpense != null) {
                double expense = biggestExpense.price * biggestExpense.count;
                System.out.println("The most biggest expense: " + biggestExpense.name_item + "(" + expense + ")");
            }
        }
    }

    // вывод информации по годовому отчету
    private void printYearlyReportsInfo() {
        if (!isYearlyReportLoaded) {
            System.out.println("Yearly report didn't load!");
            return;
        }

        System.out.println("\nYearly report 2021:");

        // Выводим прибыль по месяцам
        for (int month = 1; month <= 12; month++) {
            YearData data = yearlyReport.data.get(month);
            if (data != null) {
                double profit = data.income - data.expense;
                System.out.println("Profit for " + getMonthName(month) + ": " + profit);
            }
        }

        // Средние значения
        System.out.println("\nAverage expense for all months: " + yearlyReport.getAverageExpense());
        System.out.println("Average income for all months: " + yearlyReport.getAverageIncome());
    }

    // получение названия месяца по номеру
    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};
        return monthNames[month - 1];
    }

    // Чтение файла в строку
    private static String readFileContentOrNull(String path) {
        try {  //  пытается прочитать весь файл в строку
            return Files.readString(Path.of(path)); // создает объект Path из строки пути
        } catch (IOException e) {
            System.out.println("Impossible to read!");
            return null; // возврат null при ошибке
        }
    }

    // Парсинг месячного отчета из CSV
    private static ArrayList<MonthData> parseMonthlyFileContents(String content) {
        if (content == null) return new ArrayList<>();  // защита от null

        String[] strings = content.split("\\n");    // разделяем на строки
        ArrayList<MonthData> monthData = new ArrayList<>();

        // начинаем с 1, чтобы пропустить заголовок
        for (int i = 1; i < strings.length; i++) {
            String[] line = strings[i].split(",");  // Разделяем строку на колонки
            if (line.length >= 4) {
                // Создаём объект MonthData из данных строки
                monthData.add(new MonthData(
                        line[0].trim(), // Название товара
                        Boolean.parseBoolean(line[1].trim()),   // Является ли тратой
                        Float.parseFloat(line[2].trim()),       // Цена
                        Integer.parseInt(line[3].trim())        // Количество
                ));
            }
        }
        return monthData;
    }

    // парсинг годового отчета из CSV
    private static YearlyReport parseYearlyFileContents(String content) {
        YearlyReport yearlyReport = new YearlyReport();
        if (content == null) return yearlyReport;

        String[] strings = content.split("\\n");
        for (int i = 1; i < strings.length; i++) {  // пропускаем заголовок
            String[] line = strings[i].split(",");
            if (line.length >= 3) {
                int month = Integer.parseInt(line[0].trim());
                double amount = Double.parseDouble(line[1].trim());
                boolean isExpense = Boolean.parseBoolean(line[2].trim());

                // получаем или создаём данные за месяц
                YearData yearData = yearlyReport.data.getOrDefault(month, new YearData());
                if (isExpense) {
                    yearData.expense = amount;  // записываем расход
                } else {
                    yearData.income = amount;   // записываем доход
                }
                yearlyReport.data.put(month, yearData);
            }
        }
        return yearlyReport;
    }
}
