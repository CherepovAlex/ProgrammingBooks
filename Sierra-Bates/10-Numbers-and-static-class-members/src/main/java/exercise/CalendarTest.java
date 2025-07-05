package exercise;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();  // получаем объект
        cal.set(2004, 0, 7, 15, 40); // устанавливаем время
        long day1 = cal.getTimeInMillis();  // переводим в миллисекунды
        day1 += 1000 * 60 * 60; // добавляем много миллисекунд - устанавливаем эквивалент часа в миллисекундах
        cal.setTimeInMillis(day1);  //  обновляем время
        System.out.println("New time " + cal.get(cal.HOUR_OF_DAY));
        cal.add(cal.DATE, 35); // добавляем к дате 35 дней
        System.out.println("Add 35 days " + cal.getTime());
        cal.roll(cal.DATE, 35);  // прокручиваем дату на 35 дней без смены месяца
        System.out.println("Roll 35 days " + cal.getTime());
        cal.set(cal.DATE, 1);   // устанавливаем дату на 1 число
        System.out.println("Data in 1 " + cal.getTime());
    }
}
