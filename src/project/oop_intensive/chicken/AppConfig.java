package oop_intensive.chicken;

import oop_intensive.chicken.order.OrderRepository;
import oop_intensive.chicken.order.RegisterOrder;
import oop_intensive.chicken.restaurant.RegisterRestaurant;
import oop_intensive.chicken.restaurant.RestaurantRepository;
import oop_intensive.chicken.star.RegisterStar;
import oop_intensive.chicken.star.StarRepository;

public class AppConfig {
    private RestaurantRepository restaurantRepository = new RestaurantRepository();
    private OrderRepository orderRepository = new OrderRepository();
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
        return new RegisterOrder(orderRepository());
    }

    public StarRepository starRepository() {
        return starRepository;
    }

    public RegisterStar registerStar() {
        return new RegisterStar(starRepository());
    }
}
