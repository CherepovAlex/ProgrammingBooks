package ComputerScienceCenter.lection5;


public class Test4 {
    public static void main(String[] args) {
        // try-finally: способы выхода
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 5) continue;
                if (i == 7) break;
                System.out.println("Do iteration");
            } finally {
                System.out.println("I = " + i);
            }
        }
    }

    // try-finally: как не надо делать
    public static int test() {
        try {
            return 5;
        } finally {
            return 6; // вернёт 6, т.к. выполняется перед окончанием блока try
        }
    }

    // try-finally: как не надо делать
    public static int test1() {
        int x = 5;
        try {
            return x;
        } finally {
            x = 6;  // вернёт 5, т.к. значение уже вычислено
        }
    }
}
