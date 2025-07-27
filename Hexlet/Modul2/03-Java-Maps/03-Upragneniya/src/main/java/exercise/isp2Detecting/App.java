package exercise.isp2Detecting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static List<Map<String,String>> findWhere(List<Map<String,String>> data, Map<String,String> items) {
        var newList= new ArrayList<Map<String, String>>();
        for(var book : data){
            boolean author = false;
            boolean year = false;
            for(var entry:book.entrySet()){
                if (items.get("author").equals(book.get(entry.getKey()))) {
                    author = true;
                }
                if (items.get("year").equals(book.get(entry.getKey()))) {
                    year = true;
                }
            }
            if (author && year){
                newList.add(book);
            }
        }
        return newList;
    }

    public static void main(String[] args) {

        var books = new ArrayList<Map<String, String>>();

        var book1 = Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611");
        var book2 = Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111");
        var book3 = Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611");
        var book4 = Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222");
        var book5 = Map.of("title", "Still foooing", "author", "FooBar", "year", "3333");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        var where = Map.of(
                "author", "Shakespeare",
                "year", "1611"
        );

        var result = App.findWhere(books, where);

        System.out.println(result); // =>
// [
//     {title=Cymbeline, year=1611, author=Shakespeare},
//     {title=The Tempest, year=1611, author=Shakespeare}
// ]

    }

}
