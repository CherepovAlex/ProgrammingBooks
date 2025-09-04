package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.taks1;

// класс, который умеет хранить 2 значения любого типа

public class Pair<U, V> {

    // если хотим работать с 2 параметрами одинакового типа, то используем 2 одинаковые буквы
    // Pair<U, U>

    private U firstValue;
    private V secondValue;


    public U getFirstValue() {
        return firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    public void setFirstValue(U value) {
        this.firstValue = value;
    }

    public void setSecondValue(V value) {
        this.secondValue = value;
    }

}
