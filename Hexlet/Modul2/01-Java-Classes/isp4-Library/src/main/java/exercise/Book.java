package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = {"published"})

public class Book {

    private String title;
    private String author;
    private int published;
}
