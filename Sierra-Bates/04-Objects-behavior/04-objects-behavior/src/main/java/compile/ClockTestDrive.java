package compile;

class Clock {
    String time;

    void seTime (String t) {
        time = t;
    }
    String getTime() {
        return time;
    }
}

public class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock();
        c.seTime("1245");
        String tod = c.getTime();
        System.out.println("время: " + tod);
    }
}
