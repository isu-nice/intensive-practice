package oop_intensive.chicken.restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurants;

    public RestaurantRepository() {
        this.restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant findByName(String restaurantName) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getName().equals(restaurantName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
