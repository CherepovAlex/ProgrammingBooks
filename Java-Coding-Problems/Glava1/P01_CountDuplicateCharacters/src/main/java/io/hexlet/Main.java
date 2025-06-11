package io.hexlet;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";
    // Unicode: \u04DC, Code Point: 1244
    // Unicode: \uD83D\uDC95, Code Point: 128149
    // \uD83C\uDFBC, Code Point: 127932
    // \uD83D\uDE0D, Code Point: 128525

    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");
        System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples: \n");

        System.out.println("HashMap based solution:");
        long startTimeV1 = System.nanoTime(); // Замер времени начала выполнения.
        Map<Character, Integer> duplicatesV1 = Strings.countDuplicateCharactersV1(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV1); // Вывод времени выполнения
        System.out.println(Arrays.toString(duplicatesV1.entrySet().toArray()));
        // or duplicatesV1.forEach( (k, v) -> System.out.print(k + "=" + v + ", "));

        System.out.println();

        System.out.println("Java 8, functional-style solution:");
        long startTimeV2 = System.nanoTime(); // Замер времени начала выполнения.
        Map<Character, Long> duplicatesV2 = Strings.countDuplicateCharactersV2(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV2); // Вывод времени выполнения
        System.out.println(Arrays.toString(duplicatesV2.entrySet().toArray()));
        // or: duplicatesV2.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));
        System.out.println("\n--------------------------------------\n");

        System.out.println("Input text: \n" + TEXT_CP + "\n");
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

        System.out.println("HashMap based solution:");
        long startTimeV3 = System.nanoTime();
        Map<String, Integer> duplicatesV3 = Strings.countDuplicateCharactersVCP1(TEXT_CP);
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println(Arrays.toString(duplicatesV3.entrySet().toArray()));
        // or: duplicatesV3.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));

        System.out.println();

        System.out.println("Java 8, functional-style solution:");
        long startTimeV4 = System.nanoTime();
        Map<String, Long> duplicatesV4 = Strings.countDuplicateCharactersVCP2(TEXT_CP);
        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println(Arrays.toString(duplicatesV4.entrySet().toArray()));
        // or: duplicatesV3.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }


}