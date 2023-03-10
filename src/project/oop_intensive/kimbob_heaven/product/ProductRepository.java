package oop_intensive.kimbob_heaven.product;

import java.util.List;

public class ProductRepository {
    private List<Product> products = List.of(
            new Product(1, "김밥", 1000),
            new Product(2, "계란 김밥", 1500),
            new Product(3, "충무 김밥", 1000),
            new Product(4, "떡볶이", 2000)
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product findById(int menuId) {
        return products.stream()
                .filter(menu -> menu.getId() == menuId)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
