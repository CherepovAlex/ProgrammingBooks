package Easy._551StudentAttendanceRecordI;

// Вам дана строка s с данными о посещаемости ученика, где каждый символ обозначает,
// отсутствовал ли ученик в этот день, опоздал или пришёл вовремя. В строке содержатся
// только следующие три символа: 'A': Отсутствует.'L': Поздно.'P': Настоящее время.
//Студент имеет право на поощрение за посещаемость, если он соответствует обоим следующим критериям:
//Студент отсутствовал ('A') строго менее 2 дней всего.
//Студент никогда не опаздывал ('L') в течение 3 или более последовательных дней.
//Вернитесь true если учащийся имеет право на поощрение за посещаемость, или
// false в противном случае.
// Example 1:
//Input: s = "PPALLP"
//Output: true
//Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
//Example 2:
//Input: s = "PPALLL"
//Output: false
//Explanation: The student was late 3 consecutive days in the last 3 days, so is not
// eligible for the award.
public class Solution {
    public boolean checkRecord(String s) {
        int amountOfAbsent, currentLaterSize;
        amountOfAbsent = currentLaterSize = 0;
        for (char symbol : s.toCharArray()) {
            if (symbol == 'A') {
                currentLaterSize = 0;
                if (++amountOfAbsent == 2) return false;
            }  else if (symbol == 'L') {
                if (++currentLaterSize == 3) return false;
            } else {
                currentLaterSize = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "PPALLP";
        System.out.println(new Solution().checkRecord(s));  // true

    }
}
