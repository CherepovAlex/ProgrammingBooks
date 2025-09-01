package exercise.Vebinar19_25_08_29_Streams;

public class Example5 {


    public static void main(String[] args) {
        System.out.println(isPalindrom(",aB121ba,"));
        System.out.println(isPalindrom1(",aB121ba,"));
    }
    // В коде есть логическая ошибка - метод reverse() изменяет оригинальный StringBuilder leftToRight,
    // поэтому сравнение всегда будет возвращать true.
    private static boolean isPalindrom(String from) {

        StringBuilder leftToRight = new StringBuilder();
        from.chars()                                    // Преобразует строку в поток символов
                .filter(Character::isLetterOrDigit)     // фильтрует только буквы и цифры
                .map(Character::toLowerCase)            // Приводит все к нижнему регистру
                .forEach(leftToRight::appendCodePoint); // Собирает обратно в строку
        //      .forEach(codePoint -> leftToRight.appendCodePoint(codePoint)); // аналог
        System.out.println("leftToRight: " + leftToRight);
        StringBuilder rightToLeft = new StringBuilder(leftToRight.reverse());
        return rightToLeft.toString().equals(leftToRight.toString());
    }
    // Исправленная версия:
    private static boolean isPalindrom1(String from) {
        StringBuilder leftToRight = new StringBuilder();
        from.chars()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(leftToRight::appendCodePoint);

        String processed = leftToRight.toString();
        String reversed = leftToRight.reverse().toString();

        return processed.equals(reversed);
    }

}
