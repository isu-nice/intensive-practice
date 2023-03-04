package oop_intensive.burger_queen.product.subproduct;

import oop_intensive.burger_queen.product.Product;

public class Burger extends Product {
    private boolean isBurgerSet;
    private int burgerSetPrice;

    public Burger(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    public Burger(Burger burger) {
        super(burger.getName(), burger.getPrice(), burger.getKcal());
        this.isBurgerSet = burger.isBurgerSet();
        this.burgerSetPrice = burger.getBurgerSetPrice();
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }

    public void setIsBurgerSet(boolean isBurgerSet) {
        this.isBurgerSet = isBurgerSet;
    }

    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }

    public void setBurgerSetPrice(int burgerSetPrice) {
        this.burgerSetPrice = burgerSetPrice;
    }
}
