package ComputerScienceCenter.lection5;

public class Test2 {
    public static void main(String[] args) {
        try {
            for (String arg : args) {
                System.out.println(arg);
                if (arg.equals("exit")) return;
            }
        } finally { // используется для отката изменений в системе
            System.out.println("Exited!"); // выполнится
        }
    }
}
