package exercise.Classes;

public class Cat {

    String name;
    int age;

    static int count = 0;

    public Cat() {
        System.out.println("Создали кота!");
        count++;
        this.name = "Уличный кот номер " + count;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayMeow() {
        System.out.println("Мяу!");
    }

    public void jump() {
        System.out.println("Прыг-скок!");
    }

    public static void main(String[] args) {
        Cat barsik = new Cat();
        barsik.age = 3;
        barsik.name = "Барсик";
        count++;

        barsik.sayMeow();
        barsik.jump();

        System.out.println("Тут в программе в течение 2-х часов что-то происходит...");

        barsik.age = 3;
        barsik.name = "Барсик";

        Cat vasia = new Cat();
        vasia.age = 5;
        vasia.name = "Вася";
        count++;

        Cat barsik1 = new Cat("Barsik", 5);
        System.out.println(barsik1.name);
        System.out.println(barsik1.age);

        System.out.println("Мы создали кота по имени " + barsik.name + ", его возраст - " + barsik.age);
        System.out.println("Мы создали кота по имени " + vasia.name + ", его возраст - " + vasia.age);

        System.out.println("Общее количество котов = " + count);

        Cat streetCat = new Cat();
        Cat streetCat1 = new Cat();
        Cat streetCat2 = new Cat();
        System.out.println(streetCat1.name);
        System.out.println(streetCat2.name);
    }
}