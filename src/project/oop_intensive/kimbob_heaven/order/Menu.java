package oop_intensive.kimbob_heaven.order;

import oop_intensive.kimbob_heaven.product.Product;

import java.util.List;

public class Menu {

    private List<Product> products;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public void printMenus() {
        System.out.println("[📣] 원하시는 메뉴의 번호를 입력해주세요.");
        products.forEach(product -> {
            System.out.printf("%d) %s(%d원) \n",
                    product.getId(), product.getName(), product.getPrice());
        });
    }
}
