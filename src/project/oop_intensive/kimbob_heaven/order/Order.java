package oop_intensive.kimbob_heaven.order;

import oop_intensive.kimbob_heaven.product.Product;
import oop_intensive.kimbob_heaven.product.ProductRepository;

public class Order {

    private ProductRepository productRepository;

    public Order(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void makeOrder(int menuNumber, int menuAmount) {

        Product product = productRepository.findById(menuNumber);
        int totalPrice = computeTotalPrice(product, menuAmount);

        System.out.printf("[π£] μ£Όλ¬Ένμ  λ©λ΄μ μ΄ κΈμ‘μ %dμ μλλ€.\n", totalPrice);
    }

    private int computeTotalPrice(Product product, int amount) {
        return product.getPrice() * amount;
    }
}
