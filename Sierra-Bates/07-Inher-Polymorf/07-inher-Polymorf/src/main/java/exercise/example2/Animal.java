package exercise.example2;

public class Animal {
    void makeNoise() {}
    void eat() {}
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

class Feline extends Animal {
    void roam (){}
}
class Hippo extends Animal {
    void makeNoise() {}
    void eat() {}
}
class Canine extends Animal {
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