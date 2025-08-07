package exercise.Consultation6;
/*1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно использовать не все придуманные поля и методы.
Создайте несколько экземпляров этого класса, выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась его кличка, цвет и возраст (или другие параметры на ваше усмотрение).
*/

import java.time.LocalDate;
import java.time.Period;

class Cat {
    private String name;
    private String color;
    private LocalDate birthDate;

    public Cat(String name, String color, LocalDate birthDate) {
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        int age = getAge();
        //String yearsWord=(age %10==1 && age % 100 !=11) ? "год": "лет";
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;
        String yearsWord;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            yearsWord = "лет";
        } else if (lastDigit == 1) {
            yearsWord = "лет";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            yearsWord = "года";
        } else {
            yearsWord = "лет";
        }

        return String.format("%s (%s),%d %s", name, color, age, yearsWord);
    }
}

public class CatWithFields {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик", "рыжий", LocalDate.of(2024, 5, 20));
        System.out.println(cat1.toString());
    }
}