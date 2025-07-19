Одно из типичных действий в социальных сетях - поиск общих друзей. В этом упражнении вам предстоит реализовать аналогичный функционал

src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод getCommonFriends(), который находит общих друзей у двух пользователей. Метод принимает два параметра - пользователей, у которых мы ищем общих друзей

Метод должен вернуть список List<User> друзей, которые являются общими для двух переданных пользователей
```java
var user1 = new User("John");
user1.addFriend(new User("Ellery"));

var user2 = new User("Anna");
user2.addFriend(new User("Abey"));

// Общий друг двух пользователей
var friend = new User("Jacky");
user1.addFriend(friend);
user2.addFriend(friend);

List<User> commonFriends = App.getCommonFriends(user1, user2);
System.out.println(commonFriends); // => ["Jacky"]
```
Подсказки
Изучите класс User, который представляет собой пользователя нашей социальной сети. Посмотрите, как хранятся друзья пользователя
В упражнении доступна зависимость CollectionUtils. При желании можете импортировать и использовать ее