// Реализуйте публичный статический метод calcShipsCount(), который принимает на вход поле боя в виде квадратного
// двумерного массива целых чисел из нулей и единиц. Ноль — пустая ячейка, единица — часть корабля.
// Функция должна вернуть количество кораблей на поле боя.
//Так как корабли не должны соприкасаться друг с другом, реализуйте метод isValidField(), который проверяет расстановку
// кораблей на корректность.
package exercise;

public class Main {

    // BEGIN
    public static int calcShipsCount(int[][] battleField) {
        var shipsCount = 0;
        var fieldSize = battleField.length;
        // - Текущая клетка должна быть частью корабля (battleField[row][col] == 1).
        //- И либо эта клетка находится в первом столбце (col == 0), либо клетка слева пуста (battleField[row][col-1] == 0).
        //Это условие гарантирует, что мы находимся в начале горизонтального корабля (или одиночную клетку).
        //- И при этом, либо эта клетка находится в первой строке (row == 0), либо клетка выше пуста (battleField[row-1][col] == 0).
        //Это условие гарантирует, что мы не являемся частью корабля, идущего сверху вниз (т.е. мы самая верхняя клетка вертикального корабля).
        for (var row = 0; row < fieldSize; row++) {
            for (var col = 0; col < fieldSize; col++) {
                if (battleField[row][col] == 1 && (col == 0 || battleField[row][col - 1] == 0)) {
                    if (row == 0 || battleField[row - 1][col] == 0) {
                        shipsCount++;
                    }
                }
            }
        }

        return shipsCount;
    }

    public static boolean isValidField(int[][] battleField) {
        var fieldSize = battleField.length;
        // - Для каждой клетки, которая является частью корабля (battleField[row][col] == 1), мы проверяем две диагональные клетки сверху:
        //- Если мы не в последнем столбце (col < fieldSize-1), то смотрим на клетку сверху-справа (row-1, col+1):
        //если там 1, то возвращаем false (корабли касаются диагонально).
        //- Если мы не в первом столбце (col != 0), то смотрим на клетку сверху-слева (row-1, col-1):
        //если там 1, то возвращаем false.
        for (var col = 0; col < fieldSize; col++) {
            for (var row = 1; row < fieldSize; row++) {
                if (battleField[row][col] == 1) {
                    if (col < fieldSize - 1 && battleField[row - 1][col + 1] == 1
                            || (col != 0 && battleField[row - 1][col - 1] == 1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    // END

    public static void main(String[] args) {
        int[][] battleField1 = {
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0, 0},
        };
        System.out.println(Main.calcShipsCount(battleField1)); // 6

        int[][] battleField2 = {
                {0, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
        };

        System.out.println(Main.isValidField(battleField2)); // false

        int[][] battleField3 = {};

        System.out.println(Main.isValidField(battleField3)); // true
    }
}