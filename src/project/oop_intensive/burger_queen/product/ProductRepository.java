package oop_intensive.burger_queen.product;

import oop_intensive.burger_queen.product.subproduct.Burger;
import oop_intensive.burger_queen.product.subproduct.Drink;
import oop_intensive.burger_queen.product.subproduct.Side;

import java.util.List;

public class ProductRepository {
    private final List<Product> products = List.of(
            new Burger(1, "새우버거", 3500, 500, false, 4500),
            new Burger(2, "치킨버거", 4000, 600, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "어니언링", 1000, 300, 1),
            new Drink(5, "코카콜라", 1000, 200, true),
            new Drink(6, "제로콜라", 1000, 0, true)
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
