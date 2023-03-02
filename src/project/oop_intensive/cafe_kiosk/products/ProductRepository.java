package oop_intensive.cafe_kiosk.products;

import java.util.List;

public class ProductRepository {
    private List<Product> products = List.of(
            new Coffee(1, "Americano", 3000, false),
            new Coffee(2, "Cafe latte", 3500, false),
            new Tea(3, "Peppermint tea", 4000, false),
            new Tea(4, "Rooibos tea", 4500, false)
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product findById(int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
