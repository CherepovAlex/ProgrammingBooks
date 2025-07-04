package exercise;

public class Main {
    public static void main(String[] args) {
        // Неявное приведение
        byte byteVar = 42;
        short shortVar = byteVar;
        int intVar = shortVar;
        long longVar = intVar;
        float floatVar = longVar;
        double doubleVar = floatVar;

        // Явное приведение
        double doubleVar1 = 42.0d;
        float floatVar1 = (float) doubleVar1;
        long longVar1 = (long) floatVar1;
        int intVar1 = (int) longVar1;
        short shortVar1 = (short) intVar1;
        byte byteVar1 = (byte) shortVar1;

        char char1 = 1, char2 = 2;
        short short1 = 1, short2 = 2;
        int int1 = 1, int2 = 2;
        float float1 = 1.0f, float2 = 2.0f;

        // char1 = char1 + char2;       // Ошибка: Невозможно преобразовать из int в char;
        // short1 = short1 + short2;    // Ошибка: Невозможно преобразовать из int в short;
        int1 = char1 + char2;           // char преобразуется в int.
        int1 = short1 + short2;         // short переводится в int.
        int1 = char1 + short2;          // и char, и short преобразуются в int.
        float1 = short1 + float2;       // short преобразуется в float
        int1 = int1 + int2;             // int не изменяется.


    }
}