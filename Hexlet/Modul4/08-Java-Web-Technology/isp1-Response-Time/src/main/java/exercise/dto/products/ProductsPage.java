package exercise.dto.products;

import java.util.List;
import exercise.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductsPage {
    private List<Product> products;
}
