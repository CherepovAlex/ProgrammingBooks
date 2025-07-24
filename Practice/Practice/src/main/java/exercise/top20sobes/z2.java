package exercise.top20sobes;

// Напишите программу на Java для переворота последовательности символов в строке
// без использования встроенной в String функции reverse().

public class z2 {

    public static void main(String[] args) {

        String st = "Учимся программировать";

        char symbols[] = st.toCharArray();  // конвертируем строку в массив символов,
                                            // затем выводим символы на экран в обратном порядке

        for (int x = symbols.length - 1; x >= 0; x--) {

            System.out.print(symbols[x]);

        }

    }

}
