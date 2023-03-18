package oop_intensive.chicken.star;

import oop_intensive.chicken.order.Order;
import oop_intensive.chicken.order.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class StarRepository {
    private List<Star> stars;
    private OrderRepository orderRepository;

    public StarRepository(OrderRepository orderRepository) {
        this.stars = new ArrayList<>();
        this.orderRepository = orderRepository;
    }

    public Star find(Order order) {
        return stars.stream()
                .filter(star -> star.getOrder().equals(order))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void addStar(String customerName, String restaurantName, String menuName, String starNumber) {
        stars.add(new Star(
                orderRepository.find(customerName, restaurantName, menuName),
                Integer.parseInt(starNumber))
        );
    }
}
