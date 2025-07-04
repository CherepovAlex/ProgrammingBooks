package exercise;

import java.util.Calendar;
import java.util.Date;

public class Casting {
    public static void main(String[] args) {
//      int badInt = (int) true;   // Ошибка компилятора: несовместимые типы
        char char1 = (char) 65;     // A
        byte byte1 = (byte) 'A';    // 65
        short short1 = (short) 'A';    // 65
        int int1 = (int) 'A';    // 65

        char char2 = (char) 8253;   // ?
        byte byte2 = (byte) '?';    // 61 (усеченная кодовая точка в ASCII диапазоне)
        short short2 = (short) '?';    // 8253
        int int2 = (int) '?';    // 8253

        Float floatVar = new Float(42.0f);
//        Number n = floatVar;                // Неявное приведение (Float является имплементацией Number)
//        Float floatVar2 = (Float) n;        // Явное приведение
//        Double doubleVar = (Double) n;      // Вызывает исключение (объект не является Double)

        Object obj = Calendar.getInstance();
        long time = 0;

        if (obj instanceof Calendar) {
//            time = ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            time = ((Date) obj).getTime();    // Эта строка никогда не будет достигнута
        }                                    // поскольку obj не является типом Date
    }
}

class Float {
    float a;

    public Float(float a) {
        this.a = a;
    }
}
