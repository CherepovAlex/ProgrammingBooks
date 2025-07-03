package exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int hour = LocalDateTime.now().getHour();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        scanner.close();

        if (hour >= 5 && hour < 12) {
            System.out.print("Good Morning");
        } else if (hour >= 12 && hour <= 18) {
            System.out.print("Good Afternoon");
        } else if (hour >= 18 && hour <= 24) {
            System.out.print("Good Evening");
        } else if (hour >= 0 && hour <= 5) {
            System.out.print("Good Night");
        }
        System.out.println(", " + name);

        int[] array = {1, 1, 0, 1, 1, 1};
        int result = Array.maxRange(array);
        System.out.println("Maximum digits of 1: " + result);

        int[] nums = {3,2,2,3};

    }
}

class Array {
    public static int maxRange(int[] nums) {

        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else currentCount = 0;
        }
        return maxCount;
    }
}