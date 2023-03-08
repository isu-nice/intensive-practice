package oop_intensive.chicken.order;

public class Order {
    private String customerName;
    private String restaurantName;
    private String menuName;

    public Order(String customerName, String restaurantName, String menuName) {
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.menuName = menuName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getMenuName() {
        return menuName;
    }
}
