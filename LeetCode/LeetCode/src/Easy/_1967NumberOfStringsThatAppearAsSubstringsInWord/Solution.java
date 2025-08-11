package Easy._1967NumberOfStringsThatAppearAsSubstringsInWord;
// Учитывая массив строк patterns и строку word, верните количество строк в patterns,
// которые существуют как подстрока в word.
//Подстрока — это непрерывная последовательность символов в строке.
//Пример 1:
//Ввод: шаблоны = [«a», «abc», «bc», «d»], слово = «abc»
//Вывод: 3
//Пояснение:
//- «a» встречается в качестве подстроки в «abc».
//- «abc» встречается в качестве подстроки в «abc».
//- "bc" встречается в качестве подстроки в "abc".
//- "d" не встречается в качестве подстроки в "abc".
// Три строки в шаблонах встречаются в качестве подстроки в слове.
//Пример 2:
//Входные данные: шаблоны = [«a», «b», «c»], слово = «aaaaabbbbb»
//Выходные данные: 2
//Пояснение:
//- «a» встречается в качестве подстроки в «aaaaabbbbb».
//- «b» встречается в качестве подстроки в «aaaaabbbbb».
//- "c" не встречается в качестве подстроки в "aaaaabbbbb".
//2 из строк в шаблонах встречаются в качестве подстроки в слове.
//Пример 3:
//Ввод: шаблоны = [«a», «a», «a»], слово = «ab»
//Вывод: 3
//Пояснение: Каждый из шаблонов встречается в качестве подстроки в слове «ab».
public class Solution {
    // time O(n)
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (var str : patterns) {
            if (word.contains(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        System.out.println(new Solution().numOfStrings(patterns, word));
    }
}
