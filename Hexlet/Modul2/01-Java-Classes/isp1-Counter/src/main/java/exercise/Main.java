package exercise;

// BEGIN
import lombok.Getter;

@Getter
class Counter {
    private int count;

    Counter() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        if (count == 0) {
            throw new UnsupportedOperationException("Counter can not be negative");
        }

        count--;
    }
}
// END

