package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.lambda;

public class Main {
    public static void main(String[] args) {

        // как работало раньше без лямбды, создание анонимного класса
        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public double getValue() {
                return 234;
            }
        };
        System.out.println(myFunctionalInterface.getValue());

        // скобки () - это то, что выше было методом getValue()
        MyFunctionalInterface myFunctionalInterfaceLambda = () -> 234;
        System.out.println(myFunctionalInterface.getValue());
        // -----------------------------------------------------------------

        // когда указан Тип данных, с которыми работает функциональный интерфейс
        ReverseInterface reverseInterface = (str) -> new StringBuilder(str).reverse().toString();
        System.out.println(reverseInterface.getReverseString("Hello"));

        // когда тип данных может быть любым как мы выберем для работы
        MySuperInterface<String> reversedString = (str) -> new StringBuilder(str).reverse().toString();
        System.out.println(reversedString.func("Lambda"));

        MySuperInterface<Integer> factorial = (value) -> {
            int result = 1;
            for (int i = 1; i <= value; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println(factorial.func(5));
    }
}
