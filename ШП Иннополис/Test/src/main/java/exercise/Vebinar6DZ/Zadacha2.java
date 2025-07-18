package exercise.Vebinar6DZ;

import java.util.Random;

public class Zadacha2 {

    private static final String[] KMN = {"KAMEN", "NOGNICY", "BUMAGA"};

    public static void main(String[] args) {
        Random random = new Random();

        var vChoice = random.nextInt(KMN.length);
        var pChoice = random.nextInt(KMN.length);

        System.out.println("U Vasya: " + KMN[vChoice] + ", U Petya: " + KMN[pChoice]);
        System.out.println(decideWinner(vChoice, pChoice));

    }

    public static String decideWinner(int vChoice, int pChoice) {
        if (vChoice == pChoice) {
            return "Ничья";
        } else if ((vChoice == 0 && pChoice == 1)
                || (vChoice == 1 && pChoice == 2)
                || (vChoice == 2 && pChoice == 0)) {
            return "Вася победил";
        } else {
            return "Петя победил";
        }
    }
}
