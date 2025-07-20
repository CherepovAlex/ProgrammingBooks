package exercise._07SortLists;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    // BEGIN (write your solution here)
    public static List<String> getCars(List<Car> cars, int before) {

        var filteredCars = new ArrayList<String>();

        for (var car : cars) {
            var yearOfManufacture = car.getManufacturedAt().getYear();

            if (yearOfManufacture < before) {
                filteredCars.add(car.toString());
            }
        }

        Collections.sort(filteredCars, String.CASE_INSENSITIVE_ORDER);

        return filteredCars;
    }
    // END

    public static void main(String[] args) {
        var cars = List.of(
                new Car("Jaguar", "XK120", LocalDate.of(1950, 8, 21)),
                new Car("Mercedes-Benz", "W114", LocalDate.of(1968, 7, 10)),
                new Car("Fiat", "600", LocalDate.of(1956, 1, 1))
        );

        var result = App.getCars(cars, 1960);
        System.out.println(result); // => [Fiat 600, Jaguar XK120]
    }

}

final class Car {

    private String made;
    private String model;
    private LocalDate manufacturedAt;

    public Car(String made, String model, LocalDate manufacturedAt) {
        this.made = made;
        this.model = model;
        this.manufacturedAt = manufacturedAt;
    }

    public String getMade() {
        return made;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getManufacturedAt() {
        return manufacturedAt;
    }

    @Override
    public String toString() {
        return made + " " + model;
    }
}
