package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.Example_Person;

public interface Person {
    String getName();

   default void sayHi(){};
}
