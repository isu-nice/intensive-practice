package oop_intensive.kimbob_heaven.order;

import oop_intensive.kimbob_heaven.product.Product;

import java.util.List;

public class Menu {

    private List<Product> products;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public void printMenus() {
        System.out.println("[π£] μνμλ λ©λ΄μ λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
        products.forEach(product -> {
            System.out.printf("%d) %s(%dμ) \n",
                    product.getId(), product.getName(), product.getPrice());
        });
    }
}
