package oop_intensive.chicken.star;

import oop_intensive.chicken.order.Order;
import oop_intensive.chicken.order.OrderRepository;
import oop_intensive.chicken.view.InputView;
import oop_intensive.chicken.view.OutputView;

import java.util.List;

import static oop_intensive.chicken.view.Guidance.*;

public class ManageStar {
    private StarRepository starRepository;
    private OrderRepository orderRepository;

    public ManageStar(StarRepository starRepository, OrderRepository orderRepository) {
        this.starRepository = starRepository;
        this.orderRepository = orderRepository;
    }

    public void feedback() {
        System.out.println(INFO + "고객님! 별점 등록을 진행합니다.");
        System.out.println(INFO + "주문자 이름은 무엇인가요?");
        String customerName = InputView.getUserInput();
        validateCustomerName(customerName);

        System.out.println(INFO + "음식점 상호는 무엇인가요?");
        String restaurantName = InputView.getUserInput();
        validateRestaurantName(restaurantName);

        System.out.println(INFO + "주문하신 음식 이름은 무엇인가요?");
        String menuName = InputView.getUserInput();

        System.out.println(INFO + "음식 맛은 어떠셨나요? (1점 ~ 5점)");
        String starNumber = InputView.getUserInput();

        System.out.println();
        starRepository.addStar(customerName, restaurantName, menuName, starNumber);
        System.out.println(INFO + "리뷰 등록이 완료되었습니다.");
    }

    private void validateRestaurantName(String name) {
        orderRepository.getOrders()
                .stream()
                .filter(order -> order.getRestaurantName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void validateCustomerName(String name) {
        orderRepository.getOrders()
                .stream()
                .filter(order -> order.getCustomerName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }



    public void check() {
        List<Star> stars = starRepository.getStars();

        for (Star star : stars) {
            Order order = star.getOrder();

            System.out.println(order.getCustomerName() + CUSTOMER);
            System.out.println(CONTOUR);

            System.out.println("주문 매장 : " + order.getRestaurantName());
            System.out.println("주문 메뉴 : " + order.getMenuName());
            System.out.print("별점 : ");
            OutputView.printStars(star.getNumber());
            System.out.println();
        }
        System.out.println();
    }
}
