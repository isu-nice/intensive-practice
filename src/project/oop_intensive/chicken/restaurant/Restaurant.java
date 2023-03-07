package oop_intensive.chicken.restaurant;

public class Restaurant {
    private String name;
    private String menu;
    private int menuPrice;

    public Restaurant(String name, String menu, int menuPrice) {
        this.name = name;
        this.menu = menu;
        this.menuPrice = menuPrice;
    }

    public String getName() {
        return name;
    }

    public String getMenu() {
        return menu;
    }

    public int getMenuPrice() {
        return menuPrice;
    }
}
