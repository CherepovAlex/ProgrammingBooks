package exercise._05ListsInDetTypes;

import java.util.List;

public class App {
    // BEGIN (write your solution here)
    public static int countBooks(List<Book> books, String authorName, String genre) {

        var booksCont = 0;

        for (var book : books) {
            var bookAuthor = book.getAuthorName();
            var bookGenre = book.getGenre();

            if (bookAuthor.equals(authorName) && bookGenre.equals(genre)) {
                booksCont++;
            }
        }

        return booksCont;
    }
    // END

    public static void main(String[] args) {
        var books = List.of(
                new Book("Death on the Nile", "Agatha Christie", "Detective"),
                new Book("Murder on the Orient Express", "Agatha Christie", "Detective"),
                new Book("The Raven", "Edgar Allan Poe", "Poem")
        );

        System.out.println(countBooks(books, "Agatha Christie", "Detective")); // 2
    }

}

final class Book {

    private String title;
    private String authorName;
    private String genre;

    public Book(String title, String authorName, String genre) {
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenre() {
        return genre;
    }
}
