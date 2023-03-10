package oop_intensive.burger_queen;

import oop_intensive.burger_queen.order.Cart;
import oop_intensive.burger_queen.order.Menu;
import oop_intensive.burger_queen.order.Order;
import oop_intensive.burger_queen.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    public OrderApp(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("π BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if (input.equals("+")) {
                order.makeOrder();
                break;
            } else {
                int menuNumber = Integer.parseInt(input);

                if (menuNumber == 0) {
                    cart.printCart();
                } else if (1 <= menuNumber && menuNumber <= productRepository.getProducts().size()) {
                    cart.addToCart(menuNumber);
                }
            }
        }
        System.out.println("[π£] μ΄μ©ν΄μ£Όμμ κ°μ¬ν©λλ€.");
    }
}
