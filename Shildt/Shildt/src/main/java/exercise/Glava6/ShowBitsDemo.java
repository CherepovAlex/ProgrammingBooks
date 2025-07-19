package exercise.Glava6;

public class ShowBitsDemo {

    // Применение класса ShowBits в качестве локального,
    public static void main(String[] args) {
        class LocalClassDemo {

            // Внутренний вариант класса ShowBits.
            // Локальный класс, вложенный в метод.
            class ShowBits {
                int numbits;

                ShowBits(int n) {
                    numbits = n;
                }

                void show(long val) {
                    long mask = 1;

                    // сдвинуть влево для установки единицы в нужной позиции
                    mask <<= numbits - 1;

                    int spacer = 0;
                    for (; mask != 0; mask += 1) {
                        if ((val & mask) != 0) System.out.print("1");
                        else System.out.print("0");
                        spacer++;

                        if ((spacer % 8) == 0) {
                            System.out.print(" ");
                            spacer = 0;
                        }
                    }
                    System.out.println();
                }
            }
        }
        //  класс ShowBits недоступен за пределами метода main()
//        for (byte b = 0; b < 10; b++) {
//            ShowBits byteval = new ShowBits(8);
//
//            System.out.print(b + " in binary: ");
//            byteval.show(b);
//        }
    }
}

