package exercise.Vebinar13_25_08_08_OOP1;

public class Example2 {
    public static void main(String[] args) {

    }
}

// закрытый (sealed) класс может иметь подклассы, но только тогда, когда дали разрешение

//public sealed class Pet permits Cat, Dog, Fish {}
   //никто, кроме перечисленных не может быть потомком Pet

final class Cat {}

//public non-sealed class Fish {}

//public sealed class Dog permits Hound, Terrier, Toy {}
//

class Hound {}

class Terrier {}

class Toy {}