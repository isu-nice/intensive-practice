package oop_intensive.burger_queen.product.subproduct;

import oop_intensive.burger_queen.product.Product;

public class Side extends Product {
    private int ketchupNumber;

    public Side(int id, String name, int price, int kcal, int ketchupNumber) {
        super(id, name, price, kcal);
        this.ketchupNumber = ketchupNumber;
    }

    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.ketchupNumber = side.getKetchupNumber();
    }

    public int getKetchupNumber() {
        return ketchupNumber;
    }

    public void setKetchupNumber(int ketchupNumber) {
        this.ketchupNumber = ketchupNumber;
    }
}
