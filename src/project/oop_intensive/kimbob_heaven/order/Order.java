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

        System.out.printf("[📣] 주문하신 메뉴의 총 금액은 %d원 입니다.\n", totalPrice);
    }

    private int computeTotalPrice(Product product, int amount) {
        return product.getPrice() * amount;
    }
}
