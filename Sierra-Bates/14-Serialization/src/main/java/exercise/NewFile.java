package exercise;

import java.io.File;

public class NewFile {

    public static void main(String[] args) {
        // создаём объект файл, представляющий существующий файл
        File f = new File("MyCode.txt");
        // создаём новый каталог
        File dir = new File("Chapter7");
        dir.mkdir();
        // выводим содержимое каталога
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for(int i = 0; i < dirContents.length; i++) {
                switch (dirContents[i]) {}
            }
        }
        // получить абсолютный путь файла или каталоге
        System.out.println(dir.getAbsoluteFile());;
        // удалить файл или каталог (возращает true при выполнении)
        boolean isDeleted = f.delete();
    }

}
