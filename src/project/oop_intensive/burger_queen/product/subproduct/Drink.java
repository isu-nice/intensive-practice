package oop_intensive.burger_queen.product.subproduct;

import oop_intensive.burger_queen.product.Product;

public class Drink extends Product {
    private boolean withStraw;

    public Drink(int id, String name, int price, int kcal, boolean withStraw) {
        super(id, name, price, kcal);
        this.withStraw = withStraw;
    }

    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.withStraw = drink.isWithStraw();
    }

    public boolean isWithStraw() {
        return withStraw;
    }

    public void setWithStraw(boolean withStraw) {
        this.withStraw = withStraw;
    }
}
