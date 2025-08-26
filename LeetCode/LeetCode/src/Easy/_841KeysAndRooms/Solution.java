package Easy._841KeysAndRooms;

import java.util.*;

// В здании n комнат, пронумерованных от 0 до n - 1, и все они заперты, кроме комнаты 0.
// Ваша цель — посетить все комнаты. Однако вы не можете войти в запертую комнату, не имея ключа.
//Когда вы войдёте в комнату, вы можете обнаружить в ней набор отдельных ключей.
// На каждом ключе указан номер комнаты, которую он открывает.
// Вы можете взять их все с собой, чтобы открыть другие комнаты.
//Дан массив rooms, где rooms[i] — это набор ключей, которые вы можете получить, посетив комнату i.
// Верните true если вы можете посетить все комнаты или false в противном случае.
// Example 1:
//Input: rooms = [[1],[2],[3],[]]
//Output: true
//Explanation:
//We visit room 0 and pick up key 1.
//We then visit room 1 and pick up key 2.
//We then visit room 2 and pick up key 3.
//We then visit room 3.
//Since we were able to visit every room, we return true.
//Example 2:
//Input: rooms = [[1,3],[3,0,1],[2],[0]]
//Output: false
//Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
public class Solution {
    // time O(n + k), space  O(n)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // Создает массив для отслеживания посещенных комнат. Размер равен количеству комнат.
        boolean[] visited = new boolean[n];
        //  Помечает комнату 0 как посещенную (она изначально открыта).
        visited[0] = true;
        // Использует стек для обхода в глубину (DFS). Добавляет начальную комнату 0.
        Deque<Integer> stack = new ArrayDeque();
        stack.add(0);
        int visitedCount = 1; // Счетчик посещенных комнат
        // Извлекает ключ из стека для обработки текущей комнаты.
        while (!stack.isEmpty()) {
            int currentRoom  = stack.pop();
            // Перебирает все ключи, найденные в текущей комнате.
            for (int key  : rooms.get(currentRoom)) {
                // Если комната еще не посещалась
                if (!visited[key]) {
                    // помечает ее как посещенную
                    visited[key] = true;
                    // добавляем посещённую комнату
                    visitedCount++;
                    // добавляет ключ в стек
                    stack.push(key);

                    // Ранний выход: если все комнаты посещены
                    if (visitedCount == n) {
                        return true;
                    }
                }
            }
        }
//        //  Проверяет, все ли комнаты были посещены.
//        for (boolean seen : visited) {
//            if (!visited) return false;
//        }
//        return true;
        return visitedCount == n;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList() // или Collections.emptyList()
        );
        System.out.println(new Solution().canVisitAllRooms(list));
    }

}
