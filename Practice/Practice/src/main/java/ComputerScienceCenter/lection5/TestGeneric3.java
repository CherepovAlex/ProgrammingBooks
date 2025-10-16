package ComputerScienceCenter.lection5;

public class TestGeneric3 {
    public static void main(String[] args) {

    }
    // параметризованные методы: две ссылки в сигнатуре
    <T> T getT() {
        return null;
    }

    // странный код
    Object obj;

    @SuppressWarnings("unchecked")
        <T> T getT1() {
        return (T)obj;
    }

    void test() {
        String str = getT();
        Integer integer = getT();
    }
}
