package exercise.Glava2;
/*
Демонстрация работы блока кода.
Назовите этот файл BlockTest.java.
*/
public class BlockTest {
    public static void main(String[] args) {
        int x, y;
        y = 20;
        // цель этого цикла является блок
        for (x = 0; x < 10; x++) {
            System.out.println("Value x: " + x);
            System.out.println("Value y: " + y);
            y = y - 2;
        }
    }
}

//Значение х: О
//Значение у: 20
//Значение х: 1
//Значение у: 18
//Значение х: 2
//Значение у: 16
//Значение х: 3
//Значение у: 14
//Значение х: 4
//Значение у: 12
//Значение х: 5
//Значение у: 10
//Значение х: 6
//Значение у: 8
//Значение х: 7
//Значение у: 6
//Значение х: 8
//Значение у: 4
//Значение х: 9
//Значение у: 2