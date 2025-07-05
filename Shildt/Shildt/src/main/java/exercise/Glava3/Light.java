package exercise.Glava3;
//  Рассчитать расстояние, проходимое светом,
//  с применением переменных типа long

public class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;
        // приблизительная скорость света в милях в секунду
        lightspeed = 186000;
        days = 1000;                     // указать количество дней
        seconds = days * 24 * 60 * 60;   // преобразовать в секунды
        distance = lightspeed * seconds; // рассчитать расстояние
        // Вывести примерно расстояние в милях, проходимое светом
        // за указанное количество дней
        System.out.print("For " + days);
        System.out.print(" days the light will go about ");
        System.out.println(distance + " miles");
    }
}

// For 1000 days the light will go about 16070400000000 miles