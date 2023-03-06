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
        System.out.println("[📣] 안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println(CONTOUR);
        menu.printMenus();

        int menuNumber = inputMenuNumber();
        System.out.println(CONTOUR);

        int menuAmount = inputMenuAmount();
        order.makeOrder(menuNumber, menuAmount);

        System.out.println("[📣] 이용해 주셔서 감사합니다.");
    }

    private int inputMenuAmount() {
        System.out.println("[📣] 선택하신 메뉴의 수량을 입력해 주세요.");
        System.out.printf("(💡 최대 주문 가능 수량 : %d)\n", MAXIMUM_AMOUNT);
        int input = Integer.parseInt(scanner.nextLine());
        try {
            validateMenuAmount(input);
            return input;
        } catch (Exception e) {
            System.out.printf(e.getMessage(), input);
            System.out.println("[🚨] 수량 선택 화면으로 돌아갑니다.\n" + CONTOUR);
            return inputMenuAmount();
        }
    }

    private void validateMenuAmount(int input) {
        if (input > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("[🚨] %d개는 입력하실 수 없습니다.\n");
        }
    }

    private int inputMenuNumber() {
        try {
            String input = scanner.nextLine();
            validateMenuNumber(input);
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("[🚨] 메뉴에 포함된 번호를 입력해주세요.\n");
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
