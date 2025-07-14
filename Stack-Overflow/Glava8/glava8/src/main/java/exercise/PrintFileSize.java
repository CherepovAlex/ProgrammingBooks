package exercise;

import java.io.File;

public class PrintFileSize {
    public static void main(String[] args) {
        for (String name : args) {
            File file = new File(name);
//            System.out.println("Size '" + file + "' is " + file.size());
        }
    }
}
