package exercise;

import java.io.*;

public class Pond implements Serializable {

    transient private Duck duck = new Duck(); // пометка, что объект нужно пропустить и не сериализировать

    public static void main(String[] args) {
        Pond pond = new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(pond);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class Duck {}   // java.io.NotSerializableException: exercise.Duck