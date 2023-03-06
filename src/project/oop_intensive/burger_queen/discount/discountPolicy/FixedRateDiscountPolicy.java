package oop_intensive.burger_queen.discount.discountPolicy;

public class FixedRateDiscountPolicy implements DiscountPolicy {

    private int discountRate;

    public FixedRateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int calculateDiscountPolicy(int price) {
        return price - (price * discountRate / 100);
    }
}
