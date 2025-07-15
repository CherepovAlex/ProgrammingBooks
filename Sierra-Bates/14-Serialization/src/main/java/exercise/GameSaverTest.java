package exercise;

import java.io.*;

public class GameSaverTest {

    public static void main(String[] args) {

        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "dagger", "first-weapon"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"first", "big knife"});
        GameCharacter three = new GameCharacter(50, "Wizard", new String[]{"miracle", "invisible"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // присваиваем null, чтобы мы не смогли обратиться к объектам у "куче"
        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();
            // делаем поверку
            System.out.println("One type: " + oneRestore.getType());
            System.out.println("Two type: " + twoRestore.getType());
            System.out.println("Three type: " + threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int p, String t, String[] w) {
        this.power = p;
        this.type = t;
        this.weapons = w;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
}
