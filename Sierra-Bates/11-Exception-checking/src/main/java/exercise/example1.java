package exercise;

public class example1 {

    // метод сообщает всеи об исключении
    public void takeRisk() throws BadException{
        boolean abandonAllHope = true;
        if (abandonAllHope) {
            // новый объект выбрасывает исключение
            throw new BadException();
        }
    }

    public void crossFingers() {
        example1 anObject = new example1();
        try {
            anObject.takeRisk();
        } catch (BadException ex) {
            System.out.println("Ahh!");
            ex.printStackTrace();
        }
    }

}
