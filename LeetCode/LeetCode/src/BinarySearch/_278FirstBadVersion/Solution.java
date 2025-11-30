package BinarySearch._278FirstBadVersion;
// 278. Первая неудачная версия
// Вы — менеджер по продукту и в настоящее время возглавляете команду, которая занимается разработкой нового продукта.
// К сожалению, последняя версия вашего продукта не прошла проверку качества.
// Поскольку каждая версия разрабатывается на основе предыдущей, все версии после неудачной также являются неудачными.
//Предположим, у вас есть n версий [1, 2, ..., n] и вы хотите найти первую плохую версию,
// из-за которой все последующие тоже становятся плохими.
//Вам предоставлен API bool isBadVersion(version), который возвращает информацию о том,
// является ли version плохой версией. Реализуйте функцию для поиска первой плохой версии.
// Вам следует свести к минимуму количество обращений к API.
// Example 1:
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
//Example 2:
//Input: n = 1, bad = 1
//Output: 1
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    // time O(log n) бинарный поиск, space O(1)
    public int firstBadVersion(int n) {
        // Инициализация границ: корректно, так как версии нумеруются от 1 до n.
        int left = 1, right = n;
        // цикл продолжается, пока границы не сойдутся.
        while (left < right) {
            // Вычисление середины: защита от переполнения, корректно.
            int mid = left + (right - left) / 2;
            // Если isBadVersion(mid) вернет true, значит первая плохая версия где-то слева (включая mid)
            if (isBadVersion(mid)) {
                // Если средняя версия плохая, первая плохая версия находится слева (включая mid)
                right = mid;
            } else {
                // Если средняя версия хорошая, первая плохая версия находится справа от mid
                left = mid + 1;
            }
        }
        // Доп. проверка избыточна: так как цикл гарантирует, что left будет указывать на первую плохую версию.
//        if(left == right && isBadVersion(left)) {
//            return left;
//        }
//        return -1;
        return left; // В этой точке left == right, и это первая плохая версия
    }

    public static void main(String[] args) {
        int n = 5, bad = 4;
        System.out.println(new Solution().firstBadVersion(n));
    }
}

class VersionControl {
    public boolean isBadVersion(int n) {
        n = 4;
        if (n == 4) return true;
        return false;
    }
}