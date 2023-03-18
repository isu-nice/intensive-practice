package oop_intensive.chicken.order;

import java.util.Collections;
import java.util.List;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository(List<Order> orders) {
        this.orders = orders;
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

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
