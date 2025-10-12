package ComputerScienceCenter.lection4.interfaceApp;

public enum Weekday {
    MONDAY("MON", false),
    TUESDAY("TUE", false),
    WEDNESDAY("WED", false),
    THURSDAY("THU", false),
    FRIDAY("FRI", false),
    SATURDAY("SAT", true),
    SUNDAY("SUN", true);

    private final String shortName;
    private final boolean weekend;

    Weekday(String shortName, boolean weekend) {
        this.shortName = shortName;
        this.weekend = weekend;
    }

    public String getShortName() {return shortName;}
    public boolean isWeekend() {return weekend;}
}

// EnumClass.values() - массив значений
// EnumClass.valueOf(String) - значение по имени (или исключение)
// ENUM_VALUE.name() - имя (=toString())
// ENUM_VALUE.ordinal() - порядковый номер
