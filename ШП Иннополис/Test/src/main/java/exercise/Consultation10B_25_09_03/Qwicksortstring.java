package exercise.Consultation10B_25_09_03;

public class Qwicksortstring {
    public static void main(String[] args) {
        String[] strings = {"apple", "orange", "banana", "grape", "kiwi"};

        // Применяем быструю сортировку
        quickSort(strings, 0, strings.length - 1);

        // Выводим отсортированный массив
        System.out.println("Отсортированный массив:");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }

    // Основной метод быстрой сортировки
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            // Разделяем массив на две части
            int pi = partition(arr, low, high);

            // Сортировка левой части
            quickSort(arr, low, pi - 1);

            // Сортировка правой части
            quickSort(arr, pi + 1, high);
        }
    }

    // Метод для разделения массива (Partition)
    private static int partition(String[] arr, int low, int high) {
        // Выбираем последний элемент в качестве опорного
        String pivot = arr[high];
        int i = low - 1; // Точка вставки меньших элементов

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j); // Меняем местами
            }
        }
        swap(arr, i + 1, high); // Ставим опорный элемент на место
        return i + 1; // Возвращаем индекс опорного элемента
    }

    // Вспомогательный метод для обмена элементов
    private static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}