package exercise;

class Player {
    public static final int FOO_X = 25;

    public static final double BAR_SIGN;

    static int playerCount = 0;
    private String name;

    static {
        BAR_SIGN = (double)Math.random();
    }

    public Player(String n) {
        name = n;
        playerCount++;
    }
}

public class PlayerTestDrive {
    public static void main(String[] args) {
        System.out.println(Player.playerCount);
        Player one = new Player("Tyger woods");
        System.out.println(Player.playerCount);
    }
}
