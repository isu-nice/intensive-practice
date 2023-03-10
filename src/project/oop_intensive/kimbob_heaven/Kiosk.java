package oop_intensive.kimbob_heaven;

import oop_intensive.kimbob_heaven.order.Menu;
import oop_intensive.kimbob_heaven.order.Order;
import oop_intensive.kimbob_heaven.product.ProductRepository;

import java.util.Scanner;

public class Kiosk {
    private static final String CONTOUR = "=".repeat(60);
    public static final int MAXIMUM_AMOUNT = 99;
    private Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;
    private Menu menu;
    private Order order;

    public Kiosk(ProductRepository productRepository, Menu menu, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.order = order;
    }

    public void start() {
        System.out.println("[π£] μλνμΈμ. κΉλ°₯μ²κ΅­μ μ€μ  κ²μ νμν©λλ€.");
        System.out.println(CONTOUR);
        menu.printMenus();

        int menuNumber = inputMenuNumber();
        System.out.println(CONTOUR);

        int menuAmount = inputMenuAmount();
        order.makeOrder(menuNumber, menuAmount);

        System.out.println("[π£] μ΄μ©ν΄ μ£Όμμ κ°μ¬ν©λλ€.");
    }

    private int inputMenuAmount() {
        System.out.println("[π£] μ ννμ  λ©λ΄μ μλμ μλ ₯ν΄ μ£ΌμΈμ.");
        System.out.printf("(π‘ μ΅λ μ£Όλ¬Έ κ°λ₯ μλ : %d)\n", MAXIMUM_AMOUNT);
        int input = Integer.parseInt(scanner.nextLine());
        try {
            validateMenuAmount(input);
            return input;
        } catch (Exception e) {
            System.out.printf(e.getMessage(), input);
            System.out.println("[π¨] μλ μ ν νλ©΄μΌλ‘ λμκ°λλ€.\n" + CONTOUR);
            return inputMenuAmount();
        }
    }

    private void validateMenuAmount(int input) {
        if (input > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("[π¨] %dκ°λ μλ ₯νμ€ μ μμ΅λλ€.\n");
        }
    }

    private int inputMenuNumber() {
        try {
            String input = scanner.nextLine();
            validateMenuNumber(input);
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("[π¨] λ©λ΄μ ν¬ν¨λ λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.\n");
            menu.printMenus();
            return inputMenuNumber();
        }
    }

    private void validateMenuNumber(String input) {
        int menuNumber = Integer.parseInt(input);
        productRepository.getProducts().stream()
                .filter(product -> product.getId() == menuNumber)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
