package oop_intensive.burger_queen.discount.discountCondition;

public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}
