package Glava2;

public class Example1 {

    public static void main(String[] args) {

        int[] intArray; // определение ссылки на массив
        intArray = new int[100]; // создание массива и сохранение ссылки на него в intArray

        int[] intAray1 = new int[100];   // эквивалентная объединённая конструкция

        int intAray2[] = new int[100];   // альтернативный синтаксис

        int arrayLength = intArray.length;  // определение размера массива

        int temp = intArray[3]; // получение содержимого четвертого элемента массива

        intArray[7] = 66;   // вставка значения 66 в восьмую ячейку

        autoData[] carArray = new autoData[4000];

        int[] intArray3 = {0, 3, 6, 9, 12, 15, 18, 21, 24, 27}; // инициализация массива
    }

}

class autoData{}
