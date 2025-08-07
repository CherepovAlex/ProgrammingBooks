package _831MaskingPersonalInformation;
// Вам будет предоставлена строка личной информации s,
// представляющая собой либо адрес электронной почты, либо номер телефона.
// Верните замаскированную личную информацию, используя приведенные ниже правила.
// - Эл. адрес: - Адрес электронной почты - это:
// + Имя, состоящее из прописных и строчных букв английского алфавита, за которым следует
// + Символ '@', за которым следует
// + Домен состоит из прописных и строчных букв английского алфавита с точкой '.' где-то посередине (не в начале и не в конце).
//Чтобы замаскировать электронное письмо:
// + Заглавные буквы в имени и домене должны быть преобразованы в строчные.
// + Средние буквы имени (то есть все буквы, кроме первой и последней) должны быть заменены на 5 звёздочек "*****".
//- Номер телефона:
//Телефонный номер записывается следующим образом:
// + Телефонный номер состоит из 10–13 цифр.
// + Последние 10 цифр составляют местный номер.
// + Оставшиеся 0–3 цифры в начале составляют код страны.
// + Разделительные символы из набора {'+', '-', '(', ')', ' '} каким-то образом разделяют указанные выше цифры.
// Чтобы скрыть номер телефона:
// + Удалите все разделительные символы.
// + Замаскированный номер телефона должен иметь следующий вид:
// + "***-***-XXXX" если в коде страны 0 цифр.
// + "+*-***-***-XXXX" если код страны состоит из одной цифры.
// + "+**-***-***-XXXX" если код страны состоит из двух цифр.
// + "+***-***-***-XXXX" если код страны состоит из трёх цифр.
// + "XXXX" это последние 4 цифры местного номера.
// Example 1:
//Input: s = "LeetCode@LeetCode.com"
//Output: "l*****e@leetcode.com"
//Explanation: s is an email address.
//The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
//Example 2:
//Input: s = "AB@qq.com"
//Output: "a*****b@qq.com"
//Explanation: s is an email address.
//The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
//Note that even though "ab" is 2 characters, it still must have 5 asterisks in the middle.
//Example 3:
//Input: s = "1(234)567-890"
//Output: "***-***-7890"
//Explanation: s is a phone number.
//There are 10 digits, so the local number is 10 digits and the country code is 0 digits.
//Thus, the resulting masked number is "***-***-7890".

public class Solution {

//     private static final String FIVE_STARS = "*****";    //  константа для маскировки email (5 звездочек)
//    private static final String[] PHONE_MASKS = { // предопределенные маски для телефонов в зависимости от длины кода страны
//        "***-***-",  // 0 digits country code
//        "+*-***-***-",  // 1 digit
//        "+**-***-***-",  // 2 digits
//        "+***-***-***-"  // 3 digits
//    };

    public String maskPII(String s) {
        if (s.matches("^[A-Za-z]+@[A-Za-z]+\\.[A-Za-z]+$")) {
            return mail(s);
        } else {
            return phone(s);
        }
    }
      // Быстрая проверка первого символа: если буква - обрабатываем как email, иначе как телефон
//    public String maskPII(String s) {
//        // Быстрая проверка первого символа для предварительного определения типа
//        char firstChar = s.charAt(0);
//        if ((firstChar >= 'a' && firstChar <= 'z') ||
//            (firstChar >= 'A' && firstChar <= 'Z')) {
//            return mail(s);
//        }
//        return phone(s);
//    }

    private final String mail(String s) {
        s = s.toLowerCase();
        int atIndex = s.indexOf("@");
        return s.charAt(0) + "*****" + s.charAt(atIndex - 1) + s.substring(atIndex);
    }

//    private String mail(String s) {
            // Подготавливаем массив символов с запасом места
//        int atIndex = -1;
//        int len = s.length();
//        char[] chars = new char[len + 5]; // Максимально возможная длина
//
//        // Обрабатываем имя до @ - Первый символ в нижний регистр + 5 звездочек
//        chars[0] = Character.toLowerCase(s.charAt(0));
//        System.arraycopy(FIVE_STARS.toCharArray(), 0, chars, 1, 5);
//
//        // Находим позицию @ берем предшествующий символ и домен
//        for (int i = 1; i < len; i++) {
//            if (s.charAt(i) == '@') {
//                atIndex = i;
//                chars[6] = Character.toLowerCase(s.charAt(i-1));
                    // Копируем оставшуюся часть email в нижнем регистре
//                System.arraycopy(s.substring(i).toLowerCase().toCharArray(), 0, chars, 7, len - i);
                    // Собираем итоговую строку из массива символов
//                return new String(chars, 0, 7 + len - i);
//            }
//        }
//        return s; // fallback, если email невалидный
//    }

    private final String phone(String s) {
        // dell all non digit symbols
        String digits = s.replaceAll("[^0-9]", "");
        int totalDigits = digits.length();
        int countryCodeDigits = totalDigits - 10;

        // get last 4 digits
        String lastFour = digits.substring(digits.length() - 4);

        // form result in depends on country code
        switch (countryCodeDigits) {
            case 0 -> {
                return "***-***-" + lastFour;
            }
            case 1 -> {
                return "+*-***-***-" + lastFour;
            }
            case 2 -> {
                return "+**-***-***-" + lastFour;
            }
            case 3 -> {
                return "+***-***-***-" + lastFour;
            }
            default -> throw new IllegalArgumentException("Wrong number");
        }
    }

//     private String phone(String s) {
            // Подготавливаем массивы для хранения цифр
//        int digitCount = 0;
//        char[] digits = new char[13]; // Максимальная длина номера
//        int lastFourStart = 0;
//
//        // Извлекаем цифры и считаем их - Отслеживаем позиции последних 4 цифр
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c >= '0' && c <= '9') {
//                if (digitCount < 13) {
//                    digits[digitCount] = c;
//                }
//                digitCount++;
//                if (digitCount >= 10) {
//                    lastFourStart = (digitCount - 4) % 13;
//                }
//            }
//        }
//
//        // Проверяем валидность номера
//        if (digitCount < 10 || digitCount > 13) {
//            throw new IllegalArgumentException("Invalid phone number length");
//        }
//
//        // Формируем результат - Выбираем подходящую маску из предопределенных
//        int countryCodeDigits = digitCount - 10;
//        char[] result = new char[PHONE_MASKS[countryCodeDigits].length() + 4];
//        System.arraycopy(PHONE_MASKS[countryCodeDigits].toCharArray(), 0, result, 0,
//                       PHONE_MASKS[countryCodeDigits].length());
//
//        // Добавляем последние 4 цифры к маске, Возвращаем итоговую строку
//        for (int i = 0; i < 4; i++) {
//            result[PHONE_MASKS[countryCodeDigits].length() + i] =
//                digits[(lastFourStart + i) % 13];
//        }
//
//        return new String(result);
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maskPII("LeetCode@LeetCode.com")); // "l*****e@leetcode.com"
        System.out.println(solution.maskPII("AB@qq.com"));            // "a*****b@qq.com"

        System.out.println(solution.maskPII("1(234)567-890"));        // "***-***-7890"
        System.out.println(solution.maskPII("+1 (234) 567-890"));    // "+*-***-***-7890"
        System.out.println(solution.maskPII("+86 234 567 8901"));    // "+**-***-***-8901"
        System.out.println(solution.maskPII("+123 456 789 0123"));    // "+***-***-***-0123"
    }
}
