package oop_intensive.chicken.star;

import oop_intensive.chicken.order.Order;

public class Star {
    private Order order;
    private int number;

    public Star(Order order, int number) {
        this.order = order;
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
