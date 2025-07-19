package exercise.Glava6;

// Применение статического блока,
class StaticBlock {
    static double root0f2;
    static double root0f3;

    // Этот блок выполняется при загрузке класса.
    static {
        System.out.println("Inside static block.");
        root0f2 = Math.sqrt(2.0);
        root0f3 = Math.sqrt(3.0);
    }

    StaticBlock(String msg) {
        System.out.println (msg) ;
    }
}

class SDemo3 {
    public static void main(String args[]) {
        StaticBlock ob = new StaticBlock("Inside Constructor");

        System.out.println("Square root of 2 is " +
                            StaticBlock.root0f2);
        System.out.println("Square root of 3 is " +
                            StaticBlock.root0f3) ;
    }
}