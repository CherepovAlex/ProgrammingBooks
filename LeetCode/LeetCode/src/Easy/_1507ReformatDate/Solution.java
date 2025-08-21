package Easy._1507ReformatDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Дана строка date в виде Day Month Year, где:
//Day находится в множестве {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
//Month находится в множестве {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
//Year находится в диапазоне [1900, 2100].
//Преобразуйте строку с датой в формат YYYY-MM-DD, где:
//YYYY обозначает четырёхзначный год.
//MM обозначает двухзначный месяц.
//DD обозначает двухзначный день.
// Example 1:
//Input: date = "20th Oct 2052"
//Output: "2052-10-20"
//Example 2:
//Input: date = "6th Jun 1933"
//Output: "1933-06-06"
//Example 3:
//Input: date = "26th May 1960"
//Output: "1960-05-26"
public class Solution {
    public String reformatDate(String date) {
        //ищем год
        String year = date.substring(date.length() - 4);
        String result = year + "-";

        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        // ищем месяц
        String month = date.substring(date.length() - 8, date.length() - 5);

        List<String> list = new ArrayList<>(map.keySet());
        for (String str : list) {
            if (str.equals(month)) {
                result += map.get(str) + "-";
            }
        }

        // ищем день
        String[] words = date.split(" ");
        String day_th = words[0];
        String day = "";
        for (int i = 0; i < day_th.length(); i++) {
            if (Character.isDigit(day_th.charAt(i))) {
                day += Character.toString(day_th.charAt(i));
            }
        }
        if (day.length() == 1) {
            result += 0 + day;
        } else {
            if (day.length() == 2) {
                result += day;
            }
        }
        return result;
    }

    public String reformatDate1(String date) {
        // разбиваем строку на части
        String[] parts = date.split(" ");

        // извлекаем и форматируем день
        String dayPart = parts[0];
        StringBuilder dayBuilder = new StringBuilder();
        for (int i = 0; i < dayPart.length(); i++) {
            char c = dayPart.charAt(i);
            if (Character.isDigit(c)) {
                dayBuilder.append(c);
            } else {
                break;  // прекращаем при первом не-цифровом символе
            }
        }
        String day = dayBuilder.toString();
        if (day.length() == 1) {
            day = 0 + day;
        }

        // преобразуем месяц
        Map<String, String> monthMap = createMonthMap();
        String month = monthMap.get(parts[1]);

        // год уже в правильном масштабе
        String year = parts[2];

        return year + "-" + month + "-" + day;
    }

    private Map<String, String> createMonthMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        return map;
    }

    public static void main(String[] args) {
        String date = "20th Oct 2052";
        System.out.println(new Solution().reformatDate(date));
        String date1 = "20th Oct 2052";
        System.out.println(new Solution().reformatDate1(date1));
    }
}
