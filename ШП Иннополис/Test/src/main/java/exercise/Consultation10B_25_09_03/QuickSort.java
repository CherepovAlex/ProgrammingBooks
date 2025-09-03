package exercise.Consultation10B_25_09_03;

/*

Задача №1: Сортировка оценок студентов
Представьте ситуацию, когда преподаватель хочет быстро отсортировать оценки учеников по возрастанию,
чтобы определить средние показатели успеваемости класса. Оценки: [85, 42, 90, 75, 60]
 */

//public static void quickSort(int[] arr, int low, int high) {
//    if (low < high) { // Условие выхода из рекурсии:если в подмассиве остался один элемент (low == high) или массив пуст (low > high), сортировка не требуется
//        int pi = partition(arr, low, high);
//        quickSort(arr, low, pi - 1); // Рекурсивно сортируем левую половину
//        quickSort(arr, pi + 1, high); // Рекурсивно сортируем правую половину
//    }
//}
//
//private static int partition(int[] arr, int low, int high) {
//    int pivot = arr[high];
//    int i = low - 1;
//
//    for (int j = low; j < high; j++) {
//        if (arr[j] <= pivot) {
//            i++;
//            swap(arr, i, j);
//        }
//    }
//
//    swap(arr, i+1, high);
//    return i + 1;
//}
//
//private static void swap(int[] arr, int a, int b) {
//    int temp = arr[a];
//    arr[a] = arr[b];
//    arr[b] = temp;
//}


public class QuickSort {
    public static void main(String[] args) {
        int[] grades = {85, 42, 90, 75, 60}; // Список оценок

        quickSort(grades, 0, grades.length - 1); // Применение быстрой сортировки

        System.out.print("Отсортированные оценки: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
    }

    // Главная процедура быстрой сортировки
    public static void quickSort(int[] arr, int low, int high) {
        // Условие выхода из рекурсии. Если в подмассиве остался один элемент (low == high)
        //                                                      или массив пуст (low > high), сортировка не требуется
        if (low < high) {
            // переупорядочивает массив и возвращает индекс (pi), на который встал опорный элемент.
            int pi = partition(arr, low, high); // Разделение массива на две части
            quickSort(arr, low, pi - 1);       // Сортировка левой части
            quickSort(arr, pi + 1, high);      // Сортировка правой части
        }
    }

    // Вспомогательная функция разделения массива
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Выбор последнего элемента в качестве опорного
        //  указывает на конец области элементов, которые меньше или равны опорному
        // Изначально эта область пуста, поэтому i устанавливается перед началом отрезка (low - 1).
        int i = low - 1;       // Начало отсчета

        // проходит по всем элементам отрезка от low до high-1 (то есть по всем, кроме опорного).
        for (int j = low; j < high; j++) { //
            if (arr[j] <= pivot) { // Если текущий элемент меньше или равен опорному - его нужно отправить в левую часть
                i++;              // Переход на следующий элемент //  Мы расширяем границу "левой" области.
                swap(arr, i, j);  // Обмен элементами: arr[j] и элемент на границе "левой" области (arr[i])
            }
        }
        // после прохода по всем элементам опорный элемент (arr[high]) меняется местами
        //              с первым элементом "правой" области (это элемент с индексом i+1)
        // Это ставит опорный элемент точно между "левой" (≤ pivot) и "правой" (> pivot) частями.
        swap(arr, i + 1, high);  // Последняя операция перестановки
        // Метод возвращает новый индекс опорного элемента.
        return i + 1;            // Новая позиция опорного элемента
    }

    // Метод обмена элементов массива
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}