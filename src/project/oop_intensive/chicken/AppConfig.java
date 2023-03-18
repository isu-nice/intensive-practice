package oop_intensive.chicken;

import oop_intensive.chicken.order.OrderRepository;
import oop_intensive.chicken.order.RegisterOrder;
import oop_intensive.chicken.restaurant.RegisterRestaurant;
import oop_intensive.chicken.restaurant.RestaurantRepository;
import oop_intensive.chicken.star.ManageStar;
import oop_intensive.chicken.star.StarRepository;

import java.util.ArrayList;

public class AppConfig {
    private RestaurantRepository restaurantRepository = new RestaurantRepository(new ArrayList<>());
    private OrderRepository orderRepository = new OrderRepository(new ArrayList<>());
    private StarRepository starRepository = new StarRepository(orderRepository());

    public RestaurantRepository restaurantRepository() {
        return restaurantRepository;
    }

    public RegisterRestaurant registerRestaurant() {
        return new RegisterRestaurant(restaurantRepository());
    }

    public OrderRepository orderRepository() {
        return orderRepository;
    }

    public RegisterOrder registerOrder() {
        return new RegisterOrder(orderRepository(), restaurantRepository());
    }

    public StarRepository starRepository() {
        return starRepository;
    }

    public ManageStar manageStar() {
        return new ManageStar(starRepository(), orderRepository());
    }
}
