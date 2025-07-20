package exercise;
// импортируем все нужные пакеты
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadAFile {

    public static void main(String[] args) {

        try {
            File myFile = new File("MyFile.txt");
            FileReader fileReader = new FileReader(myFile); // это поток соединения для символов, который подключается к текстовому файлу
            BufferedReader reader = new BufferedReader(fileReader); // для более эффективного чтения соединим FileReader с BufferedReader
            // создаёи строкову переменную для временного хранения каждой строки в процессе чтения
            String line = null;
            // читаем строку текста и присваиваем её line, пока она не пуста,
            while((line = reader.readLine()) != null) { // выводим на экран
                System.out.println(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
