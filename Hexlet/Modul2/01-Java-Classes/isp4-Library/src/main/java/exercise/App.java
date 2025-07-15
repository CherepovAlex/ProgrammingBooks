package exercise;

import exercise.Book;
import java.util.Arrays;

class App {
    public static Book[] find(Book[] library, Book book) {
        var result = new Book[library.length];

        var index = 0;

        for (var currentBook : library) {

            if (currentBook.equals(book)) {
                result[index] = currentBook;
                index++;
            }
        }

        return Arrays.copyOf(result, index);
    }
}
