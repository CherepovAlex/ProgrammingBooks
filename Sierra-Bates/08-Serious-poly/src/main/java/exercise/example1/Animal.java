package exercise.example1;

abstract public class Animal {
    void makeNoise() {}
    abstract void eat();
    void sleep() {}
    void roam() {}

    public static void main(String[] args) {
        Wolf w = new Wolf();
        w.makeNoise();
        w.roam();
        w.eat();
        w.sleep();

        Dog myDog1 = new Dog();
        Animal myDog2 = new Dog();

        Animal[] animals = new Animal[5];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Wolf();
        animals[3] = new Hippo();
        animals[4] = new Lion();

        for (int i = 0; i < animals.length; i++) {
            animals[i].eat();
            animals[i].roam();
        }

        MyAnimalList list = new MyAnimalList();
        Dog a =  new Dog();
        Cat c =  new Cat();
        list.add(a);
        list.add(c);
    }
}

class Vet {
    public void giveShot(Animal a) {
        a.makeNoise();
    }
}

class PetOwner {
    public void start() {
        Vet v = new Vet();
        Dog d = new Dog();
        Hippo h = new Hippo();
        v.giveShot(d);
        v.giveShot(h);
    }
}

class MakeCanine {
    public void go() {
        Canine c;
        c = new Dog();
//        c = new Canine(); - класс абстрактный
        c.roam();
    }
}

abstract class Feline extends Animal {
    void roam (){}
}
class Hippo extends Animal {
    void makeNoise() {}
    void eat() {}
}
abstract class Canine extends Animal {
    void roam (){}
}

class Lion extends Feline{
    void makeNoise() {}
    void eat() {}
}
class Tiger extends Feline {
    void makeNoise() {}
    void eat() {}
}
class Cat extends Feline {
    void makeNoise() {}
    void eat() {}
}

class Wolf extends Canine{
    void makeNoise() {}
    void eat() {}
}
class Dog extends Canine{
    void makeNoise() {}
    void eat() {}
}

class MyDogList {
    private Dog[] dogs = new Dog[5]; // внутри используем обычный массив объектов Dog
    private int nextIndex = 0;       // мы будем увеличивать его при каждом добавлении объекта Dog

    public void addDog(Dog d) {
        // если мы ещё не дошли до предела массива, то добавляем объект Dog и выводим сообщение
        if (nextIndex < dogs.length) {
            dogs[nextIndex++] = d;
            System.out.printf("Dog добавлен в ячейку " + nextIndex);
            nextIndex++;
        }
    }
}

class MyAnimalList {
    private Animal[] animals = new Animal[5]; // создаём не объект, а массив
    private int nextIndex = 0;

    public void add(Animal a) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.printf("Animal добавлен в ячейку" + nextIndex);
            nextIndex++;
        }
    }
}

