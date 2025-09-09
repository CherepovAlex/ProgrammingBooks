package Glava1;

public class Classes {
    public static void main(String[] args) {
        Thermostat therm1, therm2;
        therm1 = new Thermostat();
        therm2 = new Thermostat();

        therm2.furnace_on();
    }
}

class Thermostat {
    private float currentTemp;
    private float desiredTemp;

    public void furnace_on() {
        // тело метода
    }

    public void furnace_off() {
        // тело метода
    }
}
