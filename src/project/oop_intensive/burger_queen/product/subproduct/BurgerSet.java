package oop_intensive.burger_queen.product.subproduct;

import oop_intensive.burger_queen.product.Product;

public class BurgerSet extends Product {

    private Burger burger;
    private Side side;
    private Drink drink;

    public BurgerSet(String name, int price, int kcal, Burger burger,Side side,Drink drink) {
        super(name, price, kcal);
        this.burger = burger;
        this.side = side;
        this.drink = drink;
    }

    public Burger getBurger() {
        return burger;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}
