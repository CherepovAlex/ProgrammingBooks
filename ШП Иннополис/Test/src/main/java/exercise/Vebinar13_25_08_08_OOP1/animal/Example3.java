package exercise.Vebinar13_25_08_08_OOP1.animal;

public class Example3 {
    public static void main(String[] args) {

        Animal tiger = new Tiger();
        Mammal tigerOne = new Tiger();
        Tiger tigerTwo = new Tiger();

        // проверяет тип объекта tiger (является ли tiger экземпляром класса tiger)
        if (tiger instanceof Tiger) {   // true
            // приведение к типу объекта и использование его методов
            ((Tiger)tiger).getMeat();
        }

        if(tiger.getClass() == Tiger.class) { // true
            ((Tiger) tiger).getMeat();
        }
    }
}
