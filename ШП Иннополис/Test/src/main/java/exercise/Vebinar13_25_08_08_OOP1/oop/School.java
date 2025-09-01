package exercise.Vebinar13_25_08_08_OOP1.oop;

public class School {
    private final String title;
    private String address;
    private static final String CONST = "My constanta";

    public School(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public School(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "School{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
