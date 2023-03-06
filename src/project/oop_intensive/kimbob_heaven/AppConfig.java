package oop_intensive.kimbob_heaven;

import oop_intensive.kimbob_heaven.order.Menu;
import oop_intensive.kimbob_heaven.order.Order;
import oop_intensive.kimbob_heaven.product.ProductRepository;

public class AppConfig {
    private ProductRepository productRepository = new ProductRepository();

    public ProductRepository productRepository() {
        return productRepository;
    }

    public Menu menu() {
        return new Menu(productRepository().getProducts());
    }

    public Order order() {
        return new Order(productRepository());
    }
}
