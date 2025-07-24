package exercise.top20sobes;

// Напишите программу на Java для переворачивания строки, изменив расположение символов в строке
// задом наперёд без использования встроенных в String функций.
public class z1 {

    public static void main(String[] args) {

        String st = "Задача1";

        StringBuilder stB = new StringBuilder();

        stB.append(st);

        stB = stB.reverse();       // используем StringBuilder для переворота строки

        System.out.println(stB);

    }

}
