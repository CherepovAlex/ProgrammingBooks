package exercise.Consultation10B_25_09_03;

public class Massive {
    public static void main(String[] args) {
        // Создаем массив целых чисел
        int[] numbers = new int[5];

        // Присваиваем значения элементам массива
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Проходим по каждому элементу массива и выводим его значение
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}