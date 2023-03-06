package oop_intensive.burger_queen.discount.discountPolicy;

public class FixedAmountDiscountPolicy implements DiscountPolicy{

    private int discountAmount;

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int calculateDiscountPolicy(int price) {
        return price - discountAmount;
    }
}
