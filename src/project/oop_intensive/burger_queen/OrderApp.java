package oop_intensive.burger_queen;

import oop_intensive.burger_queen.order.Cart;
import oop_intensive.burger_queen.order.Menu;
import oop_intensive.burger_queen.order.Order;
import oop_intensive.burger_queen.product.Product;
import oop_intensive.burger_queen.product.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class OrderApp {
    public void run() {

        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.getProducts();

        Menu menu = new Menu(products);
        Cart cart = new Cart(productRepository, menu);
        Order order = new Order(cart);

        System.out.println("🍔 BurgerQueen Order Service");

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
                } else if (1 <= menuNumber && menuNumber <= products.size()) {
                    cart.addToCart(menuNumber);
                }
            }

        }
    }
}
