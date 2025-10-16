package ComputerScienceCenter.lection5;

public class TestGeneric2 {
}

// Covariant return type

// поставщик
interface Supplier {
    Object get();
}

// поставщик конкретно строк
interface StringSupplier extends Supplier {
    @Override
    String get();
}