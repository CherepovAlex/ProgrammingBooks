package exercise.Vebinar13_25_08_08_OOP1.animal;

// полиморфизм - способность объекта принимать множество форм
//                наследует       реализует
public class Tiger extends Mammal implements Animal {
    void getMeat(){
        System.out.println("Tiger eat");
    }
}
