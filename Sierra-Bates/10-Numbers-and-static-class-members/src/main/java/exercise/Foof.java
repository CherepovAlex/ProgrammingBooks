package exercise;

public class Foof {
    final int size = 3;
//    final int whuffle;

    public Foof(int whuffle) {
//        whuffle = 42; нельхя мень значение
    }
    void doStuff(final int x) {
        // вы не можете изменить x
    }
    void doMore() {
        final int z = 7;
        // вы не можете изменить z
    }
}

class Poof {
    final void calcWhuffle() {
        // запрещено переопределение метода
    }
}

final class MyMostPerfectClass {
    // запрещено создание дочерних классов
}