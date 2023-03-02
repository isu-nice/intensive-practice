package oop_intensive.cafe_kiosk;

import oop_intensive.cafe_kiosk.discount.DiscountPolicy;
import oop_intensive.cafe_kiosk.products.Product;
import oop_intensive.cafe_kiosk.products.ProductRepository;

import java.util.Scanner;

public class Kiosk {

    private ProductRepository productRepository = new ProductRepository();
    private DiscountPolicy discountPolicy;

    public Kiosk(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    private Scanner scanner = new Scanner(System.in);

    public void operate() {
        printMenu();
        Product product = selectMenu();
        order(product);
    }

    private void order(Product product) {
        int price = discountPolicy.discount(product.getPrice());

        System.out.println("주문이 완료되었습니다. ");
        System.out.printf("주문 상품 : %s %s\n",
                product.getName(), product.getOptionToString());
        System.out.printf("가격 : %d\n", price);
    }

    private Product selectMenu() {
        int productId = Integer.parseInt(scanner.nextLine());
        return productRepository.findById(productId);
    }

    private void printMenu() {
        System.out.println("MENU");
        System.out.println("=".repeat(30));

        productRepository.getProducts()
                .forEach(product -> {
                    System.out.printf(
                            "(%d) %-15s %d\n",
                            product.getId(), product.getName(), product.getPrice());
                });

        System.out.println("=".repeat(30));
        System.out.println("메뉴의 번호를 입력하세요.");
    }
}
