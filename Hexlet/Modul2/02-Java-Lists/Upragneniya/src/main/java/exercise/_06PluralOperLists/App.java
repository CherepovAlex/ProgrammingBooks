package exercise._06PluralOperLists;

import java.util.List;
import java.util.ArrayList;

public class App {

    // BEGIN (write your solution here)
    public static List<User> getCommonFriends(User user1, User user2) {

        var user1List = user1.getFriends();
        var user2List = user2.getFriends();
        ArrayList<User> commonFriends = new ArrayList<>(user1List);
        commonFriends.retainAll(user2List);
        return commonFriends;

    }
    // END
    public static void main(String[] args) {
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
    }
}

final class User {

    private String name;
    private List<User> friends;

    public User(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    @Override
    public String toString() {
        return name;
    }
}