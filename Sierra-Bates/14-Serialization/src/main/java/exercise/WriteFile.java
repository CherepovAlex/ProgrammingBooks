package exercise;
// пакет java.io.*
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void main(String[] args) {

        try {   // если такого файла нет, то FileWriter создаст его
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hi, Foo!");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
