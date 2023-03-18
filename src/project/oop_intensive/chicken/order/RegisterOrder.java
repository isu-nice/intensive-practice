package oop_intensive.chicken.order;

import oop_intensive.chicken.restaurant.RestaurantRepository;
import oop_intensive.chicken.view.InputView;

import static oop_intensive.chicken.view.Guidance.INFO;

public class RegisterOrder {
    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;

    public RegisterOrder(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void makeOrder() {
        System.out.println(INFO + "고객님! 메뉴 주문을 진행하겠습니다!");
        System.out.println(INFO + "주문자 이름을 알려주세요!");
        String customerName = InputView.getUserInput();

        System.out.println(INFO + "주문할 음식점 상호는 무엇인가요?");
        String restaurantName = InputView.getUserInput();
        validateRestaurantName(restaurantName);

        System.out.println(INFO + "주문할 메뉴 이름을 알려주세요!");
        String menuName = InputView.getUserInput();
        validateMenuName(menuName);

        orderRepository.addOrder(
                new Order(customerName, restaurantName, menuName));

        System.out.println();
        System.out.printf(INFO + "%s님!\n", customerName);
        System.out.printf(INFO + "%s매장에 %s주문이 완료되었습니다.\n", restaurantName, menuName);
        System.out.println();
    }

    private void validateRestaurantName(String name) {
        restaurantRepository.getRestaurants()
                .stream()
                .filter(restaurant -> restaurant.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void validateMenuName(String name) {
        restaurantRepository.getRestaurants()
                .stream()
                .filter(restaurant -> restaurant.getMenu().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
