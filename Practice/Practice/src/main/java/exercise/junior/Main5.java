package exercise.junior;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result;

        result = findEvenOddNumbers(data);

        System.out.println(result);
    }

    public static String findEvenOddNumbers(List<Integer> data) {
        var newDataEven = new ArrayList<Integer>();
        var newDataNotEven = new ArrayList<Integer>();
        String even = "(";
        String notEven = "";
        for (var num : data) {
            if (num % 2 == 0) {
                newDataEven.add(num);
            } else {
                newDataNotEven.add(num);
            }
        }
        Collections.sort(newDataEven);
        Collections.sort(newDataNotEven);

        return newDataEven.toString().replace('[', '(').replace(']', ')')
                + " " + newDataNotEven.toString().replace('[', '(').replace(']', ')') ;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}

//У вас есть переменная data, которая содержит входные пользовательские данные.
//
//data - список из элементов целых чисел.
//
//Напишите код, который будет находить четные и нечетные числа и записывать результат в виде строки:
//(четные) (нечетные) в переменную result.
//
//Важно! Четные и нечетные числа должны быть отсортированы в порядке возрастания.
//
//Sample Input:
//
//[4, 3, 7, 1, 8, 6, 5, 2]
//Sample Output:
//
//(2, 4, 6, 8) (1, 3, 5, 7)