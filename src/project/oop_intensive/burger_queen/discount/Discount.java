package oop_intensive.burger_queen.discount;

import oop_intensive.burger_queen.discount.discountCondition.DiscountCondition;

import java.util.List;

public class Discount {
    private List<DiscountCondition> discountConditions;

    public Discount(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int discount(int price) {

        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
            if (discountCondition.isSatisfied()) {
                discountedPrice = discountCondition.applyDiscount(discountedPrice);
            }
        }
        return discountedPrice;
    }
}
