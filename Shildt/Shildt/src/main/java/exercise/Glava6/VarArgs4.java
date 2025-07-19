package exercise.Glava6;

// Перегрузка метода с аргументами переменной длины
// и неоднозначность выбора метода.
//
// В этой программе имеется ошибка, и
// поэтому она не будет компилироваться
class VarArgs4 {
    // Использование аргумента переменной длины типа int
    static void vaTest(int ... v) {
        // ...
    }

    // Использование аргумента переменной длины типа boolean
    static void vaTest(boolean ... v) {
        // ...
    }

    public static void main(String args[])
    {
        vaTest(1, 2, 3); // OK
        vaTest(true, false, false); // OK

//        vaTest(); // Ошибка вследствие неоднозначности!
    }
}