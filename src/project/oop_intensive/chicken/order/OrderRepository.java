package oop_intensive.chicken.order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Order find(String customerName, String restaurantName, String menuName) {
        return orders.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .filter(order -> order.getRestaurantName().equals(restaurantName))
                .filter(order -> order.getMenuName().equals(menuName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
